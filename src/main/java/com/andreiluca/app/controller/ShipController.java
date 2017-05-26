package com.andreiluca.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    item.setId(null);

    return repo.saveAndFlush(item);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Ship updateItem(@RequestBody Ship updatedItem, @PathVariable Integer id) {
	  System.out.println("update Item : " + updatedItem.getDescription() + " id : " + updatedItem.getId() + " >>> id param : "
			  + id);
    updatedItem.setId(id);
    return repo.saveAndFlush(updatedItem);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Integer id) {
    repo.delete(id);
  }
}