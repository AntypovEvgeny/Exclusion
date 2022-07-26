import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};

        System.out.println("Список доступных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " pуб/шт");

        }
        int[] purchases = new int[3];
        int sumProduct = 0;

        while (true) {
            int productNumber; //переменная для номера продукта
            int productCount; //переменная для количества продукта

            System.out.println("Выберите товар и количество или введите `end`");
            String inputString = scanner.nextLine(); // "1 10"
            if (inputString.equals("end")) {
                System.out.println("Ваша корзина:");
                for (int i = 0; i < products.length; i++) {
                    if ((purchases[i] != 0)) {
                        System.out.println(products[i] + " " + purchases[i] +
                                " шт " + prices[i] + " pуб/шт" + " В сумме " +
                                (purchases[i] * prices[i]));
                    }

                }
                System.out.println("Итого " + sumProduct + " руб.");
                break;
            }

            String[] parts = inputString.split(" ");

            if (parts.length != 2) {
                System.out.println("Необходимы данные из двух частей, введенные вами значения: " + inputString);
                continue;
            }

            try {
                productNumber = Integer.parseInt(parts[0]) - 1;
                productCount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Введены символы вместо цифр");
                continue;
            }

            if (productNumber >= products.length || productNumber < 0) {
                System.out.println("Введено некорректное значения наименования товара");
                continue;
            }

            if (productCount <= 0) {
                System.out.println("Введено некорректное количество товара");
                continue;
            }

            purchases[productNumber] = productCount + purchases[productNumber];
            int currentPrice = prices[productNumber];
            sumProduct += Integer.parseInt(parts[1]) * currentPrice;
        }
    }
}