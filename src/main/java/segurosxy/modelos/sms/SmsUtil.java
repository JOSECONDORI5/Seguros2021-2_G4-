
package segurosxy.modelos.sms;

/**
 *
 * @author Jose Condori
 * @version 20 dic. 2021 15:58:07
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsUtil {

    public static void send(String sid, String token, String to, String from, String message) {
       
        PhoneNumber receptor = new PhoneNumber(to);
        PhoneNumber emisor = new PhoneNumber(from);

        try {
            Twilio.init(sid, token);
            Message msg = Message.creator(receptor, emisor, message).create();
            System.out.println("[SmsUtil] message sent successfully");
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
