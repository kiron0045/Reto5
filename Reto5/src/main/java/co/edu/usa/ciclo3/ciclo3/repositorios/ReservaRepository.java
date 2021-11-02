package co.edu.usa.ciclo3.ciclo3.repositorios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.ciclo3.ciclo3.entidades.Cliente;
import co.edu.usa.ciclo3.ciclo3.entidades.Reserva;
import co.edu.usa.ciclo3.ciclo3.reportes.ClienteCounter;

@Repository
public class ReservaRepository {
    
    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    public List<Reserva> getAll(){
        return (List<Reserva>) reservaCrudRepository.findAll();
    }
    public Optional<Reserva>getReserva(int id){
        return reservaCrudRepository.findById(id);
    }
    public Reserva save(Reserva r){
        return reservaCrudRepository.save(r);
    }
    public void delete(Reserva r){
        reservaCrudRepository.delete(r);
    }
    
    public List<Reserva> ReservacionStatus (String status){
        return reservaCrudRepository.findAllByStatus(status);
    }
    
    public List<Reserva> ReservacionTiempo (Date a, Date b){
        return reservaCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
  
    public List<ClienteCounter> getTopClientes(){
        List<ClienteCounter> res=new ArrayList<>();
        List<Object[]>report = reservaCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){
            res.add(new ClienteCounter((long)report.get(i)[1],(Cliente) report.get(i)[0] ));
        
        }
        return res;
    }

}
