package com.example.getinline.controller;

import com.example.getinline.constant.PlaceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//뷰들 admin으로 시작하는 Convention을 위해
//클래스 레벨로 매핑하고 그밑에 연결되는 식
//admin/places -> places
@RequestMapping("/admin")
@Controller
public class AdminController {

//    @GetMapping("/places")
//    public String adminPlaces() { return "admin/places"; }
    @GetMapping("/places")
    public ModelAndView adminPlaces(
            PlaceType placeType,
            String placeName,
            String address
    ) //@RequestParam = true가 기본인데, 안적으면 기본값이 false 어차피 전부 optional이라
    {

        Map<String,Object> map = new HashMap<>();
        map.put("placeType",placeType);
        map.put("placeName",placeName);
        map.put("address",address);
        return new ModelAndView("admin/places",map);
    }

    @GetMapping("/places/{placeId}")
    public String adminPlaceDetail(@PathVariable Integer placeId) { return "admin/place-detail"; }

    @GetMapping("/events")
    public String adminEvents() { return "admin/events"; }

    @GetMapping("/events/{eventId}")
    public String adminEventDetail(@PathVariable Integer eventId) { return "admin/event-detail"; }
}
