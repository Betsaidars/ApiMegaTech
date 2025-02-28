package com.example.ApiMegaTech.Exceptions;

public class BannerNotFoundException extends RuntimeException{

    public BannerNotFoundException(String message){
        super(message);
    }

    public BannerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

}
