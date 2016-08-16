package demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MyBeanFactoryProvider {

	
		static BeanFactory factory;
		
		static
		{
			
			Resource r=new ClassPathResource("context.xml");
			factory=new XmlBeanFactory(r);
		}
		
		public static BeanFactory getBeanFactory()
		{
			return factory;
		}
}
