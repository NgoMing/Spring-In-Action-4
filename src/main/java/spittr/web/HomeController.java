package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")    // Map controller to "/"
public class HomeController {

    // Handle Get request, return name of view that will be rendered
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
