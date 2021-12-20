
package segurosxy.modelos.patrones;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import segurosxy.modelos.Cliente;
import segurosxy.modelos.interfaces.ISmsMediator;
import segurosxy.modelos.sms.SmsUtil;

/**
 *
 * @author Jose Condori
 * @version 20 dic. 2021 16:10:02
 */
public class SmsMediator implements ISmsMediator {
    
    private String ACCOUNT_SID;
    private String AUTH_TOKEN;

    public void SetServidorSmsTwilio(String sid, String token) {
        this.ACCOUNT_SID = sid;
        this.AUTH_TOKEN = token;
    }

    private String preparaMensaje(Cliente cliente)  {
        final StringBuffer salida = new StringBuffer();
        System.out.println(cliente.toString());
        salida.append("\n====================================================================================================\n");
        salida.append("[SMSMediator] Enviando mensaje por SMS, account id TWilio: "+ this.ACCOUNT_SID );
        salida.append("\n[SMSMediator]                                  Cliente: "+ cliente.getNombre());
        salida.append("\n[SMSMediator]                                      DNI: "+ cliente.getDni());
        salida.append("\nLa suma del seguro de ha modificado");
        salida.append("\n====================================================================================================\n");

        return salida.toString();
    }
    
    public void enviaSmsTwilio(Cliente cliente) {
        
        SetServidorSmsTwilio("AC2478da012d8ebaaabf35b3720cc5f8d6", "3d1b7298bd74bfeea18e24c98fbcb688");
        
          // enviando SMS...
        System.out.println( preparaMensaje(cliente));
        
        try {
            SmsUtil.send(ACCOUNT_SID, AUTH_TOKEN, "+15005550006", "+15005550006", preparaMensaje(cliente));
        }catch (Exception e){
            System.out.println("[SMSMediator][Error] "+ e.toString());
        }
    }

}
