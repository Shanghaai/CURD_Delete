package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class DeleteClient {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t =  session.beginTransaction();
		
		Student st = new Student();
		st.setId(111);//only pk is enough to delete the record
		
		session.delete(st);
		t.commit();
		session.close();
		sf.close();
		System.out.println("Record deleted successfully");
	}

}
