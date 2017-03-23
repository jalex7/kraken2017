package hello

import org.springframework.http.*
import org.springframework.web.bind.annotation.*
 
class Greeting {  Integer id;  String message  }

@org.springframework.stereotype.Controller
@org.springframework.boot.autoconfigure.SpringBootApplication
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
            return new ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity.ok(greeting)
    }
 
    static def main(args) {  org.springframework.boot.SpringApplication.run(MyController, args)  }

}
