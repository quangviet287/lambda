package watchservice;

import java.io.IOException;
import java.nio.file.*;

public class WatchServiceTest {

    public static void main(String[] args) {


        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get("E:\\Data");
            WatchKey key = dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            for (;;) {

                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if (key == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }

                    WatchEvent<Path> ev = (WatchEvent<Path>)event;
                    Path fileName = ev.context();

                    Path child = dir.resolve(fileName);
                    if (!Files.probeContentType(child).equals("text/plain")) {
                        System.err.format("New file '%s'" +
                                " is not a plain text file.%n", fileName);
                        continue;
                    }

                    System.out.format("Emailing file %s%n", fileName);
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
