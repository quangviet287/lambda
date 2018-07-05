package javaNIO.companies;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class RandomAccessFile {
    public static void main(String[] args) {
        Path file = Paths.get("D:\\data\\a.txt");
        String s = "Hello Quang Viet";
        byte data[] = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);
        ByteBuffer copy = ByteBuffer.allocate(12);
        try(FileChannel fc = (FileChannel.open(file, READ, WRITE))){
            int nread;
            do{
                nread = fc.read(copy);
            }while (nread != -1 && copy.hasRemaining());

            fc.position(0);
            while (out.hasRemaining())
                fc.write(out);
            out.rewind();

            long length = fc.size();
            fc.position(length -1);
            copy.flip();
            while (copy.hasRemaining())
                fc.write(copy);
            while (out.hasRemaining())
                fc.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
