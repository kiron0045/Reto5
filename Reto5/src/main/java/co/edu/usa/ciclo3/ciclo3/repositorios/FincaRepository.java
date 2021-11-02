package co.edu.usa.ciclo3.ciclo3.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.ciclo3.ciclo3.entidades.Finca;

@Repository
public class FincaRepository {

    @Autowired
    private FincaCrudRepository fincaCrudRepository;

    public List<Finca> getAll(){
        return (List<Finca>) fincaCrudRepository.findAll();
    }
    public Optional<Finca>getFinca(int id){
        return fincaCrudRepository.findById(id);
    }
    public Finca save(Finca f){
        return fincaCrudRepository.save(f);
    }

    public void delete(Finca f){
        fincaCrudRepository.delete(f);
    }
   
    
}
