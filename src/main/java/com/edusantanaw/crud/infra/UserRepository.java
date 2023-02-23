package com.edusantanaw.crud.infra;

import com.edusantanaw.crud.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository {
    User  findByEmail(String email);
}
