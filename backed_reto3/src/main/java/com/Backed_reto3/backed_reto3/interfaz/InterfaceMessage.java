
package com.Backed_reto3.backed_reto3.interfaz;

import com.Backed_reto3.backed_reto3.Entidad.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author usuario
 */
public interface InterfaceMessage  extends CrudRepository < Message , Integer> {
    
}
