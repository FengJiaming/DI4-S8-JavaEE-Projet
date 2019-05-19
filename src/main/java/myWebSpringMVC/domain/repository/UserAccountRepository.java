package myWebSpringMVC.domain.repository;

import java.util.List;
import myWebSpringMVC.domain.model.UserAccount;
//import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    public UserAccount findByEmail(String email);

    public UserAccount findByEmailAndPassword(String email, String password);

}
