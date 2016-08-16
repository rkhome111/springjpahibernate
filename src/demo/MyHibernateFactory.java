package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernateFactory 
{
	static SessionFactory factory;
	static Session hs;
	static
	{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");

		factory = cfg.buildSessionFactory();
		
	
	}
	
	public synchronized static Session getSession()
	{
		int i=0;
		if(hs!=null && hs.isOpen() && Thread.currentThread().getName().equalsIgnoreCase("ping Thread"))
			return null;
		
		while(hs!=null && hs.isOpen())
		{
			i++;
			System.out.println("-----------Hibernate session was active--------------");
			try{Thread.sleep(200);}catch(Exception e){}
			if(i>=10)
			{
				System.out.println("closing hibernate session forcely...");
				hs.close();
			}
		 }
		
		hs= factory.openSession();
		MyHibernateFactory.class.notify();
		return hs;
	}

}
