package segurosxy.modelos.patrones;

import segurosxy.modelos.Cliente;
import segurosxy.modelos.email.EmailUtil;
import segurosxy.modelos.interfaces.ICorredorMediator;


public class CorreoMediator implements ICorredorMediator {

    private String servidorSMTP;

    public void setServidorCorreoSMTP(String servidorIP) {

        this.servidorSMTP = servidorIP;
    }

    private String preparaMensaje(String nombre)  {
        final StringBuffer salida = new StringBuffer();

        //salida.append("\n================================================================\n");
        salida.append("[CorreoMediator] Enviando mensaje por Correo, servidor IP: "+ servidorSMTP );
        salida.append("\n[CorreoMediator]                                  Cliente: "+ nombre );
        //salida.append("\n================================================================\n");


        return salida.toString();
    }

    public void enviaCorreoSMTP(Cliente cliente) {

        setServidorCorreoSMTP("smtp.gmail.com");
        
        // enviando correo...
        System.out.println( preparaMensaje(cliente.getNombre()) );

        try {
            EmailUtil.send(servidorSMTP, "example@gmail.com", "password", "gianmar.sanchez@gmail.com", "hello", preparaMensaje(cliente.getNombre()));
        }catch (Exception e){
            System.out.println("[CorreoMediator][Error] "+ e.toString());
        }
    }

}
