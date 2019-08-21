package com.sai.om.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sai.om.HibernateUtil4;
import com.sai.om.dto.IrctcDTO;

public class IrctcDAO {
	public IrctcDAO() {
     System.out.println(this.getClass().getSimpleName()+"created");
	}
	
	public void saveIrctcDTO(IrctcDTO IrctcDTO)
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(IrctcDTO);
		transaction.commit();
		session.close();
		factory.close();
	}
	public void updateDTO(IrctcDTO IrctcDTO)
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		IrctcDTO dto1=session.get(IrctcDTO.getClass(), 3);
		dto1.setTrainDepature("goa");
		dto1.setTrainArrival("belgum");
		session.update(dto1);
		transaction.commit();
		session.close();
		factory.close();
	}
	public String getArrivalBytrainId(int trainId)
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		String query="select irtct.trainArrival from IrctcDTO irtct  where irtct.trainId='"+trainId+"'";
		Query query1=session.createQuery(query);
		
		String object=(String)query1.uniqueResult();
		System.out.println(object);
		session.close();
		return object;
	}
	public IrctcDTO getIrctcByArrival(String trainArrival)
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		String query="from IrctcDTO irc where irc.trainArrival='"+trainArrival+"'";
		Query query1=session.createQuery(query);
		IrctcDTO irctcDTO=(IrctcDTO)query1.uniqueResult();
		System.out.println(irctcDTO);
		session.close();
		return irctcDTO;
	}
	
	public void updatedepatureByArrival(String trainDepature ,String trainArrival)
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		String query="update IrctcDTO irc set irc.trainDepature='"+trainDepature+"' where irc.trainArrival='"+trainArrival+"'";
		Query query1=session.createQuery(query);
		int count=query1.executeUpdate();
		System.out.println(count);
		session.close();
	}
	public List<IrctcDTO> getListOfIrctc()
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		String query="select irc from IrctcDTO irc";
		Query query1=session.createQuery(query);
		List<IrctcDTO> irctcDTO=query1.list();
		session.close();
		return irctcDTO;
	}
	public void deleteBy(String trainDepature )
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		String query="delete from IrctcDTO irc where irc.trainDepature='"+trainDepature+"'";
		Query query1=session.createQuery(query);
		int count=query1.executeUpdate();
		System.out.println(count);
		session.close();
	}
	public Object[] gettrainNameAndtrainType()
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		String query="select irc.trainName,irc.trainType from IrctcDTO irc where irc.trainId='"+2+"'";
		Query query2=session.createQuery(query);
		Object[] String=(Object[]) query2.uniqueResult();
		return String;
	}
	
	public List<String> gettrainName()
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		String query="select trainName from IrctcDTO irc";
		Query query3=session.createQuery(query);
		List<String> Strings = query3.list();
		return Strings;
	}
	
	public Object[] getDepatureAndArrivalBytrainId(int id)
	{
		SessionFactory factory=HibernateUtil4.getFactory();
		Session session=factory.openSession();
		String query="";
		Query query2=session.getNamedQuery("select query");
		query2.setParameter("trainId", id);
		Object[] objects=(Object[])query2.uniqueResult();
		return objects;
	}
	
}
