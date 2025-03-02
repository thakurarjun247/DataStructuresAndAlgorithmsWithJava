package classicalcompsciproblems.producerconsumerwithqueue.classes;

import classicalcompsciproblems.producerconsumerwithqueue.interfaces.Broker;
import classicalcompsciproblems.producerconsumerwithqueue.interfaces.Consumer;

public class ConsumerImpl implements Consumer {
    Broker broker;
    String groupId;

    public ConsumerImpl(String groupId, Broker broker) {
        this.groupId = groupId;
        this.broker = broker;
    }

    @Override
    public String getGroupId() {
        return this.groupId;
    }

    @Override
    public void consume() {
        System.out.println("consumer with group-id " + getGroupId() + " consuming message: " + broker.consume(this.groupId));
    }

    @Override
    public void register() {
        broker.registerNewConsumer(this);
    }


}

