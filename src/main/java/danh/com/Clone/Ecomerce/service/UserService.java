package danh.com.Clone.Ecomerce.service;

import danh.com.Clone.Ecomerce.entity.User;
import danh.com.Clone.Ecomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }

    public void createUser(User user){
        userRepository.save(user);
    }
}
