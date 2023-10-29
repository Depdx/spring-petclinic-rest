package org.springframework.samples.petclinic.repository;

import org.springframework.cache.annotation.CachePut;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.User;

public interface UserRepository {

    @CachePut(value = "users", key = "#user.username")
    void save(User user) throws DataAccessException;
}
