package com.example.getinline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * View Controller 1
 * /            Get
 * /error       Get
 */
//이 클래스가 Controller bean으로 container에 등록
@Controller
public class BaseController implements ErrorController {

    /*
     기본적으로 내장 tomcat을 쓰기 때문에 특별한 설정이 없으면
     jsp로 인식함
     index.html 설정위치는 JspTemplateAvailabilityProvider.java 같은 부분에서 볼 수 있듯이
     src/main/webapp 이다.
     webapp폴더 만들어줘야함

     intellij에는 project structure에서 셋팅해줘야함
     project 내의 web 모듈 추가해야함
     그러나 community에는 없다 ㅎㅎ
     autoconfiguration을 쓰는 방법으로 해결 -> 아무 템플릿 엔진이면 되는데 thymeleaf를 활용
     기본경로가 resources의 templates가 됨
     spring.io 참고
     WebMvcAutoConfiguration.WelcomePageHandlerMapping()에서 index.html 찾아서 자동으로 매핑함
     loginfo로 확인 adding welcome page
     2023-05-11 22:34:45.402  INFO 12244 --- [           main] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
     */
    @GetMapping("/")
    public String root() {
        return "index";
    }
    //spec이 똑같음 baseController에서 error페이지 만들어줌
    //error page에 대한 제어권을 가져오기위해 implements ErrorController 해야한다
    @RequestMapping("/error")
    public String error() {
        return "error";
    }

}
