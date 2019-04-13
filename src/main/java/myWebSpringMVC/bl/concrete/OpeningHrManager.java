package myWebSpringMVC.bl.concrete;

import myWebSpringMVC.domain.repository.OpeningHrRepository;
import myWebSpringMVC.domain.model.OpeningHr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpeningHrManager {
    
    private OpeningHrRepository repo;
    
    @Autowired
    public OpeningHrManager(OpeningHrRepository uarepo) {
        this.repo = uarepo;
    }
    
    public OpeningHr getOpeningHrById(int id) {
        return this.repo.findById(id).get();
    }
    
    public void setOpeningHr(OpeningHr user){
        this.repo.save(user);
    }
    
    public void deleteOpeningHrById(int id){
        this.repo.delete(this.repo.findById(id).get());
    }
    public void updateOpeningHr(OpeningHr user){
        this.repo.saveAndFlush(user);
    }
    
    
    
   // public UserAccount getUserInfo
   //public UserAccount supprimer()
    
   //userRepository.findAll();
    
}
