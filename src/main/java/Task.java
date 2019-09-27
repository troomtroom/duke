abstract class Task {
    String description;
    boolean isDone;
    String type;

    public Task(String description, boolean isDone, String type) {
        this.description = description;
        this.isDone = false;
        this.type = type;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription() {
        return this.description;
    }

    public String getisDone() {
        return this.isDone ? "True" : "False";
    }

    public String getType() {
        return this.type;
    }

    public String getLetterType() {
        //System.out.println(this.getClass());
        if (this.type.equals("ToDO")) {
            return "T";
        } else if (this.type.equals("Event")) {
            return "D";
        } else {
            return "E";
        }
    }

    public String toString() {
        return ("[" + this.type.charAt(0) + "][" + this.getStatusIcon() + "] " + this.description);
    }

    public boolean changedone() {
        this.isDone = ! (isDone);
        return this.isDone;
        //isDone ? this.isDone = false : this.isDone = true;
    }

}