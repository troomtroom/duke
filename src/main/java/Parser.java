public class Parser {

    /**
     * takes string and returns command.
     *
     * @param inputstring is the text to be converted to command.
     * @return Command of required type.
     */
    public static Command parse(String inputstring) {
        if (inputstring.equals("bye")) {
            return new ExitCommand();
        } else if (inputstring.equals("list")) {
            return new ListCommand();
        } else if (inputstring.split(" ")[0].equals("done")) {
            try {
                return new DoneCommand(Integer.parseInt(inputstring.split(" ")[1]));
            } catch (Exception e) {
                IO.output("â˜¹ OOPS!!! The description of a done cannot be empty.");
                return new IlleagalCommand();
            }
        } else if (inputstring.split(" ")[0].equals("delete")) {
            try {
                return new DeleteCommand(Integer.parseInt(inputstring.split(" ")[1]));
            } catch (Exception e) {
                IO.output("â˜¹ OOPS!!! The description of a delete cannot be empty.");
                return new IlleagalCommand();
            }
        } else if (inputstring.split(" ")[0].equals("find")) {
            try {
                return new FindCommand(inputstring.split(" ")[1]);
            } catch (Exception e) {
                System.out.println("â˜¹ OOPS!!! The Keyword of a find cannot be empty");
                return new IlleagalCommand();
            }
        } else if (inputstring.split(" ")[0].equals("todo")) {
            try {
                return new AddCommand(new ToDO(inputstring.substring(5),false,"ToDO"));
            } catch (Exception e) {
                System.out.println("â˜¹ OOPS!!! The description of a todo cannot be empty");
                return new IlleagalCommand();
            }
        } else if (inputstring.split(" ")[0].equals("deadline")) {
            try {
                String byString = " " + inputstring.split("/by ")[1];
                String[] seperated = byString.split("/");
                String[] temp = seperated[2].split(" ");
                int year = Integer.parseInt(temp[0].trim());
                int month = Integer.parseInt(seperated[1].trim());
                int day = Integer.parseInt(seperated[0].trim());
                int hour = Integer.parseInt(temp[1].substring(0,2).trim());
                int minute = Integer.parseInt(temp[1].substring(2,4).trim());

                return new AddCommand(new Deadline(inputstring.split("/by")[0].substring(9),
                        false,
                        "Deadline",
                        new Time(year, month, day, hour, minute)));//by

            } catch (Exception e) {
                IO.output("â˜¹ OOPS!!! The description of a deadline is wrong");
                return new IlleagalCommand();
            }
        } else if (inputstring.split(" ")[0].equals("event")) {
            try {
                String byString = " " + inputstring.split("/at ")[1];
                String[] seperated = byString.split("/");
                String[] temp = seperated[2].split(" ");
                int year = Integer.parseInt(temp[0].trim());
                int month = Integer.parseInt(seperated[1].trim());
                int day = Integer.parseInt(seperated[0].trim());
                int hour = Integer.parseInt(temp[1].substring(0,2).trim());
                int minute = Integer.parseInt(temp[1].substring(2,4).trim());

                return new AddCommand(new Event(inputstring.split("/at")[0].substring(6),
                        false,
                        "Event",
                        new Time(year, month, day, hour, minute)));// /by 2/12/2019 1800
            } catch (Exception e) {
                IO.output("â˜¹ OOPS!!! The description of a event cannot be empty.");
                return new IlleagalCommand();
            }
        } else {
            return new IlleagalCommand();
        }
    }
}