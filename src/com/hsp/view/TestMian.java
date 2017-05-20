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
		//我们使用hibernate完成CRUD操作（这里只见对象不见表）
		//1.不使用service，直接测试
		//1.创建configuration,该对象用于读取hibernate.cfg.xml，并完成初始化
		Configuration configuration=new Configuration().configure();
		//2.创建SessionFactory这是一个会话工厂，是一个重量级的对象
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		//3.创建session[不是servlet httpsession 也不是jsp session]
		Session session=sessionFactory.openSession();
		//4.对于hibernate来说，要求程序员在增加、删除、修改的时候使用事务提交！！！！
		Transaction transaction =session.beginTransaction();
		//添加一个雇员
		Employee employee =new Employee();
		employee.setName("shunping");
		employee.setEmail("shunping@sohu.com");
		employee.setHiredate(new Date());
		//保存
		session.save(employee);
		//提交
		transaction.commit();
		session.close();
		
		
	}

}
