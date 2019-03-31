package myWebSpringMVC.bl.concrete;

import myWebSpringMVC.domaine.model.UserAccount;
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
    
    
    
   // public UserAccount getUserInfo
    //public UserAccount supprimer()
    
            //userRepository.findAll();
    
}
