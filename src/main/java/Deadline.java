class Deadline extends Task {

    Time by;

    public Deadline(String description, boolean isDone,String type,Time by) {
        super(description,isDone,type);
        this.type = "Deadline";
        this.by = by;
    }

    public String toString() {

        return ("[" + "D" + "]["
                + this.getStatusIcon() + "] "
                + this.description + " (by: "
                + this.by.showtime() + ")");

    }

    public Time getby() {
        return this.by;
    }
}