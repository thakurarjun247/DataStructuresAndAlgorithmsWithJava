package solidprinciples.dip.after;

public class Application {
    public static void main(String[] args) {

        EmailService gmailService= new GmailService();
        EmailService outlookService= new OutlookService();
        EmailService xmailService= new XMailService();
        UserService userService= new UserService(gmailService);
        UserService userService1= new UserService(outlookService);

        userService1.signUp();
        userService.signUp();

    }


}
