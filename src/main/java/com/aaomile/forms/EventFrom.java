package com.aaomile.forms;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
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

    // @NotBlank(message = "Event Name is required")
    private String eventName;

    // @NotBlank(message = "Event Name is required")
    private String eventDiscription;
    
    // @NotBlank(message = "Event Name is required")
    private String eventGenre;

    // @NotBlank(message = "Event Name is required")
    private String eventType;

    private MultipartFile eventBanner;
    
    // @NotBlank(message = "Event Date required")
    private String eventDate;
    
    // @NotBlank(message = "Event Time is required")
    private String eventTime;
    
    // @NotBlank(message = "Event Venue is required")
    private String eventVenue;
    
    // @NotBlank(message = "Event Address is required")
    private String eventAddress;
    
    // @NotBlank(message = "Event City is required")
    private String eventCity;
    
    // @NotBlank(message = "Event State is required")
    private String eventState;
    
    // @NotBlank(message = "Event Pincode is required")
    private String eventPincode;
    
    // @NotBlank(message = "Event Duration is required")
    private String hours;
    private String minutes;
    private String seconds;
    
    // @NotBlank(message = "Event Name is required")
    private String ticketType;
    
    // @NotBlank(message = "Event Name is required")
    private String ticketPrice;
    // @NotBlank(message = "Availabe Seates is Requiered")
    private String seates;
    
    private String creatorEmail;
    
    // private int creatorName;


}
