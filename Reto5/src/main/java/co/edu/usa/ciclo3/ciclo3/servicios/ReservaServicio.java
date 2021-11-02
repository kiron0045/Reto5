package co.edu.usa.ciclo3.ciclo3.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.ciclo3.ciclo3.entidades.Reserva;
import co.edu.usa.ciclo3.ciclo3.reportes.ClienteCounter;
import co.edu.usa.ciclo3.ciclo3.reportes.ReservaStatus;
import co.edu.usa.ciclo3.ciclo3.repositorios.ReservaRepository;
@Service
public class ReservaServicio {

    
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAll(){
        return  reservaRepository.getAll();
    }
    public Optional<Reserva> getReserva(int id){
        return reservaRepository.getReserva(id);
    }

    public Reserva save(Reserva r){
        if(r.getIdReservation()==null){
            return reservaRepository.save(r);
        }else{
            Optional<Reserva> paux=reservaRepository.getReserva(r.getIdReservation());
            if(paux.isEmpty()){
                return reservaRepository.save(r);
            }else{
                return r;
            }
        }
    }
    
    public Reserva update(Reserva r){
        if(r.getIdReservation()!=null){
            Optional<Reserva> e=reservaRepository.getReserva(r.getIdReservation());
            if(!e.isEmpty()){
                if(r.getStartDate()!=null){
                    e.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!=null){
                    e.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getScore()!=null){
                    e.get().setScore(r.getScore());
                }

                reservaRepository.save(e.get());
                return e.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean deleteReserva(int ReservaId) {
        Boolean aBoolean = getReserva(ReservaId).map(r -> {
            reservaRepository.delete(r);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public ReservaStatus getReporteStatusReservaciones(){
        List<Reserva>completed= reservaRepository.ReservacionStatus("completed");
        List<Reserva>cancelled= reservaRepository.ReservacionStatus("cancelled");
        return new ReservaStatus(completed.size(), cancelled.size());
    }
    
    public List<Reserva> getReportesTiempoReservaciones(String datoA, String datoB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservaRepository.ReservacionTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }  
    
    public List<ClienteCounter> servicioTopClientes(){
        return reservaRepository.getTopClientes();
    }
    
    
}
