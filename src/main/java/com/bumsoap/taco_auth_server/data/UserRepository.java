package com.bumsoap.taco_auth_server.data;

import com.bumsoap.taco_auth_server.entity.TacoUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<TacoUser, Long> {
    TacoUser findByUsername(String username);
}
