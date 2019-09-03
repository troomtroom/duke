import java.io.*;
import java.util.*;
import java.util.Date;

public class Duke {
    static String line = "    ____________________________________________________________";
    public static LinkedList<Task> storage = new LinkedList<Task>(); 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(line);

        int count = 0;
        int taskaddnum = 0;
        while(true){
            String inputstring = sc.nextLine();
            if(inputstring.equals("bye")){
                // END //
                output("Bye. Hope to see you again soon!");
                break;
            }
            else if(inputstring.equals("list")){
                //   SHOW LIST //
                displaycurrentlist();
            }
            else if(inputstring.split(" ")[0].equals("done")){
                // MARKIN TASK DONE //
                //System.out.println(Integer.parseInt(inputstring.split(" ")[1]));
                try{
                    markdone(Integer.parseInt(inputstring.split(" ")[1]));
                }
                catch(Exception e){
                    output("☹ OOPS!!! The description of a done cannot be empty.");
                }
            }
            else if(inputstring.split(" ")[0].equals("delete")) {
                try{
                    delete(Integer.parseInt(inputstring.split(" ")[1]));
                }
                catch(Exception e){
                    output("☹ OOPS!!! The description of a delete cannot be empty.");
                }
            }
            else if(inputstring.split(" ")[0].equals("todo")){
                // ADD TASK TO LIST //
                try{
                    System.out.println(inputstring.substring(5));
                    add(taskaddnum+1, 
                        inputstring.substring(5),
                        false,
                        "ToDO",
                        new Date(),
                        new Date());
                    taskaddnum ++;
                }
                catch(Exception e){
                    output("☹ OOPS!!! The description of a todo cannot be empty.");
                }
            }   

            else if(inputstring.split(" ")[0].equals("deadline")){
                String bydate = " "+inputstring.split("/by ")[1];
                String[] seperated = bydate.split("/");
                String[] temp = seperated[2].split(" ");
                int year = Integer.parseInt(temp[0].trim());
                int month = Integer.parseInt(seperated[1].trim());
                int date = Integer.parseInt(seperated[0].trim());
                int hour = Integer.parseInt(temp[1].substring(0,2).trim());
                int second = Integer.parseInt(temp[1].substring(2,4).trim());
                try{
                    add(taskaddnum+1, 
                        inputstring.split("/by")[0].substring(9),
                        false,
                        "Deadline",
                        new Date(),//at
                        new Date(year,month,date,hour,second));//by
                    taskaddnum ++;
                }
                catch(Exception e){
                    output("☹ OOPS!!! The description of a deadline cannot be empty.");
                }
            }
            else if(inputstring.split(" ")[0].equals("event")){
                String bydate = " "+inputstring.split("/at ")[1];
                String[] seperated = bydate.split("/");
                String[] temp = seperated[2].split(" ");
                int year = Integer.parseInt(temp[0].trim());
                int month = Integer.parseInt(seperated[1].trim());
                int date = Integer.parseInt(seperated[0].trim());
                int hour = Integer.parseInt(temp[1].substring(0,2).trim());
                int second = Integer.parseInt(temp[1].substring(2,4).trim());
                try{
                    add(taskaddnum+1, 
                        inputstring.split("/at")[0].substring(6),
                        false,
                        "Event",
                        new Date(year,month,date,hour,second),//at
                        new Date());// /by 2/12/2019 1800
                    taskaddnum ++;
                }
                catch(Exception e){
                    output("☹ OOPS!!! The description of a event cannot be empty.");
                }
            }
            else{
                output("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
            count +=1;  
        }
    }

    public static void output(String word){
        System.out.println(line);
        System.out.println("    "+word);
        System.out.println(line);
    }

    public static void add(int count, String input, boolean status,String Type,Date at,Date by){
        //System.out.println(input);
        if(Type.equals("ToDO")){
            storage.add(new ToDO(input,status,Type));
            output("added: "+ storage.get(count-1));
        }
        else if(Type.equals("Event")){
            storage.add(new Event(input,status,Type,at));
            output("added: "+ storage.get(count-1));
        }  
        else if(Type.equals("Deadline")){
            storage.add(new Deadline(input,status,Type,by));
            output("added: "+ storage.get(count-1));
        }
        else{
            output("check error 1");
        }
    }

    public static void displaycurrentlist(){
        if(storage.size()>0){
            System.out.println(line);
            for(int i = 0; i<storage.size();i++)
                System.out.println((i+1) + "." + storage.get(i));
            System.out.println(line);
        }
        else{
            output("empty list");
        }
    }

    public static void delete(int index){
        index --;
        
        System.out.println(line);
        System.out.println("Noted. I've removed this task: ");
        System.out.println(storage.get(index));
        storage.remove(index);
        System.out.println("Now you have " + storage.size() + " tasks in the list.");
        System.out.println(line);
        
    }
    
    public static void markdone(int index){
        index --;
        if(storage.size()>0){
            System.out.println(line);
            System.out.println("     Nice! I've marked this task as done:");
            Task temp = storage.get(index);
            temp.changedone();
            storage.set(index,temp);
            System.out.println(storage.get(index));
            /** 
                String current = storage.get(index).substring(3);
                System.out.println("     Nice! I've marked this task as done:");    
                
                String donecurrent = "[\u2713]"+current;
                storage.add(index, donecurrent);
                System.out.println("       "+donecurrent);
            */
            System.out.println(line);
            
        }
        else{
            output("storage is empty, does not exist");
        }

    }
}
