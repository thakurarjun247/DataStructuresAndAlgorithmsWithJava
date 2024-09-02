package classicalcompsciproblems.producerconsumerwithqueue.classes;

import classicalcompsciproblems.producerconsumerwithqueue.interfaces.Broker;
import classicalcompsciproblems.producerconsumerwithqueue.interfaces.Producer;

public class ProducerImpl implements Producer {
    Broker broker;

    public ProducerImpl(Broker broker) {
        this.broker = broker;
    }

    public void publish(String msg) {
        broker.publish(msg);
    }
}