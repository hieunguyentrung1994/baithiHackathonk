package bai2nangcao;

import config.Inputmethods;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class Main {
    public static void main(String[] args) {
        boolean feg = false;
        while (feg == false) {
            System.out.println("nhập số ISBN: ");
            String isbn = Inputmethods.getString();

            for (int i = 0; i < isbn.length(); i++) {
                if (!Character.isDigit(isbn.charAt(i))) {
                    System.out.println("Số ISBN không hợp lệ. Chỉ được nhập số.");
                    feg = false;
                    return;
                }
            }
                if (isbn.length() < 10 && isbn.length() > 10) {
                    System.out.println("nhâp lại ISBN phải trên 10 ký tự");
                    feg=false;
                    return;
                } else {
                    // tính tổng
                    int sum = 0;
                    for (int j = 0; j < 10; j++) {
                        int digit = Character.getNumericValue(isbn.charAt(j));
                        sum += (j + 1) * digit;
                    }

                    if (sum % 11 == 0) {
                        System.out.println("Số ISBN hợp lệ.");
                        feg= true;
                    } else {
                        System.out.println("Số ISBN không hợp lệ.");
                        feg=false;
                    }
                }



        }
    }
}