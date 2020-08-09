import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomainNames {
    public static void main(String[] args) {
        List<String> extensions= Arrays.asList("school", "expert", "coach", "guide", "academy", "careers", "education", "training", "institute", "guru", "com", "co", "io");
        List<String> names=Arrays.asList("interviewprep", "techinterviewprep", "interview", "techinterview", "csinterview", "cs", "dsalgo", "algo", "computerscience","tech", "compsci" );
        StringBuilder builder= new StringBuilder();
        names
                .forEach(
                        name -> extensions
                                .forEach(extension -> builder.append(name+"."+extension+", ")));
        String output=builder.toString();
        String formattedOutput= output.substring(0, output.length()-2);
        System.out.println(formattedOutput);
    }
}
