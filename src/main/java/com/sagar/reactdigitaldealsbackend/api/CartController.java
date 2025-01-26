package com.sagar.reactdigitaldealsbackend.api;

import com.sagar.reactdigitaldealsbackend.model.Cart;
import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import com.sagar.reactdigitaldealsbackend.model.User;
import com.sagar.reactdigitaldealsbackend.service.CartService;
import com.sagar.reactdigitaldealsbackend.service.CartitemService;
import com.sagar.reactdigitaldealsbackend.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    private List<Cartitem> getCartItems(HttpSession session) {
        User user = (User) session.getAttribute("activeUser");
        Cart cart = cartService.getCartByUser(user);
        System.out.println(cartitemService.getAllCartitemsByCart(cart));
        return cartitemService.getAllCartitemsByCart(cart);
    }

    @PostMapping("/add/{id}")
    private void addCartitem(@PathVariable int id, HttpSession session){

        User activeUser = (User) session.getAttribute("activeUser");
        System.out.println(activeUser);

        Cartitem ci = new Cartitem();
        ci.setProduct(productService.getProductById(id));
        ci.setPurchaseQuantity(1);
        ci.setPurchaseAmount(productService.getProductById(id).getDiscountedPrice());
        ci.setCart(cartService.getCartByUser(activeUser));
        cartitemService.addCartitem(ci);

        Cart c = cartService.getCartByUser(activeUser);
        c.setTotalAmount(c.getTotalAmount() + productService.getProductById(id).getDiscountedPrice());
        cartService.updateCart(c);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteCartitem(@PathVariable int id, HttpSession session){

        User activeUser = (User) session.getAttribute("activeUser");
        System.out.println(activeUser);

        Cartitem ci = cartitemService.getCartitemById(id);

        Cart c = cartService.getCartByUser(activeUser);
        c.setTotalAmount(c.getTotalAmount() - ci.getPurchaseAmount());
        cartService.updateCart(c);

        cartitemService.deleteCartitem(id);
    }
}
