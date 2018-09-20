package com.movingtoweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movingtoweb.model.Users;
import com.movingtoweb.repository.UsersRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/users")
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    public List<Users> load(@RequestBody final Users users) {
        List<Users> userses = new ArrayList<>();
        userses.add(users);
        return usersRepository.save(userses);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Users> getUsers(@PathVariable final String name) {
        return usersRepository.findByName(name);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        usersRepository.delete(id);
    }
}
