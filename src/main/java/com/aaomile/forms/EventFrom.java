package com.aaomile.forms;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventFrom {

    private String eventName;

    private String eventDiscription;
    
    private String eventGenre;

    private String eventType;

    private MultipartFile eventBanner;
    
    private String eventDate;
    
    private String eventTime;
    
    private String eventVenue;
    
    private String eventAddress;
    
    private String eventCity;
    
    private String eventState;
    
    private String eventPincode;
    
    private String hours;
    private String minutes;
    private String seconds;
    
    private String ticketType;
    
    private String ticketPrice;
    
    private String seates;
    
    private String creatorEmail;
    
    // private int creatorName;


}
