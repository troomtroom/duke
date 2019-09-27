public class ExitCommand extends Command {

    public ExitCommand() {

    }

    public void execute(TaskList tasks, IO io, Storage storage) {
        storage.savetofile(tasks);
    }

    public Boolean isExit() {
        return true;
    }
}


