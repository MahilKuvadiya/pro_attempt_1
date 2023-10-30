package com.example.pro_attempt_1.webSocket;
import jakarta.servlet.http.HttpSession;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.*;
public class configuratorTesT extends ServerEndpointConfig.Configurator{
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        super.modifyHandshake(sec, request, response);
        System.out.println("server endpoint config");
        sec.getUserProperties().put("username",(String)((HttpSession) request.getHttpSession()).getAttribute("username"));
    }
}
