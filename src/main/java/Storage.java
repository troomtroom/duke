import java.util.LinkedList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.File;

public class Storage {

    String file;

    public Storage(String file) {
        this.file = file;
    }

    /**
     * Loads from textfile into TaskList.
     *
     * @return Loaded LinkedList of Tasks
     * @throws FileNotFoundException if the passed file is absent
     */
    public LinkedList<Task> loadtext() throws FileNotFoundException {
        String filetext = this.file;
        File inpfile = new File(filetext);
        Scanner filereader = new Scanner(inpfile);
        LinkedList<Task> storage = new LinkedList<>();

        try {
            while (filereader.hasNextLine()) {
                String nextline = filereader.nextLine();
                //System.out.println(" lklklklkl  "+nextline);
                String[] array = nextline.split(";");
                //System.out.println(array[0]+array[1]);
                String type = array[0];
                String description = array[2];
                Boolean doneval = false;

                if (array[1].equals("False")) {
                    doneval = false;
                } else if (array[1].equals("True")) {
                    doneval = true;
                } else {
                    IO.output("check error 5  " + array[1]);
                }
                //output(Arrays.toString(array));


                if (type.equals("T")) {
                    storage.add(new ToDO(description,doneval,"TODO"));
                } else if (type.equals("E")) {
                    storage.add(new Event(description, doneval, "Event",strToTime(array[3])));
                } else if (type.equals("D")) {
                    storage.add(new Deadline(description,doneval,"Deadline",strToTime(array[3])));
                }
            }

        } catch (Exception a) {
            IO.output("error 3");
            a.printStackTrace();
        }
        return storage;
    }

    /**
     * helps to convert string to time object.
     *
     * @param input string to be converted
     * @return Time value
     */
    public static Time strToTime(String input) {
        // 2021 4 1 19 23
        String[] div = input.split(" ");
        int day = Integer.parseInt(div[0]);
        int month = Integer.parseInt(div[1]);
        int year = Integer.parseInt(div[2]);
        int hour = Integer.parseInt(div[3]);
        int minute = Integer.parseInt(div[4]);
        return new Time(day,month,year, hour,minute);
    }

    /**
     * saves TaskList to file.
     *
     * @param tasks list passed to be saved to file
     */
    public void savetofile(TaskList tasks) {
        String entrystring = "";

        for (int i = 0; i < tasks.storage.size(); i++) {
            Task ob = tasks.storage.get(i);
            if (ob.getType().equals("ToDO")) {
                entrystring += ob.getLetterType() + ";"
                        + ob.getisDone() + ";"
                        + ob.getDescription() + ";"
                        + "\n";
            } else if (ob.getType().equals("Deadline")) {
                entrystring += ob.getLetterType() + ";"
                        + ob.getisDone() + ";"
                        + ob.getDescription() + ";"
                        + ((Deadline)ob).getby() + ";"
                        + "\n";
            } else if (ob.getType().equals("Event")) {
                entrystring += ob.getLetterType() + ";"
                        + ob.getisDone() + ";"
                        + ob.getDescription() + ";"
                        + ((Event)ob).getat() + ";"
                        + "\n";
            } else {
                IO.output("check error 3");
            }
        }
        try {
            FileWriter fw = new FileWriter("/mnt/c/users/kartike/desktop/nus/semester3/cs2103/duke/data/warehouse.txt");
            fw.write(entrystring);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}