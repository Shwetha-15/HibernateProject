package com.hibernate1;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import com.hibernate.HibernateProject.Users;
import com.mysql.cj.Session;
public class App 
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
Users user = new Users( 1, "Shwetha","Manjunath","shwetha@gmail.com");
// Start transaction
((SharedSessionContract) session).beginTransaction();
// Perform operation
((org.hibernate.Session) session).save(user);


// Commit the transaction 
((SharedSessionContract) session).getTransaction().commit();
System.out.println("Row Added");


} finally {
((SessionFactory) session).close();
factory.close();
}
}
}
