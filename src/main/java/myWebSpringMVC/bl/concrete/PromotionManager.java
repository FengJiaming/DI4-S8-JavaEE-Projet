package myWebSpringMVC.bl.concrete;

import myWebSpringMVC.domain.repository.AddressRepository;

import myWebSpringMVC.domain.model.Address;
import myWebSpringMVC.domain.model.Promotion;
import myWebSpringMVC.domain.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionManager {
    
    private PromotionRepository repo;
    
    @Autowired
    public PromotionManager(PromotionRepository prepo) {
        this.repo = prepo;
    }
    
    public Promotion getAddressById(int id) {
        return this.repo.findById(id).get();
    }
    
    public void setAddress(Promotion user){
        this.repo.save(user);
    }
    
    public void deletePromotionById(int id){
        this.repo.delete(this.repo.findById(id).get());
    }
    public void updatePromotion(Promotion user){
        this.repo.saveAndFlush(user);
    }
    
   
    
}
