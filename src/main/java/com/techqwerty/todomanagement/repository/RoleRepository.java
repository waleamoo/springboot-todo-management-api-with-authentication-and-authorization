package com.techqwerty.todomanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techqwerty.todomanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
