package design.designpatterns.clrs.designpatterns.ObserverPattern;

public interface Observer {
    void update(int score);
}
/*class ObserverImpl implements Observer{
    int score;
    @Override
    public void update(int score) {
        this.score=score;
    }
}*/
