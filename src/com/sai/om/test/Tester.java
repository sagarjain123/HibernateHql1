package com.sai.om.test;

import java.util.List;

import com.sai.om.dao.IrctcDAO;
import com.sai.om.dto.IrctcDTO;

public class Tester {
	
	public static void main(String[] args) {
		IrctcDTO dto=new IrctcDTO();
		dto.setTrainId(1);
		dto.setTrainName("srs");
		dto.setTrainArrival("sbc");
		dto.setTrainDepature("bly");
		dto.setTrainType("S/L");
		
		IrctcDAO dao=new IrctcDAO();
		//dao.saveIrctcDTO(dto);
		//dao.updateDTO(dto);
//		String arrival=dao.getArrivalBytrainId(1);
		//System.out.println(arrival);
		//IrctcDTO dto1=dao.getIrctcByArrival("sbc");
		//System.out.println(dto1);
		//dao.updatedepatureByArrival("chennai","hubli");
		//List<IrctcDTO> list=dao.getListOfIrctc();
		//System.out.println(list);
//		dao.deleteBy("goa");
//		Object[] Strings=dao.gettrainNameAndtrainType();
//		for(Object String :Strings){
//			System.out.println(String);
//		}
//		List<String> list=dao.gettrainName();
//		System.out.println(list);
//		System.out.println("data save");
		Object[] objects=dao.getDepatureAndArrivalBytrainId(2);
		for(Object object:objects)
		{
			System.out.println(object);
		}
	}

}
