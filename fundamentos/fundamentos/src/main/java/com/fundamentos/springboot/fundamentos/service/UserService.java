package com.fundamentos.springboot.fundamentos.service;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.IUserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);

    private IUserRepository _userRepository;

    public UserService(IUserRepository userRepository)
    {
        _userRepository = userRepository;
    }

    @Transactional
    public void SaveTransactional(List<User> users){
        users.stream()
                .peek(user-> LOG.info("Usuario insertado" + user))
                .forEach(_userRepository::save);
    }

    public List<User> getAllUsers(){
        return _userRepository.findAll();
    }

    public User Save(User newUser) {
        return _userRepository.save(newUser);
    }

    public void Remove(Long id) {
        _userRepository.deleteById(id);
    }

    public User Update(User newUser, Long id) {
        return _userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setName(newUser.getName());
                    user.setBirthDate(newUser.getBirthDate());
                    return _userRepository.save(user);
                }).get();
    }
}
