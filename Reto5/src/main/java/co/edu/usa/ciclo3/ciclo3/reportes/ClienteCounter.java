package co.edu.usa.ciclo3.ciclo3.reportes;

import co.edu.usa.ciclo3.ciclo3.entidades.Cliente;

public class ClienteCounter {
    private Long total;
    private Cliente client;

    public ClienteCounter(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
    
}
