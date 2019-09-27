class ToDO extends Task {
    public ToDO(String description, boolean isDone,String type) {
        super(description,isDone,type);
        this.type = "ToDO";
    }

    public String toString() {
        //System.out.println(this.description);
        return ("[" + "T" + "][" + this.getStatusIcon() + "] " + this.description);
    }

}