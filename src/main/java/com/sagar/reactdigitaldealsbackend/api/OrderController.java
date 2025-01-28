package com.sagar.reactdigitaldealsbackend.api;

import com.sagar.reactdigitaldealsbackend.model.Cart;
import com.sagar.reactdigitaldealsbackend.model.Cartitemdummy;
import com.sagar.reactdigitaldealsbackend.model.Order;
import com.sagar.reactdigitaldealsbackend.model.User;
import com.sagar.reactdigitaldealsbackend.repository.CartitemRepo;
import com.sagar.reactdigitaldealsbackend.service.CartService;
import com.sagar.reactdigitaldealsbackend.service.CartitemdummyService;
import com.sagar.reactdigitaldealsbackend.service.OrderService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartitemdummyService cartitemdummyService;

    @Autowired
    private CartitemRepo cartitemRepo;

    @GetMapping("/")
    public List<Order> getAllOrders(HttpSession session) {
        User user = (User) session.getAttribute("activeUser");
        return orderService.getAllOrdersByUser(user);
    }

    @Transactional
    @GetMapping("/save")
    public void saveOrder(HttpSession session) {
        User activeUser = (User) session.getAttribute("activeUser");

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCartitemdummys(cartitemdummyService.getAllCartitemdummiesByCart(cartService.getCartByUser(activeUser)));
        order.setTotalAmount(cartService.getCartByUser(activeUser).getTotalAmount());
        order.setDeliveryStatus("Pending Approval");
        order.setUser(activeUser);

        orderService.addOrder(order);

        List<Cartitemdummy> dummies = order.getCartitemdummys();
        for (Cartitemdummy dummy : dummies) {
            if(dummy.getOrderId() == 0){
                dummy.setOrderId(order.getId());
            }
        }

        order.setCartitemdummys(cartitemdummyService.getAllCartitemdummiesByCartAndOrderId(cartService.getCartByUser(activeUser), order.getId()));
        orderService.updateOrder(order);


        cartitemRepo.deleteAllByCart(cartService.getCartByUser(activeUser));
        Cart cart = cartService.getCartByUser(activeUser);
        cart.setTotalAmount(0.0);
//        cart.setCartItems(null);
        cart.setCheckedOut(false);
        cartService.updateCart(cart);

    }
}
