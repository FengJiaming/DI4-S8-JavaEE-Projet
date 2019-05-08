package myWebSpringMVC.bl.concrete;

import myWebSpringMVC.domain.repository.AddressRepository;

import myWebSpringMVC.domain.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressManager {
    
    private AddressRepository repo;
    
    @Autowired
    public AddressManager(AddressRepository uarepo) {
        this.repo = uarepo;
    }
    
    public Address getAddressById(int id) {
        return this.repo.findById(id).get();
    }
    
    public void setAddress(Address user){
        this.repo.save(user);
    }
    
    public void deleteAddressById(int id){
        this.repo.delete(this.repo.findById(id).get());
    }
    public void updateAddress(Address user){
        this.repo.saveAndFlush(user);
    }
    
}
