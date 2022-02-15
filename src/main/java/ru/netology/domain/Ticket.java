package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {
    int id;
    int price;
    String departureAirport;
    String arrivalAirport;
    int travelTime;


    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public String getArrivalAirport() {
        return this.arrivalAirport;
    }

}
