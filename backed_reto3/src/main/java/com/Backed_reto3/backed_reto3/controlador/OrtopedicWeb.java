
package com.Backed_reto3.backed_reto3.controlador;

import com.Backed_reto3.backed_reto3.Entidad.Ortopedic;
import com.Backed_reto3.backed_reto3.servicios.serviciosOrtopedic;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping ("/api/Ortopedic")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrtopedicWeb {
    
    @GetMapping ("/hola mundo")
    public String saludar(){
     return "hola mundo tutorias";
    }
    @Autowired
    private serviciosOrtopedic servicios;
    
   @GetMapping ("/all")
    private List <Ortopedic> getOrtopedic(){
       return servicios.getAll();
    }
    
    
   @GetMapping ("/{id}")
   public Optional <Ortopedic> getOrpedic(@PathVariable("id")int ortopedicId){
        return servicios.getOrtopedic(ortopedicId);
   }
   
   @PostMapping ("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Ortopedic save (@RequestBody Ortopedic ortopedic){
       return servicios.save(ortopedic);
   }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic update(@RequestBody Ortopedic ortopedic) {
        return servicios.update(ortopedic);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return servicios.deleteortopedic(Id);
    }
    
}
