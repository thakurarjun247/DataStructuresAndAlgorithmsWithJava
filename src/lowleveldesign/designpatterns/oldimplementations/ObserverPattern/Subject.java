package lowleveldesign.designpatterns.oldimplementations.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

//this is the data producer
public interface Subject {
    void registerObjserver(Observer observer);

    void unregisterObjserver(Observer observer);

    void sendUpdates();
}

class SubjectImpl implements Subject {
    int score;
    List<Observer> objservers;

    SubjectImpl() {
        objservers = new ArrayList<Observer>();
        score = 0;
    }


    @Override
    public void registerObjserver(Observer observer) {
        objservers.add(observer);
    }

    @Override
    public void unregisterObjserver(Observer observer) {
        objservers.remove(observer);
    }

    @Override
    public void sendUpdates() {
        for (Observer o : objservers) {
            o.update(score);
        }
    }
}
