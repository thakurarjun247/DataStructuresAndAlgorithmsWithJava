package design.designpatterns.structural.bridge;

interface Format {
    default String getDetails() {
        return "the format is " + this.getClass();
    }
}

interface NotificationMedium {
    void send();
}

/*
* Problem 3: Messaging System
Problem: Design a messaging system that can send messages
* using different messaging mediums (SMS, Email, Push Notification)
* and different message formats (XML, HTML, JSON).
* */
public class BridgePatterMessagingExample {
    public static void main(String[] args) {
        new SMS(new HTML()).send();
        new Email(new JSON()).send();
    }
}

class JSON implements Format {
}

class HTML implements Format {
}

class XML implements Format {
}

class Email implements NotificationMedium {
    Format format;

    Email(Format format) {
        this.format = format;
    }

    @Override
    public void send() {

        System.out.println("sending email");
        System.out.println(format.getDetails());
    }
}

class SMS implements NotificationMedium {
    Format format;

    SMS(Format format) {
        this.format = format;
    }

    @Override
    public void send() {

        System.out.println("sending email");
        System.out.println(format.getDetails());
    }
}

