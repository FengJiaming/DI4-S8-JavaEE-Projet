package myWebSpringMVC.bl.concrete;

import java.util.List;
import myWebSpringMVC.domain.model.UserAccount;
import myWebSpringMVC.domain.repository.UserAccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.util.DigestUtils;
//import org.springframework.util.DigestUtils;

@Component
public class UserAccountManager {
    private static final Logger logger = Logger.getLogger(UserAccountManager.class);
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
   
    public UserAccount getUserAccountByEmailPassword(String email, String password) {
        logger.info("getUserAccountByEmailPassword");/*
        UserAccount user = new UserAccount();
        if(!this.repo.findByEmailAndPassword(email, password).isEmpty()){
            logger.info("en?");
            user = this.repo.findByEmailAndPassword(email, password).get(0);
        }
        return user;
        */
        return this.repo.findByEmail(email);
        /*
        logger.info("getUserAccountByEmailPassword");
        UserAccount user = new UserAccount();
        if(!this.repo.findByLoginPass(email, password).isEmpty()){
            logger.info("en?");
            user = this.repo.findByLoginPass(email, password).get(0);
        }
        return user;*/
        //return this.repo.findByEmailAndPassword(email,password);
    }
    
    public void modifyUUID(int id, String uuid) {
        logger.info("enter modifyUUID:"+ id + "uuid :" + uuid);
        
        UserAccount user = getUserAccountById(id);
        logger.info(user.getID()+ " uuid:" + uuid);
        user.setUUID(uuid);
        this.repo.saveAndFlush(user);
        /*this.repo.save(user);
        this.repo.flush();*/
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
    public boolean verifierLogin(String email,String password){
            UserAccount user= new UserAccount();
            user=repo.findByEmail(email);
            return (user.getPassword().equals(password));
    }
    
    //TO DO get all UserAccount
    public List<UserAccount> all() {
        return this.repo.findAll();
    }
    
   // public UserAccount getUserInfo
    //public UserAccount supprimer()
    
    //userRepository.findAll();
    */
}
