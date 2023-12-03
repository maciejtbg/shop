package pl.nauczycielmontessori.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nauczycielmontessori.shop.item.ItemService;
import pl.nauczycielmontessori.shop.item.ItemType;

import java.time.LocalDate;

@Controller
public class ShopController {

    private final ItemService itemService;

    @Autowired
    public ShopController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/rules")
    public String getRules(){
        return "rules";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }

    @GetMapping("/payments")
    public String getPayments(){
        return "payments";
    }

    @GetMapping("/shop")
    public String getItemsByType(@RequestParam(name = "type", required = false) String type,
                                 @RequestParam(name = "filter", required = false) String filter,
                                 Model model) {
        String itemsTitle = "Wszystkie";
        if (type != null) {
            ItemType itemType = ItemType.valueOf(type);
            itemsTitle = itemType.getDisplayName();
            model.addAttribute("allItems", itemService.getItemsByType(itemType));
        } else if (filter != null) {
            if (filter.equals("NEW")){
                model.addAttribute("itemsTitle","Najnowsze");

                LocalDate dateForNewItems = LocalDate.now().minusMonths(2); //2 months ago
                model.addAttribute("allItems", itemService.getItemsByDate(dateForNewItems));
            }
            if (filter.equals("MOST_POPULAR")){
                model.addAttribute("itemsTitle","Najbardziej popularne");
                int startingPopularity = 50;
                model.addAttribute("allItems",itemService.getByPopularity(startingPopularity));
            }
        }
        else {
            model.addAttribute("allItems", itemService.getAllItems());
        }
        model.addAttribute("currencySymbol",'$');
        model.addAttribute("itemsTitle",itemsTitle);

        return "shop";
    }
}
