package designpatterns.oldimplementations.ObserverPattern;

public interface Display {
    void display();
}

class CurrentScoreDisplay implements Display, Observer {
    //""
    void display(int score) {
        System.out.println("display: CurrentScoreDisplay => score: " + score);
    }

    @Override
    public void update(int score) {
        display(score);
    }

    @Override
    public void display() {

    }
}