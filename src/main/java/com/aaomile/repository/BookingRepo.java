package com.aaomile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaomile.entities.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

    List<Booking> findByUserId(int id);

}
