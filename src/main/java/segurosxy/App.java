package segurosxy;

import java.util.ArrayList;

import segurosxy.modelos.Cliente;
import segurosxy.modelos.ClienteAsegurado;
import segurosxy.modelos.Impresora;
import segurosxy.modelos.Poliza;
import segurosxy.modelos.SeguroTarjeta;
import segurosxy.modelos.SeguroVehicular;
import segurosxy.modelos.interfaces.ICobertura;
import segurosxy.modelos.interfaces.IExpression;
import segurosxy.modelos.patrones.*;

public class App {

    public static void procesaSMS(String[] sms, ContextCliente context)    {

        ArrayList<IExpression> tree = new ArrayList<IExpression>();

        System.out.println("Cadena SMS a interpretar: ");
        for(String token : sms)    {
            System.out.println(token);
            if ( context.getInteger(token) != 0 )
                tree.add(new DataExpression(token));
            else
                tree.add(new OperationExpression(token));

        }

        // Interpretamos cada expresión
        for(IExpression e : tree)
            e.interpret(context);
    }

    public static void main( String[] args ) throws Exception
    {

        Cliente cliente = new Cliente("Juan Perez", 45303232);

        SeguroVehicular seguro = new SeguroVehicular("Toyota","Yaris", 1500.00);
        seguro.cacularRiesgo();

        // Agregrando cobertura al seguro
        ICobertura cobertura = new CoberturaTodoRiesgoDecorator( new CoberturaPorRoboDecorator( new CoberturaBasicaVehicular() ) );
        seguro.calcularCobeturaVehicular( cobertura );

        cliente.setCompraSeguro(seguro);

        // Imprimiendo la Poliza
        //Poliza poliza = new Poliza(1111, cliente.getNombre(), cliente.getNombre() );
        //PolizaXML adaptadorXML = new PolizaXML(poliza);
        //Impresora.imprimir( adaptadorXML.armarSalidaTexto() );
        Impresora.imprimir( new PolizaXML(new Poliza(1111, cliente.getNombre(), cliente.getNombre())).armarSalidaTexto() );

        Impresora.imprimir( new PolizaJSON(2222, cliente.getNombre(), cliente.getNombre()).armarSalidaTexto() );

        SeguroTarjeta seguro2 = new SeguroTarjeta("BCP", 12.00);
        seguro2.cacularRiesgo();
        seguro2.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez"));
        cliente.setCompraSeguro(seguro2);

        cliente.getListaSeguroCliente();

        // Agregar Ubigeos para el cliente
        UbigeoContext ubigeoCasa = new UbigeoContext( "15", "01", "25");
        cliente.setUbigeoCasa( ubigeoCasa );
        UbigeoContext ubigeoTrabajo = new UbigeoContext( "15", "01", "25");
        cliente.setUbigeoTrabajo( ubigeoTrabajo );

        cliente.printUbigeos();


        SeguroVehicular seguro3 = new SeguroVehicular("Nissan","Sentra", 1000.00);
        ICobertura cobertura2 = new CoberturaPorChoqueDecorator( new CoberturaBasicaVehicular() );
        seguro3.calcularCobeturaVehicular( cobertura2 );


        // Correo Mediator
        System.out.println("\n[App] Notificaciones con CorreoMediator");
        CorreoMediator correoMediator = new CorreoMediator();
        ClienteAsegurado asegurado = new ClienteAsegurado("Pedro Pablo", 44123121, correoMediator);
        asegurado.enviaCorreo();

        ClienteAsegurado asegurado2 = new ClienteAsegurado("Pepito Pepe", 43323211, correoMediator);
        asegurado2.enviaCorreo();

        // Agregando Observadores
        System.out.println("\n[App] Observador para cambio en Suma Asegurada");
        seguro2.addObserver(cliente);
        seguro2.addObserver(asegurado);
        seguro2.setSumaAsegurada(100000.00);

        // Interpretando operaciones por SMS
        String numero = String.valueOf(seguro2.getNumero());
        //String sms[] = {"PRIMA",numero};
        //String sms[] = {"CONSULTA","44123121","44123133"};
        String sms[] = {"CONSULTA","44123121", "PRIMA", numero};

        ContextCliente context = new ContextCliente();
        context.setCliente(cliente);
        procesaSMS( sms, context );

        // Mostramos el resultado
        System.out.println("El resultado de la interpretación es " + context.getResult());

    }
}
