package myWebSpringMVC.bl.concrete;

import java.util.List;
import myWebSpringMVC.domain.repository.StoreRepository;
import myWebSpringMVC.domain.model.Store;
import myWebSpringMVC.domain.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreManager {
    
    private StoreRepository repo;
    
    @Autowired
    public StoreManager(StoreRepository uarepo) {
        this.repo = uarepo;
    }
    
    public Store getStoreById(int id) {
        return this.repo.findById(id).get();
    }
    
    public void setStore(Store user){
        this.repo.save(user);
    }
    
    public void deleteStoreById(int id){
        this.repo.delete(this.repo.findById(id).get());
    }
    public void updateStore(Store user){
        this.repo.saveAndFlush(user);
    }
    public List<Store> all() { 
        return this.repo.findAll(); 
    } 
    
}
