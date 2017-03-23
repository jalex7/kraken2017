package hello
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
 
@Controller
@SpringBootApplication
class MyController {

    @RequestMapping(value = "/")
    def @ResponseBody hello() {
        println System.getenv()
        new File(".").eachFile() {  println it.getName()  }
        return "Hello World!"
    }

    @RequestMapping(value = "/g")
    def @ResponseBody gee() {
        return "gee"
    }

    static def main(args) {
        SpringApplication.run(MyController.class, args)
    }

}
