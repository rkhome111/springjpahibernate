package demo;

public class UserSaver {

	public static void main(String[] args) {
		
		User u = new User("roushan", "singh");
//		u.setId(11);
		UserDao dao =(UserDao) MyBeanFactoryProvider.getBeanFactory().getBean("userDao");
		dao.saveWithJPATemplate(u);
		System.out.println("sucessfully saved "+u);
//		UserDao.update(u);
//		System.out.println("sucessfully updated "+u);
//		u.setPassword("adfsdfs");
//		UserDao.saveOrUpdate(u);
//		System.out.println("sucessfully saveOrUpdated "+u);

	}
}
