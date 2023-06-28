package run;

import config.Inputmethods;
import controller.CartItemColtroller;
import controller.CatalogController;
import controller.ProductController;

public class Main {

	static ProductController productController = new ProductController();
	static CatalogController catalogController = new CatalogController();
	static CartItemColtroller cartItemColtroller = new CartItemColtroller();
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("**************************BASIC-MENU**************************");
			System.out.println("1. Quản lý danh mục \n" +
					  "2. Quản lý sản phẩm \n" +
					"3. Dành cho người dùng (***) \n" +
					  "4. Thoát ");
			System.out.print("Mời bạn lựa chọn: ");
			int choose = Inputmethods.getInteger();
			switch (choose) {
				case 1:
					new CatalogManager(catalogController);
					break;
				case 2:
					new ProductManager(productController, catalogController);
					break;
				case 3:
					new CartItemManager(cartItemColtroller, productController);
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.err.println("Không đúng vui lòng nhập lại!!!");
					break;
			}
		}
	}
}