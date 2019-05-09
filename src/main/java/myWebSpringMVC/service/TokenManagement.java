/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import org.json.*; 
//import org.json.simple.JSONObject;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
//import org.json.simple.parser.JSONParser;

/*import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
*/
/**
 *
 * @author FENG
 */
public class TokenManagement {

    private static final Logger logger = Logger.getLogger(TokenManagement.class);

    public TokenManagement(UserAccountManager uamanager) {

    }

    public static String generateToken(int userID, UserAccountManager uamanager) throws UnsupportedEncodingException {

        UUID uuid = UUID.randomUUID();
        logger.debug("generateToken" + uuid);
        uamanager.modifyUUID(userID, uuid.toString());

        /*Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.format(now);
        logger.debug(now);
        Date dateExp = new Date(now.getTime() + 3000000);
        sdf.format(dateExp);
        logger.debug(dateExp);*/
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime dateExp = today.plusMonths(6);
        JSONObject obj = new JSONObject();
        obj.put("userID", userID);
        obj.put("uuid", uuid.toString());
        obj.put("dateExp", dateExp);
        logger.debug(dateExp);
        logger.debug(obj.toString());
        //String token = new BASE64Encoder().encode(obj.toString().getBytes("UTF-8"));
        byte[] bytesEncoded = Base64.encodeBase64(obj.toString().getBytes());
        logger.debug(obj.toString().getBytes());
        System.out.println("encoded value is " + new String(bytesEncoded));
        String token = new String(bytesEncoded);
        logger.debug("token" + token);
        return token;

    }

    public static boolean verifyToken(String token, String UUID) throws Exception {

        
        //BASE64Decoder decoder = new BASE64Decoder();

        //String DecodedToken = new String(decoder.decodeBuffer(token), "UTF-8");
        String DecodedToken = new String(DatatypeConverter.parseBase64Binary(token));
        logger.info("Decoded Token  = " + DecodedToken);
        JSONObject obj = new JSONObject(DecodedToken);
        //JSONObject obj = (JSONObject)(new JSONParser().parse(DecodedToken));
        logger.debug("obj" + obj);
        String TokenUUID = (String) obj.get("uuid");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date dateExp = sdf.parse((String) obj.get("dateExp"));
//        Date now = new Date();
        LocalDateTime dateExp = LocalDateTime.parse(obj.getString("dateExp"), DateTimeFormatter.ISO_DATE_TIME);
        if (!TokenUUID.equals(UUID) || dateExp.compareTo(LocalDateTime.now()) < 1){
            logger.debug("Token is not match");
            return false;
        }
        
        return true;
    }
}
