package com.example.getinline.controller.api;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.ServerResponse.ok;

import java.util.List;

@Component
public class APIPlaceHandler {

    public ServerResponse getPlaces(ServerRequest request) throws Exception {
        return ok().body(List.of("place1","place2"));
        //ToDo : created(URI.create("/api/places/1")).body(true) 로 변경해서 구현 (1은 제대로 넣어주자);
    }
    public ServerResponse createPlace(ServerRequest request) throws Exception {
        return ok().body(true);

    }
    public ServerResponse getPlace(ServerRequest request) throws Exception {
        return ok().body("place"+request.pathVariable("placeId"));
    }
    public ServerResponse modifyPlace(ServerRequest request) throws Exception {
        return ok().body(true);
    }
    public ServerResponse removePlace(ServerRequest request) throws Exception {
        return ok().body(true);
    }
}
