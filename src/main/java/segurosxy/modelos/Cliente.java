package segurosxy.modelos;

import java.util.ArrayList;
import java.util.List;

import segurosxy.modelos.interfaces.IClienteObserver;
import segurosxy.modelos.patrones.CorreoMediator;
import segurosxy.modelos.patrones.UbigeoContext;

public class Cliente implements IClienteObserver {

    private String nombre;
    private Integer dni;
    private UbigeoContext ubigeoCasa;
    private UbigeoContext ubigeoTrabajo;
    private List<Seguro> seguros;

    protected CorreoMediator correoMediator;

    public Cliente(String nombre, Integer dni) {

        this.nombre = nombre;
        this.dni = dni;
        this.seguros = new ArrayList<Seguro>();
    }

    public Cliente(final String nombre, Integer dni, final CorreoMediator correoMediator) {

        this.nombre = nombre;
        this.dni = dni;
        this.correoMediator = correoMediator;
        this.seguros = new ArrayList<Seguro>();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setCompraSeguro(Seguro seguro) {

        this.seguros.add(seguro);
    }

    public void getListaSeguroCliente() {

        System.out.println("Nombre: " + this.nombre);
        for (Seguro seguro : seguros) {

            System.out.println("Seguro: " + seguro.getDetalleSeguro());
        }

    }

    public UbigeoContext getUbigeoCasa() {
        return ubigeoCasa;
    }

    public void setUbigeoCasa(UbigeoContext ubigeoCasa) {
        this.ubigeoCasa = ubigeoCasa;
    }

    public UbigeoContext getUbigeoTrabajo() {
        return ubigeoTrabajo;
    }

    public void setUbigeoTrabajo(UbigeoContext ubigeoTrabajo) {
        this.ubigeoTrabajo = ubigeoTrabajo;
    }

    public void printUbigeos(){
        System.out.println("[Ubigeo] Casa: "+ ubigeoCasa.getDepartamento() +", "+ ubigeoCasa.getProvincia() +", "+ ubigeoCasa.getDistrito());
        System.out.println("[Ubigeo] Trabajo: "+ ubigeoTrabajo.getDepartamento() +", "+ ubigeoTrabajo.getProvincia() +", "+ ubigeoTrabajo.getDistrito());
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    public void notifica() {

        try {
            System.out.println("[CLiente] Notificando al cliente " + this.nombre);
        }
        catch(Throwable t) {
            System.out.println("[Cliente] Notificacion con error" + t.getMessage() );
        }

    }

}
