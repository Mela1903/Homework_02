package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;
import pl.coderslab.model.ProductDao;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class CartController {
    private Cart cart;
    final ProductDao productListDao;


    public CartController(Cart cart, ProductDao productListDao) {
        this.cart = cart;
        this.productListDao = productListDao;
    }

    @GetMapping("/addtocart")
    @ResponseBody
    public String addToCart() {


        Random rand = new Random();
        Double price = rand.nextDouble();
        double v = Math.round(price * 100.0) / 100.0;

        this.cart.addToCart(new CartItem(1, new Product("product " + rand.nextInt(10), v)));

        return "addtocart";
    }

    @GetMapping(path = "/cart", produces = "text/html; charset = UTF-8")
    @ResponseBody
    public String cart() {
        String html = "<ul>\r\n<li>";
        String list = this.cart.getCartItems().stream()
                .map(CartItem::toString)
                .collect(Collectors.joining("</li>\r\n<li>"));

        return html + list + "</li></ul>";
    }

    @GetMapping(path = "/mycart", produces = "text/html; charset = UTF-8")
    public String showCart(Model model) {
        List<CartItem> cartItems = this.cart.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @GetMapping(path = "/increase/{productName}", produces = "text/html; charset = UTF-8")
    public String increaseQuantity(@PathVariable String productName) {
        List<CartItem> cartItems = this.cart.getCartItems();

        for (CartItem c : cartItems) {
            if (c.getProduct().getName().equals(productName)) {
                cart.increaseQuantity(c);
            }
        }
        return "redirect: /mycart";
    }

    @GetMapping("/form")
    public String addToCart(Model m) {
        m.addAttribute("product", productListDao.getProductList());
        return "add-form";
    }

    @PostMapping("/form")
    public String submit(@RequestParam String productList) {
        Product product = new Product();
        List<Product> products = this.productListDao.getProductList();
        List<CartItem> cartItems = this.cart.getCartItems();

        boolean exists = false;

        for (Product p : products) {
            if (p.getName().equals(productList)) {
                product = p;
            }
        }

        for (CartItem c : cartItems) {
            if (c.getProduct().equals(product)) {
                cart.increaseQuantity(c);
                exists = true;
                break;
            }
        }

        if (!exists){
                this.cart.addToCart(new CartItem(1, product));
            }
         return "redirect: /form";

    }

    @GetMapping(path = "/decrease/{productName}", produces = "text/html; charset = UTF-8")
    public String decreaseQuantity(@PathVariable String productName) {
        List<CartItem> cartItems = this.cart.getCartItems();

        for (CartItem c : cartItems) {
            if (c.getProduct().getName().equals(productName)) {
                cart.decreaseQuantity(c);
            }
        }
        return "redirect: /mycart";
    }
}



