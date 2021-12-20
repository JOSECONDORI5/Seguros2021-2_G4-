package segurosxy.modelos.patrones;

import java.util.ArrayList;

import segurosxy.modelos.Cliente;
import segurosxy.modelos.Seguro;
import segurosxy.modelos.interfaces.IClienteObserver;
import segurosxy.modelos.interfaces.IExpression;

public class ContextCliente {


    private String nextOp = "";
    private int operator = 0;
    private StringBuffer result;

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        result = new StringBuffer();
    }

    public int getInteger(String in)    {

        int res = 0;
        try {
            res = Integer.valueOf(in);
        }
        catch(Exception e)  {
            // No es numero
        }
        return res;
    }

    public void setOperator(int operator)   {

            this.operator = operator;
    }


    public void setOperation(String operation)  {

            if(operation.toLowerCase().equals("prima"))
                    this.nextOp = "prima";
            else if(operation.toLowerCase().equals("consulta"))
                    this.nextOp = "consulta";
    }


    public void calculate() {

            if (this.nextOp.toLowerCase().equals("prima") ) {

                for (Seguro seguro : cliente.getSeguros()) {

                    if (seguro.getNumero() == operator) {
                        this.result.append( String.valueOf( seguro.getPrima() ) + " ");
                        //System.out.println("Seguro Prima: " + this.result);
                    }
                }
            }
            else if (this.nextOp.toLowerCase().equals("consulta"))   {

                int indicador = 0;
                for (Seguro seguro : cliente.getSeguros()) {

                    for (IClienteObserver contratante : seguro.getContratantes()) {

                        Cliente clienteAsegurado = (Cliente)contratante;
                        if (clienteAsegurado.getDni() == operator) {
                            this.result.append("SI ");
                            indicador = 1;
                            //System.out.println("Cliente Asegurado: " + this.result);
                        }
                    }    
                }
                
                if (indicador != 1) this.result.append("NO ");
            }
    }

    public String getResult()  {

            return this.result.toString();
    }



}