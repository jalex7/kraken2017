package hello

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MyController {
    @RequestMapping(value = "/")
    def @ResponseBody hello() {
        return "Hello World!"
    }
}
