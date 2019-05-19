package myWebSpringMVC.bl.concrete;


import java.util.List;
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
    
    public Promotion getPromotionById(int id) {
        return this.repo.findById(id).get();
    }
    
    public void setPromotion(Promotion promo){
        this.repo.save(promo);
    }
    
    public void deletePromotionById(int id){
        this.repo.delete(this.repo.findById(id).get());
    }
    public void updatePromotion(Promotion promo){
        this.repo.saveAndFlush(promo);
    }

    public List<Promotion> all() {
        return this.repo.findAll();
    }
    
}
