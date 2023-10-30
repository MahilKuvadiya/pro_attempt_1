package com.example.pro_attempt_1.webSocket;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value="/EndPointTest")
public class EndPointTest {
    static Set<Session> theSet= Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void handleOpen(EndpointConfig endpointConfig,Session userSession){

        System.out.println("this is on open method");
        userSession.getUserProperties().put("username",endpointConfig.getUserProperties().get("username"));
        theSet.add(userSession);
    }

    @OnMessage
    public void handleMessage(String message,Session userSession){
        System.out.println("THis is on messege ethod");
        String username= (String) userSession.getUserProperties().get("username");
        if(username != null){
            theSet.stream().forEach(x -> {
                try{x.getBasicRemote().sendText(buildJSONData(username,message));}
                catch (Exception e){e.printStackTrace();}
            });
        }
    }

    @OnClose
    public void handleClose(Session userSession){
        theSet.remove(userSession);
    }

    private String buildJSONData(String username,String message){
        JsonObject jsonObject = Json.createObjectBuilder().add("message" ,username+" : "+message).build();
        StringWriter stringWriter = new StringWriter();
        try(
            JsonWriter jsonWriter = Json.createWriter(stringWriter)
        ){
            jsonWriter.write(jsonObject);
        }

        return stringWriter.toString();
    }
}
