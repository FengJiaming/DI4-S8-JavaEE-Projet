package myWebSpringMVC.bl.concrete;

import myWebSpringMVC.domain.repository.StoreRepository;
import myWebSpringMVC.domaine.model.Store;
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
    
    
    
   // public UserAccount getUserInfo
   //public UserAccount supprimer()
    
   //userRepository.findAll();
    
}
