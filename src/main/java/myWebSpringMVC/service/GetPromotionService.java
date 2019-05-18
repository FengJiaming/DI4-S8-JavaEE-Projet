/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;


import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import myWebSpringMVC.bl.concrete.PromotionManager;
import myWebSpringMVC.domain.model.Promotion;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FENG
 */
@RestController

@RequestMapping("/api/GetPromotionService")

public class GetPromotionService {

    private static final Logger logger = Logger.getLogger(GetPromotionService.class);
    
    @Resource
    PromotionManager pmanager;
    
    public GetPromotionService() {
        
    }
    
    @GetMapping(value = "/getPromotion", produces = MediaType.APPLICATION_JSON)
    public String getPromotionInfo(){

        JSONObject ObjPromotions = new JSONObject();
        JSONArray ArrayPromotions = new JSONArray();

        try {
            List<Promotion> ListPromotion = pmanager.all();

            for (int i = 0; i < ListPromotion.size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("key", ListPromotion.get(i).getStore_key());
                obj.put("position", ListPromotion.get(i).getPosition());
                obj.put("title", ListPromotion.get(i).getTitle());
                obj.put("shortDesc", ListPromotion.get(i).getShortDescription());
                obj.put("longDesc", ListPromotion.get(i).getLongDescription());
                obj.put("disabled", ListPromotion.get(i).isDisabled());
                obj.put("startDate", ListPromotion.get(i).getStartDate());
                obj.put("endDate", ListPromotion.get(i).getEndDate());
                obj.put("imageURL", ListPromotion.get(i).getImageURL());

                ArrayPromotions.add(i, obj);
            }

            ObjPromotions.put("promotions", ArrayPromotions);

        } catch (Exception e) {
            logger.error("Exception" + e.getMessage());
        }
        return ObjPromotions.toString();
    }
}
