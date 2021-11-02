package co.edu.usa.ciclo3.ciclo3.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.ciclo3.ciclo3.entidades.Categoria;
import co.edu.usa.ciclo3.ciclo3.repositorios.CategoriaRepository;

@Service
public class CategoriaServicio {
   
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return  categoriaRepository.getAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }

    public Categoria save(Categoria c){
        if(c.getId()==null){
            return categoriaRepository.save(c);
        }else{
            Optional<Categoria> paux=categoriaRepository.getCategoria(c.getId());
            if(paux.isEmpty()){
                return categoriaRepository.save(c);
            }else{
                return c;
            }
        }
    }
    public Categoria update(Categoria c){
        if(c.getId()!=null){
            Optional<Categoria> e=categoriaRepository.getCategoria(c.getId());
            if(!e.isEmpty()){
                if(c.getName()!=null){
                    e.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    e.get().setDescription(c.getDescription());
                }
                categoriaRepository.save(e.get());
                return e.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }


    public boolean deleteCategoria(int CategoriaId) {
        Boolean aBoolean = getCategoria(CategoriaId).map(c -> {
            categoriaRepository.delete(c);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    

}
