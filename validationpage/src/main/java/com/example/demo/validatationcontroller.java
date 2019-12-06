package com.example.demo;
import java.awt.List;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class validatationcontroller {
	
	@Autowired
	validationRepository valid;
	
	 @RequestMapping(method=RequestMethod.GET, value="/get")
	    public Iterable<validatepojo> details() {
	        return valid.findAll();
	    }
	    
	    @RequestMapping(method=RequestMethod.POST, value="/post")
	    public Boolean save(@RequestBody validatepojo v) {
	    	Iterable<validatepojo> alldata = valid.findAll(); 
	    	for(validatepojo value:alldata) 
	    		if(value.getUsername().equals(v.getUsername()) || value.getEmailid().equals(v.getEmailid())) 
	    			return false;
	    	String password = getEncryptedPassword(v.getPassword());
	    	v.setPassword(password);
	        valid.save(v);
	        return true;
	    }
//	    

	    @RequestMapping(method=RequestMethod.GET, value="/delall")
	    public String deleteall() {
	                valid.deleteAll();
	        return "DELETED ALL DATA";
	    }
	    @Autowired
	    loginrepository login;
//  Login login;
	    
	    
	    
	    @RequestMapping(method=RequestMethod.POST, value="/enter")
	    public String userlogin(@RequestBody Login data) {
		/*
		 * String pwd = ""; Iterable<validatepojo> alldata = valid.findAll();
		 * for(validatepojo value:alldata)
		 * if(value.getUsername().equals(data.getUsername())) { pwd =
		 * getEncryptedPassword(data.getPassword()); if(value.getPassword().equals(pwd))
		 * return true; }
		 return false;
	    	*/
	    try {	
	    	Optional<validatepojo> oneuser = valid.findById(data.getUsername());
	    	validatepojo value = oneuser.get();
	    	if(getEncryptedPassword(data.getPassword()).equals(value.getPassword()))
	    		if(value.isAdmin()) return "admin";
	    		else return "user";
	    	else return "invalid";
	    	
	    }
	    catch(Exception e) {
	    	return "invalid";
	    }
		}
	    
	    
	    public static String getEncryptedPassword(String passwordToHash)   {  
	    	  
	        String generatedPassword = null;
	        try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(passwordToHash.getBytes());
	            //Get the hash's bytes 
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            generatedPassword = sb.toString();
	        } 
	        catch (NoSuchAlgorithmException e) 
	        {
	            e.printStackTrace();
	        }
	        System.out.println(generatedPassword);
	        return generatedPassword;
	        
	    }
//	    @RequestMapping(method=RequestMethod.POST, value="/enter")
//	    public Boolean userlogin(@RequestBody Login data) {
//			String pwd = "";
//			Iterable<Login> alldata = login.findAll(); 
//	    	for(Login value:alldata) 
//	    		if(value.getUsername().equals(data.getUsername())) {
//	    			pwd = encryption(data.getPassword());
//	    			if(pwd.equals(value.getPassword())) return true;
//	    		}
//	    	return false;
//		}
		
	    
//	    @RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
//	    public String delete(@PathVariable String id) {
//	        Optional<validatepojo> validate = valid.findById(id);
//	        validatepojo v = validate.get();
//	        valid.delete(v);
//	        return "";
//	    }
	   
	    @RequestMapping(method=RequestMethod.PUT, value="/edit/{id}")
	    public validatepojo update(@PathVariable String id, @RequestBody validatepojo contact) {
	        Optional<validatepojo> optcontact = valid.findById(id);
	        validatepojo c = optcontact.get();
	        if(contact.getUsername() != null)
	            c.setUsername(contact.getUsername());
	        if(contact.getFirstname() != null)
	            c.setFirstname(contact.getFirstname());
	        if(contact.getLastname() != null)
	            c.setLastname(contact.getLastname());
	        if(contact.getEmailid() != null)
	            c.setEmailid(contact.getEmailid());
	       valid.save(c);
	        return c;
	    }
	    
	    @RequestMapping(method=RequestMethod.GET, value="/{id}")
	    public Optional<validatepojo> User(@PathVariable String id) {
	    	System.out.println("in sts");
	    	
	    	return valid.findById(id);
	    }
	    
	   // @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
//	    public List<validatepojo> findByUserName(@PathVariable String userName) {
//	    	System.out.println("finding user details by username");
//	        return validationRepository.findByUserName(userName);
//	    } 
	    
	    @RequestMapping(method=RequestMethod.DELETE, value="/del/{id}")
	    public String delete(@PathVariable String id) {
	        Optional<validatepojo> optcontact = valid.findById(id);
	        validatepojo contact = optcontact.get();
	       valid.delete(contact);

	        return "deleted";
	    }
	    
	    
	    
}
