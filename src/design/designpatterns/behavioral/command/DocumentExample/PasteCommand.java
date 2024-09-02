package design.designpatterns.behavioral.command.DocumentExample;

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
