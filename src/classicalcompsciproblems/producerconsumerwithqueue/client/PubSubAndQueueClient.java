package classicalcompsciproblems.producerconsumerwithqueue.client;

/*In memory pub/sub system
 1) At least one publisher
 2) At least 2 subscribers*/


import classicalcompsciproblems.producerconsumerwithqueue.classes.BrokerImpl;
import classicalcompsciproblems.producerconsumerwithqueue.classes.ConsumerImpl;
import classicalcompsciproblems.producerconsumerwithqueue.classes.ProducerImpl;
import classicalcompsciproblems.producerconsumerwithqueue.interfaces.Broker;
import classicalcompsciproblems.producerconsumerwithqueue.interfaces.Consumer;
import classicalcompsciproblems.producerconsumerwithqueue.interfaces.Producer;

// Main class should be named 'Solution' and should not be public.
class PubSubAndQueueClient {
    public static void main(String[] args) {
        Broker broker = new BrokerImpl();

        Consumer consumerGroupAlpha = new ConsumerImpl("group-alpha", broker);
        Consumer consumerGroupSigma = new ConsumerImpl("group-sigma", broker);


        Producer producer = new ProducerImpl(broker);
        consumerGroupAlpha.register();
        consumerGroupSigma.register();
        producer.publish("msg-1");
        consumerGroupAlpha.consume();
        consumerGroupSigma.consume();
        consumerGroupSigma.consume();
        consumerGroupSigma.consume();
        consumerGroupAlpha.consume();
        producer.publish("msg-2");
        consumerGroupAlpha.consume();
        consumerGroupSigma.consume();


    }
}








