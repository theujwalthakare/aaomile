package com.aaomile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaomile.entities.Booking;
import com.aaomile.repository.BookingRepo;
import com.aaomile.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public Booking save(Booking booking) {

        return bookingRepo.save(booking);

    }

    @Override
    public List<Booking> getByUserId(int id) {
        return bookingRepo.findByUserId(id);
    }

}
