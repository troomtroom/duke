abstract class Command {

    abstract Boolean isExit();

    abstract void execute(TaskList tasks, IO io, Storage storage);

    public Command() {
    }
}
