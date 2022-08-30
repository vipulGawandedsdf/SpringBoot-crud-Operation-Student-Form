package com.cjc.main.service;

import com.cjc.main.model.Student;

public interface HomeService 
{

	public void saveData(Student s);
	public void loginCheck(String uname,String ps);
	public Iterable<Student> displayAll();
}
