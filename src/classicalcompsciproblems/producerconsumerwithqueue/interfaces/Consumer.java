package classicalcompsciproblems.producerconsumerwithqueue.interfaces;

public interface Consumer {
    void consume();

    void register();

    String getGroupId();


}
