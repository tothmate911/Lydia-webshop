package com.lydiawebshop.webproject.user.repository;

import com.lydiawebshop.webproject.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
