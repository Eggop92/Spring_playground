package seguros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/")
public class appController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "index";
    }

}
