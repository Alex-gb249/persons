package com.alexis.persons.services;

import com.alexis.persons.models.UserModel;
import com.alexis.persons.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserModel> obtainUsers(){
        return (List<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> obtainById(Long id){
        return userRepository.findById(id);
    }

    public List<UserModel> obtainByPriority(Integer priority){
        return userRepository.findByPriority(priority);
    }

    public boolean deleteById(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
