/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package segurosxy.modelos.interfaces;

import segurosxy.modelos.Cliente;

public interface ISmsMediator {
    
    void SetServidorSmsTwilio(String sid, String token);
    
    void enviaSmsTwilio(Cliente cliente);
    
}
