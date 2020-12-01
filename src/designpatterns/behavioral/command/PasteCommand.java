package designpatterns.behavioral.command;

public class PasteCommand implements Command{
    private Document document;
    PasteCommand(){}
    PasteCommand(Document document){
        this.document=document;
    }

    @Override
    public void execute() {
        document.paste();
    }
}
