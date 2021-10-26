package com.aniket.services;

import com.aniket.constant.Gender;
import com.aniket.exception.StudentNotRegisteredException;

public interface StudentInterface {

    public void register(String name, String userId, String password, Gender gender, int batch, String branchName,
            String address, String country) throws StudentNotRegisteredException;

}
