package co.edu.usa.ciclo3.ciclo3.repositorios;

import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import co.edu.usa.ciclo3.ciclo3.entidades.Reserva;

public interface ReservaCrudRepository extends CrudRepository<Reserva, Integer> {
 
    public List<Reserva> findAllByStatus(String status);
    
    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // select clientId, count(*) as "total" from reservacion group by cliendId order by total desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reserva AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
    
}

