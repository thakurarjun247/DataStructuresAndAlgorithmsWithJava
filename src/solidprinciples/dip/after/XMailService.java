package solidprinciples.dip.after;

public class XMailService implements EmailService{
    @Override
    public void sendEmail(String message) {
        System.out.println("xmailservice");
        System.out.println(message);
    }
}
