package designpatterns.behavioral.command.RobotExample;


import java.util.ArrayList;
import java.util.List;

public class RobotExample {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Command moveLeftCommand = new MoveLeftCommand(robot);
        Command moveRightCommand = new MoveRightCommand(robot);
        Command resetCommand= robot::reset;
        //same as
        // Command resetCommand= ()->robot.reset();
        List<Command> commandList = new ArrayList<>();
        commandList.add(moveRightCommand);
        commandList.add(moveLeftCommand);
        commandList.add(moveRightCommand);
        commandList.add(moveRightCommand);
        commandList.add(moveLeftCommand);
        commandList.add(resetCommand);

        commandList.forEach(Command::execute);
    }
}

interface Command {
    void execute();
}

class MoveLeftCommand implements Command {
    private Robot robot;

    MoveLeftCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveLeft();
    }
}

class MoveRightCommand implements Command {
    private Robot robot;

    MoveRightCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveRight();
    }
}

class Robot {
    private int position;

    public Robot() {
        position = 0;
    }

    public void moveLeft() {
        position--;
        System.out.println("Robot moved left to position " + position);
    }

    public void moveRight() {
        position++;
        System.out.println("Robot moved right to position " + position);
    }

    public  void reset(){
        position=0;
        System.out.println("Robot reset to position "+position);
    }
}
