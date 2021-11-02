package co.edu.usa.ciclo3.ciclo3.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.ciclo3.ciclo3.entidades.Mensaje;

@Repository
public class MensajeRepository {
    
    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    public List<Mensaje> getAll(){
        return (List<Mensaje>)  mensajeCrudRepository.findAll();
    }
    public Optional<Mensaje>getMensaje(int id){
        return  mensajeCrudRepository.findById(id);
    }
    public Mensaje save(Mensaje m){
        return  mensajeCrudRepository.save(m);
    }
    public void delete(Mensaje m){
        mensajeCrudRepository.delete(m);
    }
   
    
}
