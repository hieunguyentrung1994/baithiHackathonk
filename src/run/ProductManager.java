package run;

import config.Inputmethods;
import controller.CatalogController;
import controller.ProductController;
import model.Product;

import java.util.Collections;
import java.util.Comparator;

public class ProductManager {
	private ProductController productController;
	private CatalogController catalogController;
	
	public ProductManager(ProductController productController, CatalogController catalogController) {
		this.productController = productController;
		this.catalogController = catalogController;
		while (true) {
			System.out.println("********************PRODUCT-MANAGEMENT********************");
			System.out.println("1. Nhập số sản sản phẩm và nhập thông tin sản phẩm\n" +
					  "2. Hiển thị thông tin các sản phẩm\n" +
					  "3. Sắp xếp sản phẩm theo giá giảm dần\n" +
					  "4. Xóa sản phẩm theo mã\n" +
					  "5. Tìm kiếm sách theo tên sách\n" +
					  "6. Thay đổi thông tin của sách theo mã sách\n" +
					  "7. Quay lại");
			System.out.print("Mời bạn lựa chọn: ");
			int choose = Inputmethods.getInteger();
			switch (choose) {
				case 1:
					addNewProduct();
					break;
				case 2:
					showListProduct();
					break;
				case 3:
					Collections.sort(productController.getAll());
					break;
				case 4:

					break;
				case 5:

					break;
				case 6:

					break;
				case 7:
					System.exit(0);
				default:
					break;
			}
		}
	}
	
	public void addNewProduct() {
		System.out.print("Nhập vào sô lượng sản phẩm muốn thêm vào: ");
		int n = Inputmethods.getInteger();
		for (int i = 0; i < n; i++) {
			System.out.println("hãy nhập sản phảm thư " + (i + 1));
			Product product = new Product();

			product.inputData(catalogController.getAll());
			productController.save(product);
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
	

	

	
}
