package com.alexis.persons.repositories;

import com.alexis.persons.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract List<UserModel> findByPriority(Integer priority);
}
