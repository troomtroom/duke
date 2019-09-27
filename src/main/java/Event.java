class Event extends Task {

    Time at;

    public Event(String description, boolean isDone,String type,Time at) {
        super(description,isDone,type);
        this.type = "Event";
        this.at = at;
    }

    public String toString() {
        return ("[" + "E" + "]["
                + this.getStatusIcon() + "] "
                + this.description
                + " (at: " + this.at.showtime() + ")");

    }

    public Time getat() {
        return this.at;
    }
}