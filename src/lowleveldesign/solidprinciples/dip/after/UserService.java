package lowleveldesign.solidprinciples.dip.after;

public class UserService {
    EmailService emailService;
    UserService(EmailService emailService){
        this.emailService=emailService;
    }
    void signUp(){
        emailService.sendEmail("Welcome, you are signedup");
    }
}
