import java.util.Scanner;

public class Exam02 {
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
        int n = 0, m = 0, choice = 0; // Hàng và cột của ma trận.
        do {
            System.out.print("Nhập vào số hàng của ma trận: ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n <= 0);
        do {
            System.out.print("Nhập vào số cột của ma trận: ");
            m = Integer.parseInt(scanner.nextLine());
        } while (m <= 0);
        int[][] matrixNumbers = new int[n][m];
        while (true) {
            System.out.println("************************MENU**************************\n" +
                    "1. Nhập giá trị các phần tử của mảng.\n" +
                    "2. In giá trị các phần tử trong mảng theo ma trận.\n" +
                    "3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng.\n" +
                    "4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và\n" +
                    "đường chéo phụ.\n" +
                    "5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của\n" +
                    "mảng.\n" +
                    "6. In ra các phần tử là số nguyên tố trong mảng.\n" +
                    "7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính\n" +
                    "của mảng giảm dần.\n" +
                    "8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng,\n" +
                    "thực hiện chèn vào mảng 2 chiều.\n" +
                    "9. Thoát.\n" +
                    "Lựa chọn của bạn là: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: {
                    System.out.println("Nhập vào các giá trị phần tử của mảng: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("matrixNumbers[%d][%d]: ", i, j);
                            matrixNumbers[i][j] = Integer.parseInt(scanner.nextLine());
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Xuất các giá trị phần tử của mảng theo ma trận: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++)
                            System.out.print(matrixNumbers[i][j] + " ");
                        System.out.println();
                    }
                    break;
                }
                case 3: {
                    int countElements = 0;
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < m; j++)
                            countElements += (matrixNumbers[i][j] % 2 == 0 && matrixNumbers[i][j] % 3 == 0) ? 1 : 0;
                    System.out.println("Số lượng các phần tử chia hết cho 2 và 3 trong mảng: " + countElements);
                    break;
                }
                case 4: {
                    int sumOutline = 0, sumMainTrace = 0, sumViceTrace = 0;
                    System.out.println("Xuất các phần tử trên đường biên của mảng: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++)
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1){
                                System.out.print(matrixNumbers[i][j] + " ");
                                sumOutline += matrixNumbers[i][j];
                            }
                            else System.out.print("  ");
                        System.out.println();
                    }
                    System.out.println("Tổng các phần tử trên đường biên mảng: " + sumOutline);
                    if(n == m){
                        System.out.println("Xuất các phần tử trên đường chéo chính của mảng: ");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++)
                                if (i == j){
                                    System.out.print(matrixNumbers[i][j] + " ");
                                    sumMainTrace += matrixNumbers[i][j];
                                }
                                else System.out.print("  ");
                            System.out.println();
                        }
                        System.out.println("Tổng các phần tử trên đường chéo chính mảng: " + sumMainTrace);
                        System.out.println("Xuất các phần tử trên đường chéo phụ của mảng: ");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++)
                                if (i + j == n - 1){
                                    System.out.print(matrixNumbers[i][j] + " ");
                                    sumViceTrace += matrixNumbers[i][j];
                                }
                                else System.out.print("  ");
                            System.out.println();
                        }
                        System.out.println("Tổng các phần tử trên đường chéo phụ mảng: " + sumViceTrace);
                    }else System.out.println("Ma trận không có đường chéo chính và phụ!");
                    break;
                }
                case 5:{
                    System.out.println("Sắp xếp lựa chọn các phần tử tăng dần theo cột của mảng: ");
                    for (int k = 0; k < m; k++) {
                        for (int i = 0; i < n - 1; i++) {
                            int minInd = i;
                            for (int j = i + 1; j < n; j++)
                                if (matrixNumbers[minInd][k] > matrixNumbers[j][k])
                                    minInd = j;
                            int temp = matrixNumbers[i][k];
                            matrixNumbers[i][k] = matrixNumbers[minInd][k];
                            matrixNumbers[minInd][k] = temp;
                        }
                    }
                    // Xuất mảng sau khi đã sắp xếp.
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++)
                            System.out.print(matrixNumbers[i][j] + " ");
                        System.out.println();
                    }
                    break;
                }
                case 6:{
                    System.out.println("Xuất ra các số nguyên tố có trong mảng: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(checkNguyenTo(matrixNumbers[i][j]))
                                System.out.print(matrixNumbers[i][j] + " ");
                        }
                    }
                    System.out.println();
                    break;
                }
                case 7:{
                    if(n == m){
                        for (int i = 1; i < n; ++i) {
                            int key = matrixNumbers[i][i];
                            int j = i - 1;
                            while (j >= 0 && matrixNumbers[j][j] > key) {
                                matrixNumbers[j + 1][j + 1] = matrixNumbers[j][j];
                                j = j - 1;
                            }
                            matrixNumbers[j + 1][j + 1] = key;
                        }
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++)
                                System.out.print(matrixNumbers[i][j] + " ");
                            System.out.println();
                        }
                    }else System.out.println("Ma trận không có đường chéo chính!");
                    break;
                }
                case 8:{
                    System.out.printf("Nhập mảng 1 chiều gồm m phần tử (%d phần tử):\n", m);
                    int[] tempArray = new int[m];
                    int indexInsert;
                    for (int i = 0; i < m; i++) {
                        System.out.printf("tempArray[%d]: ", i);
                        tempArray[i] = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.print("Nhập vào chỉ số muốn chèn của mảng lớn: ");
                    indexInsert = Integer.parseInt(scanner.nextLine());
                    int[][] tempMatrix = new int[n + 1][m];
                    for (int i = 0; i < n + 1; i++) {
                        if(i < indexInsert)
                            System.arraycopy(matrixNumbers[i], 0, tempMatrix[i], 0, m);
                        else if(i == indexInsert)
                            System.arraycopy(tempArray, 0, tempMatrix[i], 0, m);
                        else
                            System.arraycopy(matrixNumbers[i - 1], 0, tempMatrix[i], 0, m);
                    }
                    matrixNumbers = tempMatrix;
                    n += 1;
                    System.out.println("Kết quả sau khi chèn mảng: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++)
                            System.out.print(matrixNumbers[i][j] + " ");
                        System.out.println();
                    }
                    break;
                }
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập giá trị từ 1 - 9.");
            }
        }
    }
}
