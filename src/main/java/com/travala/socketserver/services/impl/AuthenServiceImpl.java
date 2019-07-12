package com.travala.socketserver.services.impl;

import com.travala.socketserver.services.AuthenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthenServiceImpl implements AuthenService {
    @Value("${SOCKET_SERVER_API_KEY}")
    private String socketServerAPIkey;

    @Override
    public void authen(String token) throws AuthenticationException {
        if (!socketServerAPIkey.equals(token))
            throw new AuthenticationException();
    }
}
