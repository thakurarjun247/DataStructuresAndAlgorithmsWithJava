package classic.comp.sci.problems;

import java.util.*;
 /*In memory pub/sub system
 1) At least one publisher
 2) At least 2 subscribers*/


// Main class should be named 'Solution' and should not be public.
class PubSubAndQueueClient {
    public static void main(String[] args) {
        Broker broker= new BrokerImpl();

        Subscriber subscriber= new SubscriberImpl("group-alpha", broker);
        PublisherImpl publisher = new PublisherImpl(broker);
        subscriber.register();
        publisher.publish("msg-1");
        subscriber.consume();
        subscriber.consume();
        publisher.publish("msg-2");
        subscriber.consume();



    }
}

interface Subscriber {
    public void consume();
    public void register();

    public String getGroupId();

}

class SubscriberImpl implements Subscriber {
    SubscriberImpl(String groupId, Broker broker){
        this.groupId=groupId;
        this.broker=broker;
    }
    @Override
            public String getGroupId(){return this.groupId;}
    Broker broker;
    String groupId;

    @Override
    public  void consume(){
        System.out.println("broker consuming message: "+ broker.consume(this.groupId));;
    }
    @Override
    public void register(){
        broker.addSub(this);
    }

}



class PublisherImpl {
    Broker broker;
    PublisherImpl(Broker broker){
        this.broker=broker;
    }
    void publish(String msg){
        broker.publish(msg);
    }
}

interface Broker {
    public  void publish(String msg);
    String consume( String groupId);
    void addSub(Subscriber sub);

}
class BrokerImpl implements Broker {
    List<String> messageQueue;
    BrokerImpl(){
        messageQueue= new ArrayList<>();
        subscribers= new ArrayList<>();
        groupIdTolastIndexRead= new HashMap<>();
    }
    Map<String, Integer> groupIdTolastIndexRead;
    List<Subscriber> subscribers;
    public void addSub(Subscriber sub){
        subscribers.add(sub);
        groupIdTolastIndexRead.put(sub.getGroupId(), -1);
    }
    void removeSub(Subscriber sub){
        subscribers.remove(sub);
    }


    public  void publish(String msg){
        messageQueue.add(msg);
        System.out.println("Publisher publishing the message: "+msg);

    }

    public String consume( String groupId){
        //q.remove();
        //todo: read all the message from the q one by one and keep
        //from  offset till which we have read the message.
        //q.get(0);
        Integer offsetOfLastMessageReadByThisGroupId=groupIdTolastIndexRead.get(groupId);

        Integer nextOffsetToBeRead=offsetOfLastMessageReadByThisGroupId+1;
        if(nextOffsetToBeRead>=messageQueue.size())
        {
            String errorMessage="Underflow error: nothing to consume";
            return  errorMessage;
        }
       else {
                  String msg=messageQueue.get(nextOffsetToBeRead);
            groupIdTolastIndexRead.put(groupId, nextOffsetToBeRead   );
            return msg;
        }

    }

}
