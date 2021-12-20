package segurosxy.modelos.interfaces;

public interface ISeguroObservable {

    void addObserver(IClienteObserver observer);
    void removeObserver(IClienteObserver observer);
    
}