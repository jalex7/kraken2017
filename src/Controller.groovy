package hello
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
 
@Controller
@SpringBootApplication
class MvcController {

  @RequestMapping(value = "/")
    def @ResponseBody hello() {
        return "Hello World!"
    }

    static def main(args) {
        SpringApplication.run(Application.class, args)
    }

}
