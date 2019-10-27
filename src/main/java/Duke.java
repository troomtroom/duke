// Level-10
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private IO io;

    /**
     * runs main loop for the project.
     *
     * @param filePath argument file location
     */
    public Duke(String filePath) {
        io = new IO();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadtext());
        } catch (Exception e) {
            io.showLoadingError("file error  " + e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Parser and executes commands one at a time.
     */
    public void run() {
        IO.start();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = io.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, io, storage);
                isExit = c.isExit();
            } catch (Exception e) {
                io.showError(e.getMessage());
            } finally {
                IO.showLine();
            }
        }
    }
}
