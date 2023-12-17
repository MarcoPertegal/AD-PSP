package com.salesianostriana.dam.bankapi.users.repository;

import com.salesianostriana.dam.bankapi.users.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
