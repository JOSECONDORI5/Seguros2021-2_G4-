package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.IExpression;

public class DataExpression implements IExpression  {

    private String value;

    public DataExpression(String token) {

            this.value = token;

    }

    public void interpret(ContextCliente context)   {

            context.setOperator(context.getInteger(this.value));

            context.calculate();

    }

}