package lowleveldesign.solidprinciples.dip.before;

public class GmailService {
    void sendEmail(String message){
        System.out.println("gmail service");
        System.out.println(message);
    }
}
