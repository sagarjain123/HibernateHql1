package com.sai.om.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;
@Entity
@Table(name="Irctc_table")
@NamedQuery(name="select query",query="select irc.trainDepature,irc.trainArrival from IrctcDTO irc where irc.trainId=:trainId")
public class IrctcDTO  implements Serializable{
	
	public IrctcDTO() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	@Id
	@GenericGenerator(name="ref",strategy="increment")
	@GeneratedValue(generator="ref")
	@Column(name="train_Id")
	private int trainId;
	@Column(name="train_Name")
	private String trainName;
	@Column(name="train_Arrival")
	private String trainArrival;
	@Column(name="train_Depature")
	private String trainDepature;
	@Column(name="train_Type")
	private String trainType;
	
	
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainArrival() {
		return trainArrival;
	}
	public void setTrainArrival(String trainArrival) {
		this.trainArrival = trainArrival;
	}
	public String getTrainDepature() {
		return trainDepature;
	}
	public void setTrainDepature(String trainDepature) {
		this.trainDepature = trainDepature;
	}
	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	@Override
	public String toString() {
		return "IrctcDTO [trainId=" + trainId + ", trainName=" + trainName + ", trainArrival=" + trainArrival
				+ ", trainDepature=" + trainDepature + ", trainType=" + trainType + "]";
	}
	
	

}
