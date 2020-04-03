package com.jwttesting.jwtTesting.Repository;

import com.jwttesting.jwtTesting.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    AppUser findAppUserByUsername(String username);
}
