package ru.netology.Manager;


import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

public class Manager {
    private final TicketsRepository repository;

    public Manager(TicketsRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String search1, String search2) {
        String departureAirport = ticket.getDepartureAirport();
        String arrivalAirport = ticket.getArrivalAirport();
        return departureAirport.contains(search1) && arrivalAirport.contains(search2);
    }
}
