package co.edu.usa.ciclo3.ciclo3.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.ciclo3.ciclo3.entidades.Cliente;

@Repository
public class ClienteRepository {
    
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    public List<Cliente> getAll(){
        return (List<Cliente>) clienteCrudRepository.findAll();
    }
    public Optional<Cliente>getCliente(int id){
        return clienteCrudRepository.findById(id);
    }
    public Cliente save(Cliente c){
        return clienteCrudRepository.save(c);
    }
    public void delete(Cliente c){
        clienteCrudRepository.delete(c);
    }
    
}
