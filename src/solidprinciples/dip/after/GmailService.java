package solidprinciples.dip.after;

public class GmailService implements EmailService {
    public void sendEmail(String message){
        System.out.println("gmail service");
        System.out.println(message);
    }
}
