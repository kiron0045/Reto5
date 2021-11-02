package co.edu.usa.ciclo3.ciclo3.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.ciclo3.ciclo3.entidades.Finca;
import co.edu.usa.ciclo3.ciclo3.repositorios.FincaRepository;

@Service
public class FincaServicio {

    @Autowired
    private FincaRepository fincaRepository;

    public List<Finca> getAll(){
        return  fincaRepository.getAll();
    }
    public Optional<Finca> getFinca(int id){
        return fincaRepository.getFinca(id);
    }

    public Finca save(Finca f){
        if(f.getId()==null){
            return fincaRepository.save(f);
        }else{
            Optional<Finca> paux=fincaRepository.getFinca(f.getId());
            if(paux.isEmpty()){
                return fincaRepository.save(f);
            }else{
                return f;
            }
        }
    }

    public Finca update(Finca f){
        if(f.getId()!=null){
            Optional<Finca> e=fincaRepository.getFinca(f.getId());
            if(!e.isEmpty()){
                if(f.getName()!=null){
                    e.get().setName(f.getName());
                }
                if(f.getAddress()!=null){
                    e.get().setAddress(f.getAddress());
                }
                if(f.getExtension()!=null){
                    e.get().setExtension(f.getExtension());
                }
                if(f.getDescription()!=null){
                    e.get().setDescription(f.getDescription());
                }
                
                fincaRepository.save(e.get());
                return e.get();
            }else{
                return f;
            }
        }else{
            return f;
        }
    }


    public boolean deleteFinca(int FincaId) {
        Boolean aBoolean = getFinca(FincaId).map(f -> {
            fincaRepository.delete(f);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
