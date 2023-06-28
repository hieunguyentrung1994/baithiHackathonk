package model;

import config.Inputmethods;

import java.util.ArrayList;
import java.util.List;

public class CartItem {

private String cartItemId;
private String product;
private double price;
private int quantity;

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItem(String cartItemId, String product, double price, int quantity) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public void inputData(List<Product> list) {
    List<CartItem> cartItemList = new ArrayList<>();
        while (true) {
            boolean flag = false;
            System.out.print("Vui lòng chọn ID sản phẩm muốn thêm vào giỏ hàng: ");
            String id = Inputmethods.getString();
            if (id.equals(getCartItemId())){
                System.out.println("danh mục đã có trong giỏ hàng");
                break;
            }

            for (Product c : list) {
                if (id.equals(c.getProductId())) {
                   new CartItem(c.getProductId(),c.getProductName(),c.getProductPrice(),1);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                System.err.println("Danh mục không tồn tại, Vui lòng chọn lại: ");
            }
        }
    }

}
