package design.designpatterns.behavioral.command.RobotExample;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

interface Command {
    void execute();

    void undo();
}

/*
* What is the Command Design Pattern?
The Command Design Pattern is a behavioral design pattern that encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.  

In simpler terms, it's like creating a wrapper for a request. This wrapper can be passed around, stored, or executed later. It decouples the object that issues the request from the object that knows how to fulfill it.

Why Use the Command Pattern?
Decoupling: Separates the object that invokes the operation from the one that knows how to perform it.
Parameterization: Allows you to pass commands as parameters to other methods.
Queuing and Logging: Commands can be stored for later execution or logging purposes.
Undo/Redo: By storing command objects, you can implement undo/redo functionality.
Macros and Scripting: Commands can be combined to form complex operations.
When to Use the Command Pattern
You should consider using the Command Pattern when:

You want to parameterize objects with different operations.
You need to specify, queue, or log requests.
You want to support undoable operations.
You want to structure a system with many independent objects.
How the Command Pattern Works
The Command Pattern involves four main components:

Command: This is the interface or abstract class that declares an execute method.
ConcreteCommand: This class implements the execute method and defines the action to be performed.
Invoker: This object holds a reference to a command object and is responsible for invoking the command's execute method.
Receiver: This is the object that actually performs the action.
* */
public class RobotApplication {
    public static void main(String[] args) {
        Robot robot = new Robot();
        List<Command> commands = Arrays.asList(
                new MoveLeftCommand(robot),
                new MoveLeftCommand(robot),
                new MoveLeftCommand(robot),
                new MoveLeftCommand(robot)

        );

        RobotController robotController = new RobotController();
        robotController.undoLastCommand();
        robotController.redoLastCommand();
        robotController.giveCommands(commands);
        robotController.executeCommands();
        robotController.undoLastCommand();
        robotController.redoLastCommand();
        System.out.println(robot.getPosition());
    }
}

class MoveLeftCommand implements Command {
    private final Robot robot;

    MoveLeftCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveLeft();
    }

    @Override
    public void undo() {
        robot.moveRight();
    }
}

class MoveRightCommand implements Command {
    private final Robot robot;

    MoveRightCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveRight();
    }

    @Override
    public void undo() {
        robot.moveLeft();
    }
}

class Robot {
    private int position;

    public Robot() {
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveLeft() {
        position--;
        System.out.println("Robot moved left to position " + position);
    }

    public void moveRight() {
        position++;
        System.out.println("Robot moved right to position " + position);
    }

    public void reset() {
        position = 0;
        System.out.println("Robot reset to position " + position);
    }


}

class RobotController {
    List<Command> commands;
    Stack<Command> commandStack = new Stack<>();
    Stack<Command> undoneCommandStack = new Stack<>();


    void giveCommands(List<Command> commands) {
        this.commands = commands;
        for (Command command : commands) {
            commandStack.push(command);
        }
    }

    void executeCommands() {
        for (Command command : commands)
            command.execute();
    }

    void redoLastCommand() {
        if (undoneCommandStack.isEmpty())
            System.out.println("nothing to redo");
        else {
            System.out.println("redoing...");
            undoneCommandStack.pop().execute();
        }
    }

    void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            undoneCommandStack.push(commandStack.peek());
            System.out.println("undoing...");
            commandStack.pop().undo();
        } else
            System.out.println("Nothing to undo");
    }


}
