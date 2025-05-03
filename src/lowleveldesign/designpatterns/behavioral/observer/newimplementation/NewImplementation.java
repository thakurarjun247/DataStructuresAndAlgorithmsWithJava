package lowleveldesign.designpatterns.behavioral.observer.newimplementation;

import java.util.ArrayList;
import java.util.List;

public class NewImplementation {
    public static void main(String[] a){
        ConcreteSubject subject = new ConcreteSubject();
        for(int i=1;i<5;i++){
            subject.setProperty(i);
        }


    }
}

interface NewGenericObserver {
    void notify(ConcreteSubject concreteSubject);
}
class MyConcreteObserver implements NewGenericObserver {


    @Override
    public void notify(ConcreteSubject concreteSubject) {
        System.out.println("notified: subject state changed to "+concreteSubject.getProperty());

    }
}
interface Subject{
    void registerObserver(NewGenericObserver myObserver);
    void removeObserver();

    void removeObserver(NewGenericObserver myObserver);

    void notifyObservers();

    String getProperty();
}

class ConcreteSubject implements Subject{
    int property;

    public void setProperty(int property) {

        System.out.println("subject property changed from "+this.property);
        this.property = property;
        System.out.println("to "+this.property );
        System.out.println("notifying...");
        notifyObservers();

    }

    public List<NewGenericObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<NewGenericObserver> observers) {
        this.observers = observers;
    }

    List<NewGenericObserver> observers;

    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(NewGenericObserver myObserver) {
        observers.add(myObserver);
    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void removeObserver(NewGenericObserver myObserver) {
observers.remove(myObserver);
    }

    @Override
    public void notifyObservers() {
        for(NewGenericObserver observer:observers){
            observer.notify(this);
        }

    }

    @Override
    public String getProperty() {
        return null;
    }
}