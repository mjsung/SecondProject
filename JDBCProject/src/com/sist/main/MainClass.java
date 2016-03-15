package com.sist.main;
import com.sist.dao.*;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<EmpDTO> list=EmpDAO.empAllData();
		for(EmpDTO d:list)
		{
			System.out.println(d.getEmpno()+" "+d.getEname()+" "+d.getJob());
		}
	}

}
