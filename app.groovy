@RestController
class ThisWillActuallyRun {

    @RequestMapping("/g")
    String home() {
        return "Hello World from groovy!"
    }

}
