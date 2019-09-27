import java.util.LinkedList;

public class TaskList {

    LinkedList<Task> storage;

    public TaskList(LinkedList<Task> storage) {
        this.storage = storage;
    }

    public TaskList() {

    }

    /**
     * deletes from passed object at index.
     *
     * @param index point of deletion
     */
    public void delete(int index) {
        if (storage.size() > 0) {
            IO.showLine();
            System.out.println("    Noted. I've removed this task: ");
            System.out.println(this.storage.get(index - 1));
            this.storage.remove(index - 1);
            System.out.println("Now you have " + storage.size() + " tasks in the list.");
            IO.showLine();
        } else {
            IO.output("storage is empty, nothing to delete");
        }
    }

    /**
     * marks index element done from passed object.
     *
     * @param index index of object to be marked done
     */
    public void markdone(int index) {
        if (storage.size() > 0) {
            IO.showLine();
            System.out.println("     Nice! I've marked this task as done:");
            Task temp = this.storage.get(index - 1);
            temp.changedone();
            this.storage.set(index - 1,temp);
            System.out.println(this.storage.get(index - 1));
            IO.showLine();

        } else {
            IO.output("storage is empty, nothing to markdone");
        }
    }
}