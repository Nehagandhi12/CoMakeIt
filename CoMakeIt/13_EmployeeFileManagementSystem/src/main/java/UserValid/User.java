//This is the bean class for user table
package UserValid;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	private int userid;
	private String username;
	private String userpassword;
	private String address;
	private String startdate;
	private int firsttimelogin;
	private int grantedpermission;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String localDate) {
		this.startdate = localDate;
	}

	public int getFirsttimelogin() {
		return firsttimelogin;
	}

	public void setFirsttimelogin(int firsttimelogin) {
		this.firsttimelogin = firsttimelogin;
	}

	public int getGrantedpermission() {
		return grantedpermission;
	}

	public void setGrantedpermission(int grantedpermission) {
		this.grantedpermission = grantedpermission;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return userpassword;
	}

	public void setPassword(String password) {
		this.userpassword = password;
	}
}
