class Deadline extends Task{
    
   Date ;

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

    public String getTime(){
        return this.time;
    }
}
