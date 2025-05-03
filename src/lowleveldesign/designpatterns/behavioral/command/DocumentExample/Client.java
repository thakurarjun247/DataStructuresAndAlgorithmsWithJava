package lowleveldesign.designpatterns.behavioral.command.DocumentExample;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Document document = new Document();
        Command command = new CopyCommand(document);
        Command command1 = new PasteCommand(document);
        List<Command> commandList = Arrays.asList(command, command1);
        commandList.forEach(cmd -> cmd.execute());
        System.out.println(document.text);

    }

}
