package segurosxy.modelos.patrones;

import segurosxy.modelos.Poliza;
import segurosxy.modelos.interfaces.IImprimible;

public class PolizaJSON extends Poliza implements IImprimible {

    public PolizaJSON(Integer numero, String nombresAsegurado, String nombresTomador) {
        super(numero, nombresAsegurado, nombresTomador);
    }

    public String aJSON() {
        
        StringBuffer json = new StringBuffer();
        json.append("{");
        json.append(" impresion: {");
        json.append("  title: \"Formato XML\",");
        json.append("  poliza: {");
        json.append("   numero: " + getNumero() + ",");
        json.append("   nombresAsegurado: \"" + getNombresAsegurado() + "\",");
        json.append("   nombresTomador: \"" + getNombresTomador() + "\"");
        json.append("  }");
        json.append(" }");
        json.append("}");

        return json.toString();
    }

    public String armarSalidaTexto()    {

        return aJSON();
    }
}