import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.WatchService;
import java.util.concurrent.*;

/**
 * Created by kamil on 25.12.15.
 */
public class Moje{

    ExecutorService executor = Executors.newFixedThreadPool(10);
    //Path path =
    //FileSystem fs = path.getFileSystem();
    //WatchService service = fs.newWatchService();
    public static void main(String[] args) {
        new Moje().start();

    }
    private void start() {
        for (int i = 0; i < 20; i++) {
            Future<Long> cos = executor.submit(new Testowy());
            try {
                System.out.println(cos.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(executor.isTerminated());
            //executor.submit(()-> System.out.println("cos"));
        }

/*        try {
            System.out.println("attempt to shutdown executor");
            //executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
*/
        executor.shutdown();
        System.out.println("done");
    }

}

class Testowy implements Callable<Long> {

    @Override
    public Long call() throws Exception {
       // String name = Thread.currentThread().getName();
       // System.out.println(name + " " +Thread.currentThread().getId());
        return Thread.currentThread().getId();
    }
}