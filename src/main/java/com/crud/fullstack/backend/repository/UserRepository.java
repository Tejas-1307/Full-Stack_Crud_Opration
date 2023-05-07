package com.crud.fullstack.backend.repository;

import com.crud.fullstack.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
