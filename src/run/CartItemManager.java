package run;

import config.Inputmethods;
import controller.CartItemColtroller;
import controller.ProductController;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import model.CartItem;
import model.Catalog;
import model.Product;

import java.util.Collections;

public class CartItemManager {
    private CartItemColtroller cartItemColtroller;
    private ProductController productController;

    public CartItemManager(CartItemColtroller cartItemColtroller,ProductController productController) {
        this.cartItemColtroller = cartItemColtroller;
        this.productController = productController;
        while (true) {
            System.out.println("**************************MENU-USER**************************\n" +
                    "1. Xem danh sách sản phẩm \n" +
                    "2. Thêm vào giỏ hàng \n" +
                    "3. Xem tất cả sản phẩm giỏ hàng \n" +
                    "4. Thay đổi số lượng sản phẩm trong giỏ hàng \n" +
                    "5. Xóa 1sản phẩm trong giỏ hàng \n" +
                    "6. Xóa toàn bộ sản phẩm trong giỏ hàng \n" +
                    "7. Quay lại");
            System.out.println("Nhap vao lua chon cua ban");
            int choice = Inputmethods.getInteger();
            switch (choice) {
                case 1:
                    //xem danh danh sách sản phẩm
                    showListProduct();
                    break;
                case 2:
                    //Thêm vào giỏ hàng

                    createCartItem();
                    break;
                case 3:
                    // Xem tất cả sản phẩm giỏ hàng
                    showListCartItem();
                    break;
                case 4:
                    // Thay đổi số lượng sản phẩm trong giỏ hàng
                    updateQuantity();

                    break;
                case 5:
                    // Xóa 1sản phẩm trong giỏ hàng
                    removeCartItem();
                    break;
                case 6:
                    // Xóa toàn bộ sản phẩm trong giỏ hàng
                    deleteCart();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("khong hop le, thu lai");
            }
        }
    }

    public void showListProduct() {
        if (productController.getAll().size() == 0) {
            System.err.println("kho sản phẩm trống");
            return;
        }
        for (Product p : productController.getAll()) {
            System.out.println(p);
        }
    }

    public void createCartItem() {
        CartItem cartItem = new CartItem();
        cartItem.inputData(productController.getAll());
        cartItemColtroller.save(cartItem);
    }

    public void showListCartItem() {
        if (cartItemColtroller.getAll().size() == 0) {
            System.err.println("giỏ hàng trống");
            return;
        }
        for (CartItem p : cartItemColtroller.getAll()) {
            System.out.println(p);
        }
    }

    public void updateQuantity() {
        System.out.print("Sửa sô lượng sản phẩm trong giỏ hàng theo ID Sản phẩm giỏ hàng: \n điền ID SP ");
        String id = Inputmethods.getString();
        CartItem cartItem= cartItemColtroller.findById(id);
        if (cartItem == null) {
            System.err.println("Không tồn tại danh mục này");
            return;
        }
        CartItem newCartItem = new CartItem();
        newCartItem.setCartItemId(cartItem.getCartItemId());
        System.out.println("nhập số lượng muôn sửa sản phẩm");
        int sl = Inputmethods.getInteger();
        for (int i = 0; i < cartItemColtroller.getAll().size(); i++) {
            if(id.equals(cartItemColtroller.getAll().get(i).getCartItemId())){
                newCartItem = cartItemColtroller.getAll().get(i);
            }
        }
        cartItemColtroller.save(newCartItem);
    }
    public void removeCartItem(){
        System.out.print("Xóa 1 sản phẩm trong giỏ hàng theo ID Sản phẩm giỏ hàng : \n điền ID SP ");
        String id = Inputmethods.getString();
        CartItem cartItem= cartItemColtroller.findById(id);
        if (cartItem == null) {
            System.err.println("Không tồn tại danh mục này");
            return;
        }
        cartItemColtroller.delete(id);
    }
    public void deleteCart(){
        cartItemColtroller.deleteCart();
    }
}



