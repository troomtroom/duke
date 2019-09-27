public class DoneCommand extends Command {

    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList tasks, IO io, Storage storage) {
        tasks.markdone(this.index);
    }

    public Boolean isExit() {
        return false;
    }
}