package design.designpatterns.behavioral.command.DocumentExample;

public class CopyCommand implements Command {
    private Document document;
    CopyCommand(){}
    CopyCommand(Document document){
        this.document=document;
    }
    @Override
    public void execute() {
        document.copy();
    }
}
