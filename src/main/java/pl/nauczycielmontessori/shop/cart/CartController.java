package pl.nauczycielmontessori.shop.cart;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.nauczycielmontessori.shop.item.Item;
import pl.nauczycielmontessori.shop.item.ItemType;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String showCart(Model model, HttpSession httpSession){
        List<Item> cart = (List<Item>) httpSession.getAttribute("cart");
        model.addAttribute("cart",cart);
        model.addAttribute("currencySymbol",'$');

        return "cart";
    }
}
