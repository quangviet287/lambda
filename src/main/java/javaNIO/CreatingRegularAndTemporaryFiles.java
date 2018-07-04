package javaNIO;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingRegularAndTemporaryFiles {
    public static void main(String[] args) {
        Path file = Paths.get("E:\\Data\\Test.txt");
        try {
            // Create the empty file with default permissions, etc.
//            Files.createFile(file);
            //Creating Temporary Files
            Path tempFile = Files.createTempFile(null, ".myapp");
            System.out.format("The temporary file" +
                    " has been created: %s%n", tempFile);
        } catch (FileAlreadyExistsException x) {
            System.err.format("file named %s" +
                    " already exists%n", file);
        } catch (IOException x) {
            // Some other sort of failure, such as permissions.
            System.err.format("createFile error: %s%n", x);
        }
    }
}
