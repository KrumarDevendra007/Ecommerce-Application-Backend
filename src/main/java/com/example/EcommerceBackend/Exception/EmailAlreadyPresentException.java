package com.example.EcommerceBackend.Exception;

public class EmailAlreadyPresentException extends  Exception{

    public EmailAlreadyPresentException(String message){
        super(message);
    }
}
