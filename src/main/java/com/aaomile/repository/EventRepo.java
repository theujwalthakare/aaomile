package com.aaomile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aaomile.entities.Event;
import com.aaomile.entities.User;

import java.util.List;


@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {

    //find the events by user 
    List<Event> findByUser(User user);


    //custom query method
    @Query("SELECT c FROM Event c WHERE c.user.id = :userId")
    List<Event> findByUserId(int userId);

    List<Event> findByEventGenre(String eventGenre);

    Event findByEventId(int eventID);

    //To find event using user id.
    List<Event> findByUserId(User user);
}
