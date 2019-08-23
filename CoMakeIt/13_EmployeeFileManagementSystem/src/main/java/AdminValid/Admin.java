package AdminValid;

//Bean class for admin table
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	int adminid;
	String adminname;
	String password;

	int reportingTo;
	int leavestatus;

	public int getLeavestatus() {
		return leavestatus;
	}

	public void setLeavestatus(int leavestatus) {
		this.leavestatus = leavestatus;
	}

	public int getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(int reportingTo) {
		this.reportingTo = reportingTo;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return password;
	}

	public void setAdminpassword(String adminpassword) {
		this.password = adminpassword;
	}

}
