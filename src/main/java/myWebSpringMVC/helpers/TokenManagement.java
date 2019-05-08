/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.helpers;

import java.time.LocalDateTime;
import java.util.UUID;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import org.json.simple.JSONObject;

/**
 *
 * @author FENG
 */
public class TokenManagement {
    
    private UserAccountManager uamanager;
    
    public TokenManagement(UserAccountManager uamanager) {
        this.uamanager = uamanager;
    }
    
    public static String generateToken(int userID){
        
        //Generation of a random UUID
        UUID uuid = UUID.randomUUID();
        
        //Stocke UUID dans la base de données pour l'utilisateur correspondant à l'ID     // à implémenter
        uamanager.changeUserUUID(userID, randomUUIDString);
        
        //Generation of the Expiration Date (here localdatetime + 15 min)
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime expirationDate = today.plusMonths(6);
        
        //Creation de l'objet JSON
        JSONObject obj = new JSONObject();
        obj.put("userID",userID);
        obj.put("uuid",uuid.toString());
        obj.put("dateExp",expirationDate);
        
        //Encrypte le String de l'objet en BASE64
        byte[] bytesEncoded = Base64.encodeBase64(obj.toString().getBytes());
        System.out.println("encoded value is " + new String(bytesEncoded));
        String token = new String(bytesEncoded);
   
        //Renvoie les infos de connection ainsi que le token généré
        /*org.json.JSONObject objToken = new  org.json.JSONObject();
        objToken.put("userID",userID);
        objToken.put("token",token);
        objToken.put("ExpirationDate",expirationDate);*/
        
        return token;

    }
}
