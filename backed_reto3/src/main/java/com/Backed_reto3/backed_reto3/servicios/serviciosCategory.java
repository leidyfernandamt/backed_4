
package com.Backed_reto3.backed_reto3.servicios;

import com.Backed_reto3.backed_reto3.Entidad.Category;
import com.Backed_reto3.backed_reto3.repository.RepositoryCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class serviciosCategory {
    
    
    @Autowired
    RepositoryCategory metodosCrud;
    
    public List <Category > getAll( ){
        return metodosCrud.getAll();
    }
    
    public Optional <Category > getCategory (Integer categoryId ){
       return metodosCrud. getCategory (categoryId);
    }
    /////////////////consultar////////////////////
    public Category  save (Category  category ){
        
      if( category.getId()== null)
      { 
          return metodosCrud.save(category);
      }
      else {
            Optional<Category> evt=metodosCrud.getCategory(category.getId());
            if( evt.isEmpty())
            {
              return metodosCrud.save(category );
            }
            else
            {
            return category ;
            }
      
      
         }
     
     }
   
  
    ///////////////////////////// delete /////////////////////
    
    public boolean deleteCategory(int categoriaId){
        Boolean d=getCategory(categoriaId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
        
    ///////////////////////update///////////////////////////
    }public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=metodosCrud.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return category;
    }
    
    
}
