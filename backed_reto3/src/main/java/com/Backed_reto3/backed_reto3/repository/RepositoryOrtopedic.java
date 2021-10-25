
package com.Backed_reto3.backed_reto3.repository;

import com.Backed_reto3.backed_reto3.Entidad.Ortopedic;
import com.Backed_reto3.backed_reto3.interfaz.InterfaceOrtopedic;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class RepositoryOrtopedic {
    
    @Autowired 
    private InterfaceOrtopedic crud ;
    
    public List <Ortopedic> getAll(){
        return (List<Ortopedic>) crud.findAll();
    }
    
    public Optional <Ortopedic> getOrtopedic(int id){
       return crud.findById(id);
    }
    public Ortopedic save (Ortopedic ortopedic){
        return crud.save(ortopedic);
    }
   public void delete(Ortopedic ortopedic){
         crud.delete(ortopedic);
    }
}
    
