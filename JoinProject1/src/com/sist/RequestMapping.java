package com.sist;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 *  @Ÿ��
 * 	class A
 * 	{
 * 		@�ʵ�
 * 		B b;
 * 		@�޼ҵ�
 * 		public void setA(@�Ķ���� A a)
 * 		{
 * 
 * 		}
 * 	}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
public @interface RequestMapping {
	public String value();
}
