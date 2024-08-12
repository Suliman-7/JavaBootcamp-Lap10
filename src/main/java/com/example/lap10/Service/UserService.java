package com.example.lap10.Service;

import com.example.lap10.Model.User;
import com.example.lap10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser( int id , User user) {
        User u = userRepository.getById(id);
        if (u == null) {
            return false;
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setAge(user.getAge());
        u.setPassword(user.getPassword());
        userRepository.save(u);
        return true;
    }

    public boolean deleteUser(int id) {
        User user = userRepository.getById(id);
        if (user.equals(null)) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }
}
