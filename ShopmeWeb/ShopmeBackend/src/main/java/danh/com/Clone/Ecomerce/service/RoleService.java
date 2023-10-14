package danh.com.Clone.Ecomerce.service;

import danh.com.Clone.Ecomerce.entity.Role;
import danh.com.Clone.Ecomerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> listAll(){
        return (List<Role>) roleRepository.findAll();
    }
}
