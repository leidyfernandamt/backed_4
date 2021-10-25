
package com.Backed_reto3.backed_reto3.servicios;

import com.Backed_reto3.backed_reto3.Entidad.Message;
import com.Backed_reto3.backed_reto3.repository.RepositoryMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */

@Service
public class serviciosMessage {
    
    @Autowired
    RepositoryMessage metodosCrud ;
    
    public List <Message> getAll( ){
        return metodosCrud.getAll();
    }
    
    public Optional <Message > getMessage (int messageId){
       return metodosCrud. getMessage (messageId);
    }
    
    public Message  save (Message  messages ){
        
      if( messages.getIdMessage ()== null)
        { 
          return metodosCrud.save(messages);
        }
      else {
            Optional<Message> evt=metodosCrud.getMessage(messages.getIdMessage());
            if( evt.isEmpty())
            {
              return metodosCrud.save(messages );
            }
            else
            {
            return messages;
            }
      
      
         }
    
     }
    
     public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
    
}
