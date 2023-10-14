package danh.com.Clone.Ecomerce.repository;

import danh.com.Clone.Ecomerce.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
