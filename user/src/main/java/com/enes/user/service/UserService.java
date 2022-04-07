package com.enes.user.service;

import com.enes.user.entity.User;
import com.enes.user.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository repository;

    @Override
    public User create(User user){
        user.setCreated(LocalDate.now());
        return repository.save(user);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Override
    public List<User> listAll(){
        return repository.findAll();
    }

    @Override
    public Optional<User> findUser(Long id){
        return repository.findById(id);
    }

}
