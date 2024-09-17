package com.lovice.repository;

import com.lovice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Basics we need to provide class and type unique id for JPArepository<Class, UniqueID>
public interface UserRepository extends JpaRepository<User, Long> {

}
