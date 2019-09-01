import java.util.ArrayList;
import java.util.List;

public class Task {

    public static final String DESCRIPTION_PREFIX = "Description: ";

    private String description;
    private boolean isImportant;

    /* //a list of past descriptions
    List<String> pastDescriptions = new ArrayList<>(); 
    */

    public Task(String description) {
        this.description = description;
        if (!description.isEmpty()) {
            this.isImportant = true;
        }
    }

    public String getAsXml() { 
        return "<task>" + this.description + "</task>"; 
    }

    /**
     * Prints the description as a String.
     */
    public void printDescription() { 
        System.out.println(this); 
    }

    @Override
    public String toString() { 
        return Task.DESCRIPTION_PREFIX + this.description; 
    }

}