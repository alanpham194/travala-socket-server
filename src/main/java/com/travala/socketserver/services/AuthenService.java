package com.travala.socketserver.services;

import javax.naming.AuthenticationException;

public interface AuthenService {
    void authen(String token) throws AuthenticationException;
}
