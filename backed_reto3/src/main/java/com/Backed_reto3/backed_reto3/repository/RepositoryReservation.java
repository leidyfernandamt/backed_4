
package com.Backed_reto3.backed_reto3.repository;

import com.Backed_reto3.backed_reto3.Entidad.Reservation;
import com.Backed_reto3.backed_reto3.interfaz.InterfaceReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class RepositoryReservation {
    
     @Autowired 
    private InterfaceReservation crudReservation;
    
     public List <Reservation> getAll(){
        return (List<Reservation>) crudReservation.findAll();
    }
    
    public Optional <Reservation> getReservation(int id){
       return crudReservation.findById(id);
    }
    public Reservation save (Reservation reservation){
        return crudReservation.save(reservation);
    }
    public void delete (Reservation reservation){
         crudReservation.save(reservation);
    }
    
}
