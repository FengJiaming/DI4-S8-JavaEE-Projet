package myWebSpringMVC.bl.concrete;

import java.util.List;
import myWebSpringMVC.domain.model.UserAccount;
import myWebSpringMVC.domain.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAccountManager {
    
    private UserAccountRepository repo;
    
    @Autowired
    public UserAccountManager(UserAccountRepository uarepo) {
        this.repo = uarepo;
    }
    
    public UserAccount getUserAccountById(int id) {
        return this.repo.findById(id).get();
    }
    
    public void setUserAccount(UserAccount user){
        this.repo.save(user);
    }
    
    public void deleteUserAccountById(int id){
        this.repo.delete(this.repo.findById(id).get());
    }
    public void updateUserAccount(UserAccount user){
        this.repo.saveAndFlush(user);
    }
   
//   public UserAccount getUserAccountByLastName(String lastname) {
//       return this.repo.findByLastnameOrFirstName(lastname); 
//    }
/*
    public boolean isValidLogin(String username, String password) {
        // String username;
        //username = 
        UserAccount userAccount = this.getUserAccountByFirstName(username);
        if (userAccount == null) {
            return false;
        } else {
            if (userAccount.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }
*/
    //TO DO get all UserAccount
    public List<UserAccount> all() {
        return this.repo.findAll();
    }
    
    
   // public UserAccount getUserInfo
    //public UserAccount supprimer()
    
            //userRepository.findAll();
    
}
