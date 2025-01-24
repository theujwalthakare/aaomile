package com.aaomile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaomile.entities.Event;
import com.aaomile.entities.User;
import com.aaomile.helper.ResourceNotFoundException;
import com.aaomile.repository.EventRepo;
import com.aaomile.service.EventService;


@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepo eventRepo;
    
    @Override
    public Event save(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event update(Event event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Event> getAll() {
        return eventRepo.findAll();
    }

    @Override
    public Event getById(int id) {
        return eventRepo.findByEventId(id);
    }
    @Override
    public void delete(int id) {
        var event =  eventRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " => Event Not Found"));

        eventRepo.delete(event);
    }

    @Override
    public List<Event> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public List<Event> getByUserId(int id) {
        
        return eventRepo.findByUserId(id);
    }

    @Override
    public List<Event> getByGenre(String genre) {
        return eventRepo.findByEventGenre(genre);
    }

    @Override
    public List<Event> getByUserId(User user) {
        return eventRepo.findByUserId(user);
    }

}
