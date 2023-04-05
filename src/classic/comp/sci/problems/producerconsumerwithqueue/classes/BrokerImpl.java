package classic.comp.sci.problems.producerconsumerwithqueue.classes;

import classic.comp.sci.problems.producerconsumerwithqueue.interfaces.Broker;
import classic.comp.sci.problems.producerconsumerwithqueue.interfaces.Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrokerImpl implements Broker {
    List<String> messageQueue;
    Map<String, Integer> groupIdTolastIndexRead;
    List<Consumer> consumers;

    public BrokerImpl() {
        messageQueue = new ArrayList<>();
        consumers = new ArrayList<>();
        groupIdTolastIndexRead = new HashMap<>();
    }

    public void addSub(Consumer sub) {
        consumers.add(sub);
        groupIdTolastIndexRead.put(sub.getGroupId(), -1);
    }

    void removeSub(Consumer sub) {
        consumers.remove(sub);
    }


    public void publish(String msg) {
        messageQueue.add(msg);
        System.out.println("Publisher publishing the message: " + msg);

    }

    public String consume(String groupId) {

        Integer offsetOfLastMessageReadByThisGroupId = groupIdTolastIndexRead.get(groupId);

        Integer nextOffsetToBeRead = offsetOfLastMessageReadByThisGroupId + 1;
        if (nextOffsetToBeRead >= messageQueue.size()) {
            String errorMessage = "Underflow error: nothing to consume";
            return errorMessage;
        } else {
            String msg = messageQueue.get(nextOffsetToBeRead);
            groupIdTolastIndexRead.put(groupId, nextOffsetToBeRead);
            return msg;
        }

    }

}