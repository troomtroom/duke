import java.io.File;

public class Run {

    public static String filepath = "warehouse.txt";

    /**
     * Run initiates the application with a load file.
     *
     */
    public static void main(String[] args) {
        new Duke(filepath).run();
    }
}
