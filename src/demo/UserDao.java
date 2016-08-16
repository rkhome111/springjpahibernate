package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.springframework.orm.jpa.JpaTemplate;

//import org.springframework.orm.jpa.JpaTemplate;

public class UserDao 
{
	JpaTemplate template;

	public JpaTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JpaTemplate template) {
		this.template = template;
	}
	
	public void saveWithJPATemplate(User user)
	{
		template.persist(user);
	}
	
	public static void saveWithJPA(User user)
	{
		EntityManager em = EntityManagerProvider.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(user);
		tx.commit();
		em.close();
	}
	
	public static void save(User user)
	{
		Session hs = MyHibernateFactory.getSession();
		hs.beginTransaction();
		hs.save(user);
		hs.getTransaction().commit();
		hs.close();
	}
	
	public static void update(User user)
	{
		Session hs = MyHibernateFactory.getSession();
		hs.beginTransaction();
		hs.update(user);
		hs.getTransaction().commit();
		hs.close();
	}
	
	public static void saveOrUpdate(User user)
	{
		EntityManager em = EntityManagerProvider.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(user);
		tx.commit();
		em.close();
	}
	

}
