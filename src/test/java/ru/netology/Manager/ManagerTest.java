package ru.netology.Manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    TicketsRepository repo = new TicketsRepository();
    Ticket first = new Ticket(1, 800, "DME", "ATH", 5800);
    Ticket second = new Ticket(2, 1000, "TOP", "POR", 14700);
    Ticket third = new Ticket(3, 80050, "KHV", "WCV", 78900);
    Ticket forth = new Ticket(4, 500, "DME", "ATH", 5800);
    Manager ticketManager = new Manager(repo);

    @BeforeEach
    public void setUp() {
        ticketManager.add(first);
        ticketManager.add(second);
        ticketManager.add(third);
        ticketManager.add(forth);
    }

    @Test
    public void shouldFind1Equal() {
        Ticket[] actual = ticketManager.findAll("TOP", "POR");
        Ticket[] expected = new Ticket[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind2Equals() {
        Ticket[] actual = ticketManager.findAll("DME", "ATH");
        Ticket[] expected = new Ticket[]{forth, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEquals() {
        Ticket[] actual = ticketManager.findAll("RTY", "ATH");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }
}