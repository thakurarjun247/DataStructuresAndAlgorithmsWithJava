package lowleveldesign.solidprinciples.dip.before;

public class Application {
    public static void main(String[] args) {

        GmailService gmailService= new GmailService();
        //OutlookService outlookService= new OutlookService();
        UserService userService= new UserService(gmailService);
        userService.signUp();

    }


}
