
package myWebSpringMVC.domain.repository;

import myWebSpringMVC.domaine.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<UserAccount, Integer> {
    
}
