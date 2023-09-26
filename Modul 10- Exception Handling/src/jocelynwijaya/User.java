package jocelynwijaya;

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
import jocelynwijaya.exception.*;


public class User {
	protected String nDepan, nBelakang, alamat;
	protected char kelamin;
	protected String username, pass;
	private MessageDigest digest;
	
	private static final int maxLoginAttempts = 3;
	private static int loginAttempts;
	
	private String hash(String strToHash) {
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
			
			return DatatypeConverter.printHexBinary(hash);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return "";
	}
	
	public User() {}
	
	public User (String nDepan, String nBelakang, char kelamin, String alamat, String username, String pass) {
		this.nDepan = nDepan;
		this.nBelakang = nBelakang;
		this.kelamin = kelamin;
		this.username = username;
		this.pass = hash(pass);
	}
	
	public boolean login (String uname, String pass) throws ExcessiveFailedLoginException, AuthenticationException {
		try {
            if (this.username.equals(uname)) {
                if (loginAttempts == maxLoginAttempts) {
                    loginAttempts++;
                    throw new ExcessiveFailedLoginException();
                } else if (loginAttempts > maxLoginAttempts) {
                    throw new ExcessiveFailedLoginException("Anda telah mencapai batas login");
                }

                if (this.pass.equals(hash(pass))) {
                    loginAttempts = 0;
                    return true;
                } else {
                    loginAttempts++;
                    throw new AuthenticationException("Username/password salah");
                }
            } else {
                throw new AuthenticationException("Username/password salah");
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
		return false;
	}
	
	public String greeting() {
		String greet = "Selamat Datang! ";
		greet += this.nDepan + " " + this.nBelakang;
		
		return greet;
	}
	
	public String getUsername() {
		return this.username;
	}
}
