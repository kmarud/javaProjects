
public class ProgramFactory {
    public void run() {
        FileReadWrite instance = new FileReadWrite();
        instance.readFromFile();
        instance.writeToFiles();
    }
}