package classic.comp.sci.problems.producerconsumerwithqueue.client;

/*In memory pub/sub system
 1) At least one publisher
 2) At least 2 subscribers*/


import classic.comp.sci.problems.producerconsumerwithqueue.classes.BrokerImpl;
import classic.comp.sci.problems.producerconsumerwithqueue.classes.ConsumerImpl;
import classic.comp.sci.problems.producerconsumerwithqueue.classes.ProducerImpl;
import classic.comp.sci.problems.producerconsumerwithqueue.interfaces.Broker;
import classic.comp.sci.problems.producerconsumerwithqueue.interfaces.Consumer;
import classic.comp.sci.problems.producerconsumerwithqueue.interfaces.Producer;

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








