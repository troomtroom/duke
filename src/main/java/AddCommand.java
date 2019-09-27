public class AddCommand extends Command {

    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    public void execute(TaskList tasks, IO io, Storage storage) {
        tasks.storage.add(task);
    }

    public Boolean isExit() {
        return false;
    }
}
