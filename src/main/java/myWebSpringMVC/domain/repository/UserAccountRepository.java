
package myWebSpringMVC.domain.repository;

import static java.util.Date.from;
import myWebSpringMVC.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

     //String findByLastnameOrFirstname(String firstname);
        //public String findByLastNameOrFirstName(String firstname);
    
//    @Query("select * from UserAccounts where LastName = ?1 or firstName = ?1")
//    UserAccount findByLastnameOrFirstName(String name); 
}
 



