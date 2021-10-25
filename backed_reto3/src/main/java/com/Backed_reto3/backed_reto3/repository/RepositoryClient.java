
package com.Backed_reto3.backed_reto3.repository;

import com.Backed_reto3.backed_reto3.Entidad.Client;
import com.Backed_reto3.backed_reto3.interfaz.InterfaceClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */

@Repository
public class RepositoryClient {
     @Autowired 
    private InterfaceClient crudClient;
    
    public List <Client> getAll(){
        return (List<Client>) crudClient.findAll();
    }
    
    public Optional <Client> getClient(int id){
       return crudClient.findById(id);
    }
    public Client save ( Client client){
        return crudClient.save(client);
    }
    public void delete(Client client){
        crudClient.delete(client);
    }
    
}
