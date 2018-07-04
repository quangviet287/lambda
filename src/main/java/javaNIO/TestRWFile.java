package javaNIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestRWFile {
    public static void main(String[] args) {
        Path file = Paths.get("E:\\Elca Docs\\data\\companies.csv");
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file,charset)) {
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
       /* String s = "E:\\Data\\test1.txt";
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writer.write(s, 0, s.length());
            System.out.println("write success");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }*/
    }
}
