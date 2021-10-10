package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//add annotations at a class level
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }
    //lives at /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    // lives at /hello/form
    // Create a form to take in user input
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +  /* submit a request to /hello */
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
