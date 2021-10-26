package com.aniket.dao;

import com.aniket.bean.Student;
import com.aniket.exception.StudentNotRegisteredException;

public interface StudentDaoInterface {

    public boolean addStudent(Student student) throws StudentNotRegisteredException;

}
