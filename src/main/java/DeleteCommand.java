public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList tasks, IO io, Storage storage) {
        tasks.delete(this.index);
    }

    public Boolean isExit() {
        return false;
    }
}