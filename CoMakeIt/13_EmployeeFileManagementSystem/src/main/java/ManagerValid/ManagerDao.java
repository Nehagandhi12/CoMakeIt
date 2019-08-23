package ManagerValid;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.gson.Gson;

import AdminValid.Admin;
import Assessment._EmployeeFileManagementSystem.EntityFactory;

public class ManagerDao {
	// function to accept admin leave requests
	public void acceptleaverequest(int id) {
		EntityManager entitymanager = EntityFactory.get();
		entitymanager.getTransaction().begin();
		Leave leave = entitymanager.find(Leave.class, id);
		Query query = entitymanager
				.createNativeQuery("Update leavedetails set status='Accepted' where leaveid='" + id + "'");
		query.executeUpdate();
		Query query1 = entitymanager
				.createNativeQuery("Update admin set leavestatus=1 where adminid='" + leave.getEmpid() + "'");
		query1.executeUpdate();
		entitymanager.getTransaction().commit();
	}

//function to reject the admin leave reject
	public void rejectleaverequest(int id) {
		EntityManager entitymanager = EntityFactory.get();
		entitymanager.getTransaction().begin();
		Leave leave = entitymanager.find(Leave.class, id);
		Query query = entitymanager
				.createNativeQuery("Update leavedetails set status='Rejected' where leaveid='" + id + "'");
		query.executeUpdate();
		Query query1 = entitymanager
				.createNativeQuery("Update admin set leavestatus=2 where adminid='" + leave.getEmpid() + "'");
		query1.executeUpdate();
		entitymanager.getTransaction().commit();
	}

//function where manager applies the leave
	public void applyleave(Leave a) {
		EntityManager entitymanager = EntityFactory.get();
		entitymanager.getTransaction().begin();
		Admin admin = entitymanager.find(Admin.class, a.getEmpid());
		a.setManagerid(admin.getReportingTo());
		a.setStatus("Pending");
		if (a.getManagerid() != a.getEmpid()) {
			Query query = entitymanager
					.createNativeQuery("Update admin set leavestatus=0 where adminid='" + admin.getAdminid() + "'");
			query.executeUpdate();
			entitymanager.persist(a);
			entitymanager.getTransaction().commit();
		}
	}

//function to display list of admin/admins who have made a leave request
	public String grantleave(int id) {
		Gson gson = new Gson();
		EntityManager entitymanager = EntityFactory.get();
		entitymanager.getTransaction().begin();
		List<Leave> list = entitymanager
				.createQuery("Select x from leavedetails x where x.managerid='" + id + "' and x.status='Pending'",
						Leave.class)
				.getResultList();
		entitymanager.getTransaction().commit();
		return gson.toJson(list);
	}

//functio to get the status of their leave applied
	public int getstatusofleave(int id) {
		EntityManager entitymanager = EntityFactory.get();
		entitymanager.getTransaction().begin();
		Admin admin = entitymanager.find(Admin.class, id);
		int status = admin.getLeavestatus();
		entitymanager.getTransaction().commit();
		return status;
	}
}
