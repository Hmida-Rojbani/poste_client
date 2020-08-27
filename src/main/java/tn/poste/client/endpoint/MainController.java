package tn.poste.client.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	// Inject via application.properties.
    @Value("${welcome.message}")
    private String message;
	
    
    @GetMapping({"","/","/index","/index.html"})
	public String getHome(Model model) {

        model.addAttribute("message1", message);
 
        return "index";
	}

}
