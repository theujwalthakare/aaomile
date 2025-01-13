package com.aaomile.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;

    private String eventName;

    @Column(length = 1000)
    private String eventDiscription;
    
    private String eventGenre;

    private String eventType;

    private String eventBanner;

    private String cloudBannerId;
    
    private String eventDate;
    
    private String eventTime;
    
    private String eventVenue;
    
    private String eventAddress;
    
    private String eventCity;
    
    private String eventState;
    
    private String eventPincode;
    
    private String eventDuration;
    
    private String ticketType;
    
    private String ticketPrice;
    
    private String seates;
    
    private String creatorEmail;
   
    private String creatorName;

    @ManyToOne
    private User user;



}
