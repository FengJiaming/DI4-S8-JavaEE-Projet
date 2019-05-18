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
        int nbUser = this.repo.findAll().size();
        
        for(int i=0; i < nbUser ; i++){
            
            if(user.getEmail().equals(this.repo.findAll().get(i).getEmail())){
                return ;
            }
        }  
        this.repo.save(user);

    }
    
        public boolean verifierEmailExist(String email){
            int nbUser = this.repo.findAll().size();
        
            for(int i=0; i < nbUser ; i++){
            
                if(email.equals(this.repo.findAll().get(i).getEmail())){
                    return true;
                }
            }  
            return false;
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
        return this.repo.findByEmailAndPassword(email, password);
        //return this.repo.findByEmail(email);
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
//   List<UserAccount> findOneByEmail(String email){
//        return this.repo.findByEmail(email);
//   }
   
//   public UserAccount getUserAccountByLoginPassword(String login, String password) {
//        //logger.info("Entrée dans la fonction getUserAccountByLoginPassword");
////        UserAccount user = new UserAccount();
////        if(!this.repo.findByLoginPass(login, DigestUtils.md5Hex(password)).isEmpty()){
////            user = this.repo.findByLoginPass(login, DigestUtils.md5Hex(password)).get(0);
////        }
////        return user;
//        
//        UserAccount user = new UserAccount();
//        if(!this.repo.findByLoginPass(login, password).isEmpty()){
//            user = this.repo.findByLoginPass(login, password).get(0);
//        }
//        return user;
//    }
//    
//    public boolean userAccountExists(String email){
//        //logger.info("Entrée dans la fonction userAccountExists");  
//        return !this.repo.findByEmail(email).isEmpty();
//    }
   
   
   
   
   public UserAccount getUserAccountByEmail(String email) {
       return this.repo.findByEmail(email); 
    }

//    public boolean isValidLogin(String username, String password) {
//        // String username;
//        UserAccount userAccount = this.getUserAccountByLastName(username);
//        if (userAccount == null) 
//            return false;
//       
//        else{
//            if (userAccount.getPassword().equals(password)) {
//                return true;
//            }else{
//                return false;
//            }
//           
//        }
//    }
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
    
}
