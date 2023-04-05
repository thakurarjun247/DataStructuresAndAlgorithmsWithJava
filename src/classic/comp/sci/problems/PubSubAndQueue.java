package classic.comp.sci.problems;

import java.util.*;
 /*In memory pub/sub system
 1) At least one publisher
 2) At least 2 subscribers*/





//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.JsonProcessingException;

// Main class should be named 'Solution' and should not be public.
class PubSubAndQueue {
    public static void main(String[] args) {

        SubscriberInterface subscriber1= new SubscriberType1();
        SubscriberInterface subscriber2= new SubscriberType2();
        BrokerInterface broker= new Broker();
        Publisher publisher= new Publisher(broker);
        subscriber1.register();
        subscriber2.register();
        publisher.publish("msg-1");
        publisher.publish("msg-2");
        subscriber1.consume();



    }
}

interface SubscriberInterface{
    public void consume();
    public void register();

}

class SubscriberType1 implements SubscriberInterface{
    Broker broker;
    int index;
    @Override
    public  void consume(){
        System.out.println("type1"+ broker.consume(index++));;
    }
    @Override
    public void register(){
        broker.addSub(this);
    }

}

class SubscriberType2 implements SubscriberInterface{
    Broker broker;
    int index;
    @Override
    public  void consume(){
        System.out.println( "type2"+broker.consume( index++));;
    }
    @Override
    public void register(){
        broker.addSub(this);
    }


}

class Publisher{
    BrokerInterface broker;
    Publisher(BrokerInterface broker){
        this.broker=broker;
    }
    void publish(String msg){
        broker.publish(msg);
    }
}

interface BrokerInterface{
    public  void publish(String msg);
}
class Broker implements BrokerInterface{
    LinkedList<String> q=new LinkedList<>();
    Map<SubscriberInterface, Integer> lastIndexRead;
    List<SubscriberInterface> subscribers;
    void addSub(SubscriberInterface sub){
        subscribers.add(sub);
    }
    void removeSub(SubscriberInterface sub){
        subscribers.remove(sub);
    }


    public  void publish(String msg){
        q.add(msg);

    }

    String consume(int index){
        //q.remove();
        //todo: read all the message from the q one by one and keep
        //track of the index till which we have read the message.
        //q.get(0);

        // for(int i=0;i<q.size();i++)
        String msg=q.get(index);

        return msg;

    }

}
