package javaNIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class StreamIO {
    public static void main(String[] args) {
        //Reading a file using stream I/O
        Path file = Paths.get("E:\\Elca Docs\\data\\companies.csv");
        try (InputStream in = Files.newInputStream(file)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            List<String> list = new ArrayList<>();
            while((line = reader.readLine())!=null){
                list.add(line);
                System.out.println(line);
            }
            System.out.println("-----------------");
            list.stream().filter(p->p.contains("CH")).forEach(e-> System.out.println(e));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Creating and Writing a File by Using Stream I/O
        /*String s ="Hello Quang Viet!";
        byte data[] = s.getBytes();
        Path path = Paths.get("E:\\Data\\a.zip");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(path, CREATE, APPEND))) {
            out.write(data, 0, data.length);
            System.out.println("write success");
        } catch (IOException x) {
            System.err.println(x);
        }*/
    }
}
