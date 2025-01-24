package com.sagar.reactdigitaldealsbackend.api;

import com.sagar.reactdigitaldealsbackend.model.Cart;
import com.sagar.reactdigitaldealsbackend.model.User;
import com.sagar.reactdigitaldealsbackend.serviceimpl.CartServiceImpl;
import com.sagar.reactdigitaldealsbackend.serviceimpl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private CartServiceImpl cartServiceImpl;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {

        User userInDB = userServiceImpl.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (userInDB != null && user.getUsername().equals(userInDB.getUsername()) && user.getPassword().equals(userInDB.getPassword())) {
            // a map to represent the response data
            session.setAttribute("activeUser", userInDB);
            session.setMaxInactiveInterval(300);
            System.out.println(session.getAttribute("activeUser"));

            logger.info("Session ID after login: " + session.getId());

            Map<String, Object> response = new HashMap<>();
            response.put("id", userInDB.getId());
            response.put("username", userInDB.getUsername());

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        if (session != null) {
            logger.info("Session ID before logout: " + session.getId());
            session.invalidate(); // Invalidate the session
        }
        // Redirect to the frontend login page
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:5173/login");
        return redirectView;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try{
            System.out.println(user.getEmail() + " " + user.getUsername());
            Cart c = new Cart();

            user.setCart(c);
            c.setUser(user);
            userServiceImpl.addUser(user);
            cartServiceImpl.addCart(c);

            return ResponseEntity.ok("Login successful");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid details. Registration failed.");
        }
    }
}