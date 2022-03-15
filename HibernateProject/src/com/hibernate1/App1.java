package com.hibernate1;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import com.hibernate.HibernateProject.Users;
import com.mysql.cj.Session;
public class App1 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Users.class)
                .buildSessionFactory();

Session session = (Session) factory.getCurrentSession();

try {
// Create object of entity class type
Users user=new Users();
// Start transaction
((SharedSessionContract) session).beginTransaction();
user = ((org.hibernate.Session) session).get(Users.class,0);
//updating object
user.setUsers_fname("Priya");


// Commit the transaction 
((SharedSessionContract) session).getTransaction().commit();
System.out.println(user);


} finally {
((SessionFactory) session).close();
factory.close();
}
}
}
