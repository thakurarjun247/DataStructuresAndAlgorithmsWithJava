package lowleveldesign.designpatterns.behavioral.command.DocumentExample;

public class Document {
    String text;

    public void paste() {

        text = text + "pasting some content";
        System.out.println("paste() method of Document");
    }

    public void copy() {

        text = text + "copying some content";

        System.out.println("copy() method of Document");
    }
}
