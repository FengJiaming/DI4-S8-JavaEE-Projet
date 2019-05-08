/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import javax.inject.Inject;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import java.util.Date;
//import org.apache.commons.codec.binary.Base64;
import java.util.UUID;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;
import myWebSpringMVC.domain.model.UserAccount;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author FENG
 */
public class TokenManagement {

    private static final Logger logger = Logger.getLogger(TokenManagement.class);

    public TokenManagement(UserAccountManager uamanager) {

    }

    public static String generateToken(int userID, UserAccountManager uamanager) {

        UUID uuid = UUID.randomUUID();
        logger.debug(uuid);
        uamanager.modifyUUID(userID, uuid.toString());

        Date now = new Date();
        Date dateExp = new Date(now.getTime() + 3000000);
        JSONObject obj = new JSONObject();
        obj.put("userID", userID);
        obj.put("uuid", uuid.toString());
        obj.put("dateExp", dateExp);

        //Encrypte le String de l'objet en BASE64
        //byte[] bytesEncoded = Base64.encodeBase64(obj.toString().getBytes());
        //System.out.println("encoded value is " + new String(bytesEncoded));
        //String token = new String(bytesEncoded);
        String token = new String(obj.toString().getBytes());

        logger.debug("token" + token);
        return token;

    }

    public static boolean verifyToken(String token, String UUID) throws Exception {

        boolean verifie = true;
/*
        //Decrypte le Token
        String decodedString = new String(DatatypeConverter.parseBase64Binary(token));
        System.out.println("Decoded value is " + decodedString);
        logger.info(decodedString);

        //Parse la String Décryptée //Parse nfo D'un JSSOn contenu dans une string
        JSONObject objToken = new JSONObject(decodedString);
        //int userIDMember = objToken.getInt("userID");
        String UUIDMember = objToken.getString("uuid");
        LocalDateTime expirationDate = LocalDateTime.parse(objToken.getString("dateExp"), DateTimeFormatter.ISO_DATE_TIME);

        //Verification pour voir si toujours valide(ExpirationDate) et correspond à la personne qui se connecte
        if (!UUID.equals(UUIDMember)) {//Controle UUID attribuer à userIDMember doit correspndre à celui donné dans le Token
            throw new Exception("L'UUID du token ne correspond pas à l'UUID de l'utilisateur");
        } else if (LocalDateTime.now().isAfter(expirationDate) || LocalDateTime.now().isEqual(expirationDate)) {   // Controle Date Expiration
            throw new Exception("La Date d'expiration est depasse veuillez vous reconnecter");
        }
*/
        return verifie;
    }
}
