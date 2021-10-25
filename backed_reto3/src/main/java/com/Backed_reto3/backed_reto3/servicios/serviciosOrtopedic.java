
package com.Backed_reto3.backed_reto3.servicios;

import com.Backed_reto3.backed_reto3.Entidad.Ortopedic;
import com.Backed_reto3.backed_reto3.repository.RepositoryOrtopedic;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class serviciosOrtopedic {
    
    @Autowired
    RepositoryOrtopedic metodosCrud ;
    
    public List <Ortopedic> getAll( ){
        return metodosCrud.getAll();
    }
    
    public Optional <Ortopedic > getOrtopedic(int ortopedicId){
       return metodosCrud. getOrtopedic ( ortopedicId );
    }
    
    public Ortopedic save (Ortopedic  ortopedic ){
        
      if( ortopedic.getId()== null)
      { 
        return metodosCrud.save(ortopedic);
      }
      else {
            Optional<Ortopedic> evt=metodosCrud.getOrtopedic(ortopedic.getId());
            if( evt.isEmpty())
            {
              return metodosCrud.save(ortopedic);
            }
           else
            {
            return ortopedic;
            }
        }
    } 
    public Ortopedic update(Ortopedic ortopedic ){
        
        if(ortopedic .getId()!=null)
        
        {
            Optional<Ortopedic> e=metodosCrud.getOrtopedic(ortopedic.getId());
            if(!e.isEmpty()){
                if(ortopedic.getName()!=null){
                    e.get().setName(ortopedic.getName());
                }
                if(ortopedic.getBrand()!=null){
                    e.get().setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getYear()!=null){
                    e.get().setYear(ortopedic.getYear());
                }
                if(ortopedic.getDescription()!=null){
                    e.get().setDescription(ortopedic.getDescription());
                }
                if(ortopedic.getCategory()!=null){
                    e.get().setCategory(ortopedic.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return ortopedic;
            }
        }else{
            return ortopedic;
        }
    }


    public boolean deleteortopedic(int ortopedicId) {
        Boolean aBoolean = getOrtopedic(ortopedicId).map(ortopedic-> {
            metodosCrud.delete(ortopedic);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
    
}
