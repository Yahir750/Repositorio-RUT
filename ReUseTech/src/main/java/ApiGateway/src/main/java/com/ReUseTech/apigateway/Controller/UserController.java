
package ApiGateway.src.main.java.com.ReUseTech.apigateway.Controller;



import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private Map<Long, String> users = new HashMap<>();
    private long idCounter = 1;

    @GetMapping
    public Map<Long, String> getAllUsers() {
        return users;
    }

    @PostMapping
    public String createUser(@RequestBody String user) {
        users.put(idCounter++, user);
        return "User created: " + user;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return users.remove(id);
    }
}
