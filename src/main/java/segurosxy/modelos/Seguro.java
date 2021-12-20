package segurosxy.modelos;

import segurosxy.modelos.interfaces.IClienteObserver;
import segurosxy.modelos.interfaces.ISeguroObservable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Seguro implements ISeguroObservable {

    protected Integer numero;
    protected Certificado certificado;
    protected Poliza poliza;
    protected String nivelRiesgo = "NINGUNO";
    protected String bancoTarjeta;
    protected String marca;
    protected String modelo;
    protected List<IClienteObserver> contratantes;
    protected Double prima;

    public Double getPrima() {
        return prima;
    }

    public void setPrima(Double prima) {
        this.prima = prima;
    }

    public Seguro() {
        this.numero = new Integer(new Random().nextInt());
        this.contratantes = new ArrayList<IClienteObserver>();
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNivelRiesgo()  {
        return this.nivelRiesgo;
    }

    public abstract String getDetalleSeguro();

    public abstract void cacularRiesgo();

    public void setSumaAsegurada(final Double suma) throws AWTException {

        this.poliza.setSumaAsegurada(suma);
        // notify contratante
        //System.out.println("***********************************************************");
        System.out.println("[Seguro] Se modifico la Suma Asegurada, notificando... ");
        //System.out.println("***********************************************************");
        for( IClienteObserver a : this.contratantes) {
            a.notifica();
        }
    }

    public void addObserver(IClienteObserver observer) {
        this.contratantes.add( observer );
    }

    public void removeObserver(IClienteObserver observer) {
        this.contratantes.remove( observer );
    }

    public List<IClienteObserver> getContratantes(){
        return contratantes;
    }

}
