import java.util.Date;

class Deadline extends Task{
    
    Date by;

    public Deadline(String description, boolean isDone,String type,Date by){
        super(description,isDone,type);
        this.type = "Deadline";
        this.by = by;
    }
    public String toString(){
        return("[" + "D" + "][" + 
                this.getStatusIcon() +
                "] " + 
                this.description + 
                " (by: " + this.by +")"
                );
    }
}
