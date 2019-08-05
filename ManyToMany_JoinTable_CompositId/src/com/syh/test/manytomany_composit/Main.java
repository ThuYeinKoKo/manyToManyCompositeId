package com.syh.test.manytomany_composit;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		User user1=(User) session.get(User.class, 1L);
		System.out.println("user1 :: "+user1);
				
		Set<UserGroup> userGroupList=new HashSet();
		userGroupList=user1.getUserGroups();
		
		for(UserGroup ug:userGroupList){
			
			System.out.println("ug :: "+ug);
			if(ug.getGroup().getId()==1){
				System.out.println("at ug id is 1");
				ug.setActivated(false);
				session.saveOrUpdate(ug);
			}else{
				System.out.println("at ug id is not 1");
			}
		}
		
		
	/*	User user = new User("sam", "mas", "sam@gmail.com");
		 
		Group group = new Group("Designer");
		session.save(group);
		 
		UserGroup userGroup = new UserGroup();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
		 
		user.addUserGroup(userGroup);
		 
		session.save(user);*/
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
