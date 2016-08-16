package demo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerProvider 
{
	private static EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("user");
		
	}
	public static EntityManager getEntityManager()
	{
		return factory.createEntityManager();
	}
	
	public static EntityManagerFactory getEntityManagerFactory()
	{
		return factory;
	}
	
}
