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
    String DepartureAirport;
    String ArrivalAirport;
    int TravelTime;

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }

    public String getDepartureAirport() {
        return this.DepartureAirport;
    }

    public String getArrivalAirport() {
        return this.ArrivalAirport;
    }

}
