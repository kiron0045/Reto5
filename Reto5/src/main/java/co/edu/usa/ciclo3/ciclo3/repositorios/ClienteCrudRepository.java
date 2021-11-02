package co.edu.usa.ciclo3.ciclo3.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.ciclo3.ciclo3.entidades.Cliente;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {
    
    
}
