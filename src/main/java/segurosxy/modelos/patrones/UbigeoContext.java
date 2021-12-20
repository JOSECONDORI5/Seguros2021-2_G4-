package segurosxy.modelos.patrones;

public class UbigeoContext {
    
    private String codigoDepartamento;
    private String codigoProvincia;
    private String codigoDistrito;
    
    private UbigeoFlyweight flyweight;

    public UbigeoContext(String codigoDepartamento, String codigoProvincia, String codigoDistrito) {

        this.flyweight = UbigeoFactory.getInstance().getUbigeo( codigoDepartamento, codigoProvincia, codigoDistrito);
       
        this.codigoDepartamento = codigoDepartamento;
        this.codigoProvincia = codigoProvincia;
        this.codigoDistrito = codigoDistrito;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getDepartamento() {
        return this.flyweight.getDepartamento();
    }

    public String getProvincia() {
        return this.flyweight.getProvincia();
    }

    public String getDistrito() {
        return this.flyweight.getDistrito();
    }

}
