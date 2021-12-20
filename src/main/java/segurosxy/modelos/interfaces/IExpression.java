package segurosxy.modelos.interfaces;

import segurosxy.modelos.patrones.ContextCliente;

public interface IExpression    {

        public abstract void interpret(ContextCliente context);

}
