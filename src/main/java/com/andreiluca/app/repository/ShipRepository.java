package com.andreiluca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreiluca.app.model.Ship;

public interface ShipRepository extends JpaRepository<Ship, Integer> {

}
