import java.io.*;
import java.util.*;

public class Duke {
    static String line = "    ____________________________________________________________";
    static LinkedList<String> storage = new LinkedList<String>(); 
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
        while(true){
            String inputstring = sc.nextLine();
            if(inputstring.equals("bye")){
                output("Bye. Hope to see you again soon!");
                break;
            }
            else if(inputstring.equals("list")){
                displaycurrentlist();
            }
            else{
                add(inputstring,count);
                //output(inputstring);
            }    
            count +=1;
            //System.out.println(line);
        }
    }

    public static void output(String word){
        System.out.println(line);
        System.out.println("    "+word);
        System.out.println(line);
    }
    public static void add(String input, int count){
        storage.add(input);
        output("added: "+input);
    }
    public static void displaycurrentlist(){
        if(storage.size()>0){
            System.out.println(line);
            for(int i = 0; i<storage.size();i++){
                int index = i+1;
                System.out.println("    "+index+". "+storage.get(i));
            }
            System.out.println(line);
        }
        else{
            output("empty list");
        }
    }
}
