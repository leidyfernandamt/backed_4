
package com.Backed_reto3.backed_reto3.interfaz;

import com.Backed_reto3.backed_reto3.Entidad.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author usuario
 */
public interface InterfaceReservation extends CrudRepository < Reservation , Integer> {
    
}
