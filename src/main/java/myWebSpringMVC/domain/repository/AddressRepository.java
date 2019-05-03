
package myWebSpringMVC.domain.repository;

import myWebSpringMVC.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}
 



