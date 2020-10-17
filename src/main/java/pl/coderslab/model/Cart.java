package pl.coderslab.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem cartItem){
        cartItems.add(cartItem);
    }

    public void removeFromCart(CartItem cartItem){
        cartItems.remove(cartItem);
    }

    public void increaseQuantity(CartItem cartItem){
        int i = cartItems.indexOf(cartItem);
        this.cartItems.get(i).setQuantity(this.cartItems.get(i).getQuantity() + 1);
    }

    public void decreaseQuantity(CartItem cartItem) {
        int i = cartItems.indexOf(cartItem);

        CartItem cartItem1 = this.cartItems.get(i);

        if (cartItem1.getQuantity() > 0) {
            cartItem1.setQuantity(cartItem1.getQuantity() - 1);
        }
    }
}

