package com.aniket.services;

import com.aniket.bean.Student;
import com.aniket.constant.Gender;
import com.aniket.constant.Role;
import com.aniket.dao.StudentDaoInterface;
import com.aniket.exception.StudentNotRegisteredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentOperationService implements StudentInterface {

    @Autowired
    private StudentDaoInterface studentDaoInterface;

    @Override
    public void register(String name, String userId, String password, Gender gender, int batch, String branchName,
            String address, String country) throws StudentNotRegisteredException {
        try {
            Student newStudent = new Student(userId, name, Role.STUDENT, password, gender, address, country, branchName,
                    0, batch, false);
            studentDaoInterface.addStudent(newStudent);
        } catch (StudentNotRegisteredException ex) {
            throw ex;
        }
    }

}
