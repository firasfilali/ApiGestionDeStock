package com.filali.gestiodestock.repository;

import com.filali.gestiodestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Integer, Client> {
}
