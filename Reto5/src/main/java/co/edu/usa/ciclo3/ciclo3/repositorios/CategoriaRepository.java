package co.edu.usa.ciclo3.ciclo3.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.ciclo3.ciclo3.entidades.Categoria;

@Repository
public class CategoriaRepository {
    
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    public List<Categoria> getAll(){
        return (List<Categoria>) categoriaCrudRepository.findAll();
    }
    public Optional<Categoria>getCategoria(int id){
        return categoriaCrudRepository.findById(id);
    }
    public Categoria save(Categoria c){
        return categoriaCrudRepository.save(c);
    }
    public void delete(Categoria c){
        categoriaCrudRepository.delete(c);
    }
   
    

}
