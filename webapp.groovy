package hello
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
 
class Greeting {  Integer id;  String message  }

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

    List<Greeting> greetings = [new Greeting(id: 1, message: 'Hello'), new Greeting(id: 2, message: 'Hi'),
                                new Greeting(id: 3, message: 'Hola'), new Greeting(id: 4, message: 'Olá')]
 
    @RequestMapping(path= 'greetings/{id}', method = RequestMethod.GET, produces = 'application/json')
    ResponseEntity<?> getById(@PathVariable String id) {
        Greeting greeting = greetings.find { it.id == id.toInteger() }
        if (!greeting) {
            return new ResponseEntity(404)
        }
        return ResponseEntity.ok(greeting)
    }
 
    static def main(args) {  SpringApplication.run(MyController.class, args)  }

}
