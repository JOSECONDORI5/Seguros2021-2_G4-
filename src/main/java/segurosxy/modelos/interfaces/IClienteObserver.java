package segurosxy.modelos.interfaces;

public interface IClienteObserver {

    void notifica();

    String getNombre();
    
    void notificaAutorizacion();
}
