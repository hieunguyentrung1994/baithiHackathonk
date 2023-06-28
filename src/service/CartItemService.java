package service;

import model.CartItem;
import model.Catalog;


import java.util.ArrayList;
import java.util.List;

public class CartItemService {
    private List<CartItem> listCartItem = new ArrayList<>();
    public List<CartItem> getAll() {
        return listCartItem;
    }

    public void save(CartItem cartItem) {
        if (findById(cartItem.getCartItemId()) == null) {
            listCartItem.add(cartItem);
        } else {
            listCartItem.set(listCartItem.indexOf(findById(cartItem.getCartItemId())), cartItem);
        }
    }
    public CartItem findById(String String) {
        for (CartItem c : listCartItem) {
            if (c.getCartItemId() == String) {
                return c;
            }
        }
        return null;
    }
    public void delete(String integer) {
        if (findById(integer) != null) {
            listCartItem.remove(findById(integer));
        } else {
            System.err.println("Không có mục lục này");
        }
    }
    public void deleteCart() {
        listCartItem.clear();
    }
}
