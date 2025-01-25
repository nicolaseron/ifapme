package org.example.utils;

import com.password4j.BcryptFunction;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

public class bcrypt {

    BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);

    public String hashPassword(String password) {
        return Password.hash(password).with(bcrypt).getResult();
    }

    public boolean comparePassword(String password, String hashPassword) {
        return Password.check(password, hashPassword).with(bcrypt);
    }
}
