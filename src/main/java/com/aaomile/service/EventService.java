package com.aaomile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaomile.entities.Event;


public interface EventService {

    //save
    Event save(Event event);

    //update or edit event
    Event update(Event event);

    //get events
    List<Event> getAll();

    //get event by id
    Event getById(int id);

    //delete event
    void delete(int id);

    //search event
    List<Event> search(String name);

    //get Events by userID
    List<Event> getByUserId(int id);

    List<Event> getByGenre(String genre);
}
 