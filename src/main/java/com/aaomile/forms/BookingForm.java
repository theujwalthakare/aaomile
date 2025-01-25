package com.aaomile.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingForm {

    private int bookingId;

    private String eventName;

    private String userName;

    private String userEmail;

    private String userPhone;

    private String seates;

    // private int amount;

    private int eventId;

    // private int userId;

}
