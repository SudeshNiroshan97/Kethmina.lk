package com.example.kethminalk;

import java.io.Serializable;

public class SignupResponse implements Serializable {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
