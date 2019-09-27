public class ListCommand extends Command {

    private Task task;

    public ListCommand() {

    }

    public void execute(TaskList tasks, IO io, Storage storage) {
        IO.displaycurrentlist(tasks);
    }

    public Boolean isExit() {
        return false;
    }
}