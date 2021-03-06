package segurosxy.modelos;



import segurosxy.modelos.patrones.CorreoMediator;
import segurosxy.modelos.patrones.SmsMediator;

public class ClienteAsegurado extends Cliente{

    public ClienteAsegurado(String nombre, Integer dni, CorreoMediator correoMediator, SmsMediator smsMediator) {

        super(nombre, dni, correoMediator, smsMediator);
    }

    public void notifica(){
        super.notifica();
        enviaCorreo();
        enviaSMS();
    }

    public void enviaCorreo() {

        //correoMediator.setServidorCorreoSMTP("smtp.gmail.com");
        correoMediator.enviaCorreoSMTP(this);
    }
    
    public void enviaSMS() {
        smsMediator.enviaSmsTwilio(this);
    }
    public void notificaAutorizacion(){
        try {
            System.out.println("[CLiente] Notificando al cliente la autorización " + this.getNombre());
        }
        catch(Throwable t) {
            System.out.println("[Cliente] Notificacion con error" + t.getMessage() );
        }
    }
    
}
