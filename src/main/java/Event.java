import java.util.Date;
class Event extends Task{
    
    Date at;
    public Event(String description, boolean isDone,String type,Date at){
        super(description,isDone,type);
        this.type = "Event";
        this.at = at;
    }
    public String toString(){
        return( "[" + "E" + "][" + 
                this.getStatusIcon() + "] " + 
                this.description + 
                " (at: "+this.at + ")"
                );
    }
}
