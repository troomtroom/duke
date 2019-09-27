class Event extends Task {

    Time at;

    public Event(String description, boolean isDone,String type,Time at) {
        super(description,isDone,type);
        this.type = "Event";
        this.at = at;
    }

    public String toString() {
        return ("[" + "E" + "]["
<<<<<<< HEAD
                + this.getStatusIcon()
                + "] "
                + this.description
                + " (at: "
                + this.at.showtime()
                + ")"
        );
=======
                + this.getStatusIcon() + "] "
                + this.description
                + " (at: " + this.at.showtime() + ")");
>>>>>>> 2cdf26903eca468a95ad9d9258119cf03d743147
    }

    public Time getat() {
        return this.at;
    }
}