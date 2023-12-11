package com.filali.gestiodestock.repository;


import com.filali.gestiodestock.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Integer, Roles> {
}
