import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman on 15.03.2016.
 */
public class Collections {

    public static void main(String[] args) {

        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP";

        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");

        for(String i : languages) {
            System.out.println("I want to learn " + i);
        }
    }
}
