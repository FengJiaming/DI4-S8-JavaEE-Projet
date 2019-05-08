
package myWebSpringMVC.domain.repository;

import static java.util.Date.from;
import java.util.List;
import myWebSpringMVC.domain.model.UserAccount;
//import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    
     UserAccount findByEmail(String email);

}
 






