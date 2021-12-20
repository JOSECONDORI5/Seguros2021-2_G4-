package segurosxy.modelos.interfaces;

import segurosxy.modelos.Cliente;

public interface ICorredorMediator {

    void setServidorCorreoSMTP(String servidorIP);

    void enviaCorreoSMTP(Cliente cliente);

}
