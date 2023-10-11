package danh.com.Clone.Ecomerce.repository;

import danh.com.Clone.Ecomerce.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
