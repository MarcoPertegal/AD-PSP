package com.salesianostriana.dam.bankapi.users.repository;

import com.salesianostriana.dam.bankapi.users.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
