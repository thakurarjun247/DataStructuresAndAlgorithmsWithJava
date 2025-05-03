package lowleveldesign.solidprinciples.dip.before;

public class UserService {
    GmailService gmailService;
    UserService(GmailService gmailService){
        this.gmailService=gmailService;
    }
    void signUp(){
        gmailService.sendEmail("Welcome, you are signedup");
    }
}
