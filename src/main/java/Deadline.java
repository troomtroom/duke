class Deadline extends Task{
    
    String time;

    public Deadline(String description, boolean isDone,String type,String time){
        super(description,isDone,type);
        this.type = "Deadline";
        this.time = time;
    }
    public String toString(){
        return("[" + "D" + "][" + 
                this.getStatusIcon() +
                "] " + 
                this.description + 
                " (by: " + this.time +")"
                );
    }
}
