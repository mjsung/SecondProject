package com.sist.dao;
import java.util.*;
/*
 *       데이터형(오라클)					자바
 * 	CHAR, VARCHAR2, CLOB		String
 * 	NUMBER						int, double
 * 	DATE, TIMESTAMP				java.util.Date
 * 	BLOB, BFILE					InputStream
 *	
 *	=emp TABLE
 *	empno NUMBER(4)     ==> int
 *	ename VARCHAR2(10)	==> String
 *	job VARCHAR2(10)	==> String
 *	mgr NUMBER(4)		==> int
 *	hiredate DATE		==> Date
 *	sal NUMBER(7,2)		==> int, double
 *	comm NUMBER(7,2)	==> int
 *	deptno NUMBER(2) 	==> int
 *
 */
public class EmpDTO {
	private int empno;
	private String ename;
	private int mgr;
	private String job;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private String strSal;
	private String strDay;
	
	public String getStrSal() {
		return strSal;
	}
	public void setStrSal(String strSal) {
		this.strSal = strSal;
	}
	public String getStrDay() {
		return strDay;
	}
	public void setStrDay(String strDay) {
		this.strDay = strDay;
	}
	private DeptDTO ddto=new DeptDTO();
	private SalGradeDTO sdto=new SalGradeDTO();
	
	
	public DeptDTO getDdto() {
		return ddto;
	}
	public void setDdto(DeptDTO ddto) {
		this.ddto = ddto;
	}
	public SalGradeDTO getSdto() {
		return sdto;
	}
	public void setSdto(SalGradeDTO sdto) {
		this.sdto = sdto;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
