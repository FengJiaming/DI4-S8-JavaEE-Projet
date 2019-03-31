
package myWebSpringMVC.domain.repository;

import myWebSpringMVC.domaine.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<UserAccount, Integer> {
    
}
