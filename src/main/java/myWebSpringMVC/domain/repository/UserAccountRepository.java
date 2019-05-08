
package myWebSpringMVC.domain.repository;

import static java.util.Date.from;
import java.util.List;
import myWebSpringMVC.domain.model.UserAccount;
//import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
     //String findByLastnameOrFirstname(String firstname);
     
     UserAccount findByEmail(String email);
    
    //@Query("SELECT ua FROM UserAccount ua WHERE ua.email = :email AND ua.password = :password AND ua.isRemoved = 0")
    //public UserAccount findByEmail_Password(@Param("email") String email, @Param("password") String password);
    
    public UserAccount findByEmail_Password(String email, String password);
     //String findByLastnameOrFirstname(String firstname);
        //public String findByLastNameOrFirstName(String firstname);
    
    //@Query("select * from UserAccounts where LastName = ?1 or firstName = ?1")
    //UserAccount findByLastnameOrFirstName(String name); 
    
    
}
 






