class Event extends Task{
    
    String range;
    public Event(String description, boolean isDone,String type,String range){
        super(description,isDone,type);
        this.type = "Event";
        this.range = range;
    }
    public String toString(){
        return( "[" + "E" + "][" + 
                this.getStatusIcon() + "] " + 
                this.description + 
                " (at: "+this.range + ")"
                );
    }
}
