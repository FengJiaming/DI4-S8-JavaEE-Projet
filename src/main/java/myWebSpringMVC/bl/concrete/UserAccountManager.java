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

    public void setUserAccount(UserAccount user) {
        int nbUser = this.repo.findAll().size();
        
        for (int i = 0; i < nbUser; i++) {

            if (user.getEmail().equals(this.repo.findAll().get(i).getEmail())) {
                return;
            }
        }
        this.repo.save(user);

    }

    public boolean verifierEmailExist(String email) {
        int nbUser = this.repo.findAll().size();

        for (int i = 0; i < nbUser; i++) {

            if (email.equals(this.repo.findAll().get(i).getEmail())) {
                return true;
            }
        }
        return false;
    }

    public void deleteUserAccountById(int id) {
        this.repo.delete(this.repo.findById(id).get());
    }

    public void updateUserAccount(UserAccount user) {
        this.repo.saveAndFlush(user);
    }

    public UserAccount getUserAccountByEmailPassword(String email, String password) {
        logger.info("getUserAccountByEmailPassword");
        return this.repo.findByEmailAndPassword(email, password);

    }

    public void modifyUUID(int id, String uuid) {
        logger.info("enter modifyUUID:" + id + "uuid :" + uuid);

        UserAccount user = getUserAccountById(id);
        logger.info(user.getID() + " uuid:" + uuid);
        user.setUUID(uuid);
        this.repo.saveAndFlush(user);
    }

    public UserAccount getUserAccountByEmail(String email) {
        return this.repo.findByEmail(email);
    }

    public boolean verifierLogin(String email, String password) {
        UserAccount user = new UserAccount();
        user = repo.findByEmail(email);
        return (user.getPassword().equals(password));
    }

    public List<UserAccount> all() {
        return this.repo.findAll();
    }

}
