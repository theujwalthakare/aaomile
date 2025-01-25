package com.aaomile.service;
import java.util.List;

import com.aaomile.entities.Booking;


public interface BookingService {
    
    Booking save(Booking booking);

    List<Booking> getByUserId(int id);
}
