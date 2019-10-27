import java.util.Scanner;

public class IO {

    private static String line = "    ____________________________________________________________";
    private Scanner sc = new Scanner(System.in);

    public IO() {

    }

    /**
     * starting graphic and intro. 
     */
    public static void start() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        output("Hello from\n" + logo);
    }

    public static void showLine() {
        System.out.println(line);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * prints out String between 2 lines.
     *
     * @param word passed to print.
     */
    public static void output(String word) {
        IO.showLine();
        System.out.println("    " + word);
        IO.showLine();
    }

    /**
     * displays the current status of the TaskList.
     *
     * @param task the tasklist to be printed.
     */
    public static void displaycurrentlist(TaskList task) {
        if (task.storage.size() > 0) {
            IO.showLine();
            for (int i = 0; i < task.storage.size(); i++) {
                System.out.println((i + 1) + "." + task.storage.get(i));
            }
            showLine();
        } else {
            output("empty list");
        }
    }

    public void showLoadingError(String desc) {
        output("Error couldnt load : " + desc);
    }

    public void showError(String desc) {
        output("Error :" + desc);
    }
}