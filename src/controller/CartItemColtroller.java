package controller;

import model.CartItem;
import model.Catalog;
import service.CartItemService;

import java.util.List;

public class CartItemColtroller {

    private CartItemService cartItemServer = new CartItemService();



    public List<CartItem> getAll() {
        return cartItemServer.getAll();
    }
    public void save(CartItem cartItem) {
        cartItemServer.save(cartItem);
    }


    public CartItem findById(String integer) {
        return cartItemServer.findById(integer);
    }
    public void delete(String integer) {
        cartItemServer.delete(integer);
    }
    public void deleteCart(){
        cartItemServer.deleteCart();
    }

}
