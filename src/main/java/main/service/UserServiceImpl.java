package main.service;

import lombok.extern.slf4j.Slf4j;
import main.entity.User;
import main.interfaces.UserService;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Cacheable(value = "user", key = "#user.name + #user.email")
    @Override
    public User saveAndReturnCache(User user) {
        log.info("User is creating " + user.toString());
        return userRepository.save(user);
    }

    @CachePut(value = "user", key = "#user.name + #user.email")
    @Override
    public User saveAndRefreshCache(User user){
        log.info("User is creating " + user.toString());
        return userRepository.save(user);
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User getUserById(int id) {
        log.info("Getting user by " + id);
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with " + id + " not found"));
    }
}
