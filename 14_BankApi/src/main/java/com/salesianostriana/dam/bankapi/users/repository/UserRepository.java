package com.salesianostriana.dam.bankapi.users.repository;

import com.salesianostriana.dam.bankapi.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
