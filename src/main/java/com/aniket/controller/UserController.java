package com.aniket.controller;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

import com.aniket.bean.Student;
import com.aniket.services.StudentInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private StudentInterface studentInterface;

    @RequestMapping(value = "/studentRegister", method = RequestMethod.POST)
    public Response register(@RequestBody Student student) {
        try {
            studentInterface.register(student.getName(), student.getUserId(), student.getPassword(),
                    student.getGender(), student.getBatch(), student.getBranchName(), student.getAddress(),
                    student.getCountry());
        } catch (Exception ex) {
            return Response.status(500).entity("Something went wrong! Please try again.").build();
        }
        return Response.status(201).entity("Registration Successful for " + student.getUserId()).build();
    }

    @RequestMapping(value = "/testApi", method = RequestMethod.GET)
    public String testApi() {
        return "Hello Api";
    }
}
