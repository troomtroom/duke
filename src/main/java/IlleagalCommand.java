public class IlleagalCommand extends Command {

    public  IlleagalCommand() {
        // returns nothing
    }

    public void execute(TaskList tasks, IO io, Storage storage) {
        IO.output("Error, the command was not recognised.");
    }

    public Boolean isExit() {
        return false;
    }
}