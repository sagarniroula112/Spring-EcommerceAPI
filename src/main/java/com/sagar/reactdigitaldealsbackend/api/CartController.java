package com.sagar.reactdigitaldealsbackend.api;

import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import com.sagar.reactdigitaldealsbackend.model.User;
import com.sagar.reactdigitaldealsbackend.service.CartService;
import com.sagar.reactdigitaldealsbackend.service.CartitemService;
import com.sagar.reactdigitaldealsbackend.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartitemService cartitemService;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    private List<Cartitem> getCartItems(User user){
        return cartitemService.getAllCartitemsByUser(user);
    }

    @PostMapping("/add/{id}")
    private void addCartitem(@PathVariable int id, HttpSession session){

        User activeUser = (User) session.getAttribute("activeUser");
        System.out.println(activeUser);

        Cartitem ci = new Cartitem();
        ci.setProduct(productService.getProductById(id));
        ci.setUser(activeUser);
        ci.setPurchaseQuantity(1);
        ci.setPurchaseAmount(productService.getProductById(id).getDiscountedPrice());
        ci.setCart(activeUser.getCart());
        cartitemService.addCartitem(ci);

    }
}
