package segurosxy.modelos;

public class SeguroTarjeta extends Seguro {


    public SeguroTarjeta(String bancoTarjeta, Double prima)    {

        super();
        this.bancoTarjeta = bancoTarjeta;
        this.prima = prima;
    }

    @Override
    public void cacularRiesgo()   {

        if (this.bancoTarjeta.equals("AZTECA")) {
            this.nivelRiesgo = "ALTO";
        }
        else {
            this.nivelRiesgo = "BAJO";
        }
    }

    @Override
    public String getDetalleSeguro() {

        return "Seg. Tarjeta Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
    }
}
