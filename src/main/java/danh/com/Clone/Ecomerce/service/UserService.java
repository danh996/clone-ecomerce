package danh.com.Clone.Ecomerce.service;

import danh.com.Clone.Ecomerce.entity.Role;
import danh.com.Clone.Ecomerce.entity.User;
import danh.com.Clone.Ecomerce.exception.UserNotFoundException;
import danh.com.Clone.Ecomerce.repository.RoleRepository;
import danh.com.Clone.Ecomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    public static final int USERS_PER_PAGE = 4;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepo;
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    public Page<User> listByPage(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, USERS_PER_PAGE);
        return userRepository.findAll(pageable);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean isEmailUnique(String email) {
        User userByEmail = userRepository.getUserByEmail(email);

        return userByEmail == null;
    }

    public User get(Integer id) throws UserNotFoundException {
        try {
            return userRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException("Could not find any user with ID " + id);
        }
    }

    public List<Role> listRoles() {
        return (List<Role>) roleRepo.findAll();
    }

    public void deleteUser(Integer id) throws UserNotFoundException {
        Long countById = userRepository.countById(id);
        if (countById == null || countById == 0) {
            throw new UserNotFoundException("Could not find any user with ID " + id);
        }

        userRepository.deleteById(id);
    }

    public void updateUserEnabledStatus(Integer id, boolean enabled) {
        userRepository.updateEnabledStatus(id, enabled);
    }
}
