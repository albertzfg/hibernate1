package com.hsp.view;

import java.util.Date;
import java.sql.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import org.hibernate.classic.Session;

import com.hsp.domain.Employee;
public class TestMian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ʹ��hibernate���CRUD����������ֻ�����󲻼���
		//1.��ʹ��service��ֱ�Ӳ���
		//1.����configuration,�ö������ڶ�ȡhibernate.cfg.xml������ɳ�ʼ��
		Configuration configuration=new Configuration().configure();
		//2.����SessionFactory����һ���Ự��������һ���������Ķ���
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		//3.����session[����servlet httpsession Ҳ����jsp session]
		Session session=sessionFactory.openSession();
		//4.����hibernate��˵��Ҫ�����Ա�����ӡ�ɾ�����޸ĵ�ʱ��ʹ�������ύ��������
		Transaction transaction =session.beginTransaction();
		//���һ����Ա
		Employee employee =new Employee();
		employee.setName("shunping");
		employee.setEmail("shunping@sohu.com");
		employee.setHiredate(new Date());
		//����
		session.save(employee);
		//�ύ
		transaction.commit();
		session.close();
		
		
	}

}
