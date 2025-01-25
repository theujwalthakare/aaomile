package com.aaomile.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    private String eventName;

    private String eventDate;

    private String userName;

    private String userEmail;

    private String userPhone;

    private String seates;

    private String transactionId = UUID.randomUUID().toString();

    private int amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

}
