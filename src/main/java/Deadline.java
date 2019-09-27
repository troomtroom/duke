class Deadline extends Task {

    Time by;

    public Deadline(String description, boolean isDone,String type,Time by) {
        super(description,isDone,type);
        this.type = "Deadline";
        this.by = by;
    }

    public String toString() {
<<<<<<< HEAD
        return ("[" + "D" + "][" + this.getStatusIcon() + "] "
                + this.description
                + " (by: " + this.by.showtime() + ")"
        );
=======
        return ("[" + "D" + "]["
                + this.getStatusIcon() + "] "
                + this.description + " (by: "
                + this.by.showtime() + ")");
>>>>>>> 2cdf26903eca468a95ad9d9258119cf03d743147
    }

    public Time getby() {
        return this.by;
    }
}