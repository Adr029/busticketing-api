package com.example.processors;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TicketNumberProcessor {

    public String generateTicketNumber() {
        int ticketNumberLength = 8;

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder ticketNumberBuilder = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < ticketNumberLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            ticketNumberBuilder.append(randomChar);
        }

        return ticketNumberBuilder.toString();
    }
}
