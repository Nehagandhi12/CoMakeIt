package Assessment._EmployeeFileManagementSystem;
//As it is costly to create EntityManagerFactory again and again,this is a seperate class for doing it
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {
      private static EntityManager entitymanager=null; 
	  public static EntityManager get()
	  {
		 if(entitymanager==null) {
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("Bank");  
		  entitymanager=emf.createEntityManager();
		}

		 return entitymanager;
	}
}

