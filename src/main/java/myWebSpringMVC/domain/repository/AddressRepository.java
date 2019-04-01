
package myWebSpringMVC.domain.repository;

import myWebSpringMVC.domaine.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}
 



