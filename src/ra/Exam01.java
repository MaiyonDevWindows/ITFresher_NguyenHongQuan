package ra;

import java.util.Scanner;

public class Exam01 {
    public static boolean checkNguyenTo(int number){
        if(number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayNumbers = new int[100];
        int choice = 0, n = 0;
        while (true) {
            System.out.print("************************MENU**************************\n" +
                    "1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím).\n" +
                    "2. In giá trị các phần tử trong mảng.\n" +
                    "3. Tính trung bình các phần tử dương (>0) trong mảng.\n" +
                    "4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong\n" +
                    "mảng (k nhập từ bàn phím).\n" +
                    "5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần.\n" +
                    "6. Tính số lượng các phần tử là số nguyên tố trong mảng.\n" +
                    "7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng\n" +
                    "dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần,\n" +
                    "các phần tử còn lại ở giữa mảng theo thứ tự tăng dần.\n" +
                    "8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm\n" +
                    "dần) đúng vị trí.\n" +
                    "9. Thoát.\n" +
                    "Lựa chọn của bạn là: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: {
                    int intValue;
                    System.out.print("Nhập giá trị n phần tử của mảng: ");
                    n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Nhập vào giá trị của arrayNumbers[%d]: ", i);
                        arrayNumbers[i] = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                }
                case 2: {
                    System.out.println("In ra giá trị các phần tử có trong mảng: ");
                    for (int i = 0; i < n; i++)
                        System.out.print(arrayNumbers[i] + " ");
                    System.out.println();
                    break;
                }
                case 3: {
                    int positiveCount = 0, positiveSum = 0;
                    float positiveAverage = 0;
                    System.out.println("Tính trung bình các phần tử dương trong mảng: ");
                    for (int i = 0; i < n; i++) {
                        if (arrayNumbers[i] > 0) {
                            positiveSum += arrayNumbers[i];
                            positiveCount++;
                        }
                    }
                    positiveAverage = (float) positiveSum / positiveCount;
                    System.out.println("Trung bình các phần tử dương trong mảng: " + positiveAverage);
                    break;
                }
                case 4: {
                    int k = 0;
                    boolean checkKValue = false;
                    System.out.println("Xuất vị trí các phần tử có giá trị bằng k trong mảng: ");
                    System.out.print("Nhập vào số k: ");
                    k = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        if (arrayNumbers[i] == k) {
                            checkKValue = true;
                            System.out.printf("Phẩn tử có chỉ số %d có giá trị bằng %d\n", i, k);
                        }
                    }
                    if (!checkKValue) System.out.println("Không có phần tử nào bằng " + k + " trong mảng!");
                    break;
                }
                case 5:{
                    System.out.println("Thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = n - 1; j > i ; j--) {
                            if(arrayNumbers[j] > arrayNumbers[j - 1]){
                                int temp = arrayNumbers[j];
                                arrayNumbers[j] = arrayNumbers[j - 1];
                                arrayNumbers[j - 1] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < n; i++)
                        System.out.print(arrayNumbers[i] + " ");
                    System.out.println();
                    break;
                }
                case 6:{
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        if(checkNguyenTo(arrayNumbers[i]))  count++;
                    }
                    System.out.println("Số lượng các số nguyên tố trong mảng: " + count);
                    break;
                }
                case 7:{
                    System.out.println("Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng\n" +
                            "dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần,\n" +
                            "các phần tử còn lại ở giữa mảng theo thứ tự tăng dần: ");
                    // Sắp xếp mảng tăng dần:
                    for (int i = 0; i < n; i++) {
                        for (int j = n - 1; j > i ; j--) {
                            if(arrayNumbers[j] < arrayNumbers[j - 1]){
                                int temp = arrayNumbers[j];
                                arrayNumbers[j] = arrayNumbers[j - 1];
                                arrayNumbers[j - 1] = temp;
                            }
                        }
                    }
                    // Chèn dữ liệu vào mảng tạm
                    int[] tempArray = new int[n];
                    int countTempArray = 0;
                    // Điều kiện phần đầu.
                    for (int i = 0; i < n; i++) {
                        if(arrayNumbers[i] % 2 == 0 && arrayNumbers[i] % 3 == 0){
                            tempArray[countTempArray] = arrayNumbers[i];
                            countTempArray++;
                        }
                    }
                    // Điều kiện phần giữa.
                    for (int i = 0; i < n; i++) {
                        if(arrayNumbers[i] % 3 != 0){
                            tempArray[countTempArray] = arrayNumbers[i];
                            countTempArray++;
                        }
                    }
                    // Điều kiện phần cuối.
                    for (int i = n - 1; i >= 0 ; i--) {
                        if(arrayNumbers[i] % 2 != 0 && arrayNumbers[i] % 3 == 0){
                            tempArray[countTempArray] = arrayNumbers[i];
                            countTempArray++;
                        }
                    }
                    // Chuyển mạng tạm thành mảng chỉnh.
                    for (int i = 0; i < n; i++)
                        arrayNumbers[i] = tempArray[i];
                    for (int i = 0; i < n; i++)
                        System.out.print(arrayNumbers[i] + " ");
                    System.out.println();
                    break;
                }
                case 8:{
                    int m = 0;
                    // Sắp xếp giảm dần.
                    for (int i = 0; i < n; i++) {
                        for (int j = n - 1; j > i ; j--) {
                            if(arrayNumbers[j] > arrayNumbers[j - 1]){
                                int temp = arrayNumbers[j];
                                arrayNumbers[j] = arrayNumbers[j - 1];
                                arrayNumbers[j - 1] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp giảm dần: ");
                    for (int i = 0; i < n; i++)
                        System.out.print(arrayNumbers[i] + " ");
                    System.out.println();
                    // Nhập vào m để chèn.
                    System.out.print("Nhập vào giá trị m: ");
                    m = Integer.parseInt(scanner.nextLine());
                    int mPos = n - 1;
                    for (; mPos >= 0 && arrayNumbers[mPos] < m; mPos--) {
                        arrayNumbers[mPos + 1] = arrayNumbers[mPos];
                    }
                    arrayNumbers[++mPos] = m; n += 1;
                    for (int i = 0; i < n; i++)
                        System.out.print(arrayNumbers[i] + " ");
                    System.out.println();
                    break;
                }
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng lựa chọn giá trị từ 1 - 9.");
            }
        }
    }
}