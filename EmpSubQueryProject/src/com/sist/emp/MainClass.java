package com.sist.emp;
import java.util.*;
import com.sist.dao.*;
import java.io.*;
public class MainClass {

	public static void main(String[] args) {
		EmpDAO dao=new EmpDAO();
		ArrayList<DeptDTO> list=dao.deptAllData();
		try
		{
			String data="deptno,dname,loc\n";
			for(DeptDTO d:list)
			{
				data+=d.getDeptno()+","
						+d.getDname()+","
						+d.getLoc()+"\n";
			}
			System.out.println(data);
			FileWriter fw=new FileWriter("c:\\image\\dept.csv");
			fw.write(data);
			fw.close();
		}
		catch(Exception ex){}
		/*ArrayList<EmpDTO> list=dao.empAllData();
		try
		{
			String data="empno,ename,job,mgr,hiredate,sal,comm,deptno\n";
			for(EmpDTO d:list)
			{
				data+=d.getEmpno()+","
						+d.getEname()+","
						+d.getJob()+","
						+d.getMgr()+","
						+d.getHiredate().toString()+","
						+d.getSal()+","
						+d.getComm()+","
						+d.getDeptno()+"\n";
				
			}
			System.out.println(data);
			FileWriter fw=new FileWriter("c:\\image\\emp.csv");
			fw.write(data);
			fw.close();
		}catch(Exception ex){}*/

	}

}
