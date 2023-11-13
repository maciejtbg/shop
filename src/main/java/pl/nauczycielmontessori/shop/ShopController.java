package pl.nauczycielmontessori.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.nauczycielmontessori.shop.item.ItemService;

@Controller
public class ShopController {

    private final ItemService itemService;

    @Autowired
    public ShopController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("allItems", itemService.getAllItems());

        return "shop";
    }
}
