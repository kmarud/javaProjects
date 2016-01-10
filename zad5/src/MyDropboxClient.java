import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.*;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyDropboxClient {

    ExecutorService executor = Executors.newFixedThreadPool(PropertiesReader.threadPool);

    public void getDirectoryToWatch(){
        File dir = new File(PropertiesReader.folderToWatch);
        watchDirectoryPath(dir.toPath());
    }

    public void watchDirectoryPath(Path path) {
        try {
            Boolean isFolder = (Boolean) Files.getAttribute(path,
                    "basic:isDirectory", NOFOLLOW_LINKS);
            if (!isFolder) {
                throw new IllegalArgumentException("Ścieżka: " + path
                        + " nie jest katalogiem");
            }
        } catch (IOException ioe) {
            System.out.println("Katalog: " + path
                    + " nie istnieje !");
        }

        System.out.println("Obserwowany katalog: " + path);

        executor.submit(new StatisticThread());

        FileSystem fs = path.getFileSystem();

        try (WatchService service = fs.newWatchService()) {

            path.register(service, ENTRY_CREATE);

            WatchKey key;

            while (true) {
                key = service.take();

                Kind<?> kind;
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    kind = watchEvent.kind();

                    if (kind == OVERFLOW) {
                        continue; // loop

                    } else if (kind == ENTRY_CREATE) {
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();

                        executor.submit(new SendFileThread(newPath.toString(), DropboxAutorization.client));//, executor));
                        System.out.println("Rozpoczęto przesyłanie pliku: " + newPath);

                    }
                }
                if (!key.reset()) {
                    break; // loop
                }
            }

        } catch (Exception ioe) {
            System.out.println("cos poszlo nie tak");
        }finally {
            System.out.println("asd");
        }
    }
}

