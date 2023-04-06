package classic.comp.sci.problems.producerconsumerwithqueue.interfaces;

public interface Broker {
    void publish(String msg);

    String consume(String groupId);

    void registerNewConsumer(Consumer consumer);

}