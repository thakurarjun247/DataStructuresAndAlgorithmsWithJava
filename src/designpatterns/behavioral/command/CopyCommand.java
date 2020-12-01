package designpatterns.behavioral.command;

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
