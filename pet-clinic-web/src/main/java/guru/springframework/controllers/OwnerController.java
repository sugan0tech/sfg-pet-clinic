package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owner")
@Controller
public class OwnerController {
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getOwner(){
        return "owner/index";
    }
}
