package classic.comp.sci.problems.producerconsumerwithqueue.classes;

import classic.comp.sci.problems.producerconsumerwithqueue.interfaces.Broker;
import classic.comp.sci.problems.producerconsumerwithqueue.interfaces.Producer;

public class ProducerImpl implements Producer {
    Broker broker;

    public ProducerImpl(Broker broker) {
        this.broker = broker;
    }

    public void publish(String msg) {
        broker.publish(msg);
    }
}