package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    int getTemprature();
}

interface Observer {
    void update(Subject subject);
}

public class ObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        // ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.setTemprature(10);
        subject.setTemprature(20);
    }
}

class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int temprature;

    public int getTemprature() {

        return temprature;
    }

    public void setTemprature(int temprature) {
        this.temprature = temprature;
        notifyObservers();


    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

class ConcreteObserver implements Observer {
    private Subject subject;
    private int observerState;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject) {
        this.subject = subject;
        System.out.println("Observer notified, subject's temprature changed to " + subject.getTemprature());
    }
}

