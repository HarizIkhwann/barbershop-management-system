package com.mybarbershop.barbershop.Users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Add methods to handle user-related operations, e.g., create, update, delete, find users
    public void createUser(Users user) {
        usersRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public Users updateUser(Long id, Users updatedUser) {
        if (!usersRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        updatedUser.setUserId(id);
        return usersRepository.save(updatedUser);
    }

}
