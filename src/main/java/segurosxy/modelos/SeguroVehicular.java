package segurosxy.modelos;

import segurosxy.modelos.interfaces.IClienteObserver;
import segurosxy.modelos.interfaces.ICobertura;
import segurosxy.modelos.interfaces.ISeguroObservable;

public class SeguroVehicular extends Seguro implements ISeguroObservable{

    private ICobertura cobertura;

    public SeguroVehicular(String marca, String modelo, Double prima)    {

        super();
        this.marca = marca;
        this.modelo = modelo;
        this.prima = prima;
    }

    @Override
    public void cacularRiesgo()   {

        if (this.marca.equals("Toyota") && this.modelo.equals("Yaris")) {
            this.nivelRiesgo = "ALTO";
        }
        else {
            this.nivelRiesgo = "BAJO";
        }
    }

    @Override
    public String getDetalleSeguro()    {

        return "Seg. Vehicular Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
    }

    public void calcularCobeturaVehicular( ICobertura cobertura )  {

        cobertura.calculaCobertura();
        
        System.out.println();
    }

public void Nuevosiniestro(final String danios) {
    
    if(danios.equals("superficiales")){
        setAutorizacion("Autorizado");
    }else{
        setAutorizacion("No autorizado");
    }

    // notify contratante
    //System.out.println("***********************************************************");
    System.out.println("[Seguro] Se modifico la autorizacón del  seguro, notificando... ");
    //System.out.println("***********************************************************");
    for( IClienteObserver a : this.contratantes) {
        a.notificaAutorizacion();
    }
}

}
