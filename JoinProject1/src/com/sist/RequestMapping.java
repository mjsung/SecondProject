package com.sist;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 *  @타입
 * 	class A
 * 	{
 * 		@필드
 * 		B b;
 * 		@메소드
 * 		public void setA(@파라미터 A a)
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
