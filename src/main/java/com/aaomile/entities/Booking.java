package com.aaomile.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    private String eventName;

    private String userName;

    private String userEmail;

    private String userPhone;

    private String seates;

    private int transactionId;

    private int amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;




}
