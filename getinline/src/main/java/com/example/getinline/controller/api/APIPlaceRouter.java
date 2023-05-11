package com.example.getinline.controller.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.web.servlet.function.RouterFunctions.route;

//컨트롤러 안쓰고 Configuration써서
//HandlerFunction == @RequestMapping
//Input : ServerRequest / Output : ServerResponse
//RouterFunction == @RequestMapping <- 이거를 구현
//Input : ServerRequest / Output : Optional<HandlerFunction>
@Configuration
public class APIPlaceRouter {
/*
2023-05-11 23:31:46.618 DEBUG 2072 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : 19 mappings in 'requestMappingHandlerMapping'
2023-05-11 23:31:46.624 DEBUG 2072 --- [           main] o.s.w.s.f.support.RouterFunctionMapping  : 1 RouterFunction(s) in 'routerFunctionMapping'
actuator/mappings는 reqeust mapping path보여줘서 이 라우터는 안보임
actuator/beans에서는 빈은 보임
"placeRouter": {
          "aliases": [

          ],
          "scope": "singleton",
          "type": "org.springframework.web.servlet.function.RouterFunctionBuilder$BuiltRouterFunction",
          "resource": "class path resource [com/example/getinline/controller/api/APIPlaceRouter.class]",
          "dependencies": [
            "APIPlaceRouter"
          ]
        },
 */
    //기본적으로 Dependency Injection할때 이렇게 해줄 수 있는데
    //private final APIPlaceHandler apiPlaceHandler;
    //Configuration쓰니까 Bean 메소드의 입력인자가 bean이 되어야해서 알아서 Injection해줌
    @Bean
    public RouterFunction<ServerResponse> placeRouter(APIPlaceHandler apiPlaceHandler){
        //nesting으로 동일경로 묶어서 하위로 내려줌
        //여기는 /api/places로 묶어서 루트 path / 추가할 필요없음
        return route().nest(path("/api/places"),builder -> builder
                .GET("",apiPlaceHandler::getPlaces)
                .POST("",apiPlaceHandler::createPlace)
                .GET("/{placeId}",apiPlaceHandler::getPlace)
                .PUT("/{placeId}",apiPlaceHandler::modifyPlace)
                .DELETE("/{placeId}",apiPlaceHandler::removePlace)
                )
                .build();
        //pattern, function 그냥 넣어줘도 되는데 handler function 분리해서 넣어줌

    }
}
