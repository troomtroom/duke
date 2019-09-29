public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find task in list.
     *
     * @param tasks task list
     * @param io IO class instance
     * @param storage for IO to storage files
     */
    public void execute(TaskList tasks, IO io, Storage storage) {
        int foundcount = 0;
        if (tasks.storage.size() > 0) {
            IO.showLine();
            for (int i = 0; i < tasks.storage.size(); i++) {
                if (tasks.storage.get(i).getDescription().contains(keyword)) {
                    System.out.println((i + 1) + "." + tasks.storage.get(i));
                    foundcount++;
                }
            }
            if (foundcount == 0) {
                IO.output("Nothing Available with : " + keyword);
            }
            IO.showLine();
        } else {
            IO.output("NoTasks available");
        }
    }

    public Boolean isExit() {
        return false;
    }
}


