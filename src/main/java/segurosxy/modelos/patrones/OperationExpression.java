package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.IExpression;

public class OperationExpression implements IExpression  {
    
    private String operation;

    public OperationExpression(String token)    {

            this.operation = token;

    }

    public void interpret(ContextCliente context)   {

            context.setOperation(this.operation);

    }

}
    