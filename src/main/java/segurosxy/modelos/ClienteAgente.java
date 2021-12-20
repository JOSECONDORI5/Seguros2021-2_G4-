
package segurosxy.modelos;

import segurosxy.modelos.patrones.CorreoMediator;

public class ClienteAgente extends Cliente {

    public ClienteAgente(String nombre, Integer dni, CorreoMediator correoMediator) {
        super(nombre, dni, correoMediator);
    }
    
    public void notifica(){
        super.notifica();
        enviaCorreo();
    }

    public void enviaCorreo()    {

        //correoMediator.setServidorCorreoSMTP("smtp.gmail.com");
        correoMediator.enviaCorreoSMTP(this);
    }

}
