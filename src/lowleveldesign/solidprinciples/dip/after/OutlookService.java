package lowleveldesign.solidprinciples.dip.after;

public class OutlookService implements EmailService {
   public  void sendEmail(String message){
        System.out.println("outlook service");
        System.out.println(message);
    }
}
