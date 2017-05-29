package com.andreiluca.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andreiluca.app.model.Ship;
import com.andreiluca.app.repository.ShipRepository;

@RestController
@RequestMapping("/ships")
public class ShipController {
  @Autowired
  private ShipRepository repo;

  @RequestMapping(method = RequestMethod.GET)
  public List findItems() {
    return repo.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public Ship addItem(@RequestBody Ship item) {
    return repo.saveAndFlush(item);
  }
}