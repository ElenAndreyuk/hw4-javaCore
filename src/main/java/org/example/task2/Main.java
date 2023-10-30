package org.example.task2;

import org.example.task2.exceptions.AmountException;
import org.example.task2.exceptions.CustomerException;
import org.example.task2.exceptions.ProductException;

//1 - написать классы покупатель, товар и заказ;
//2 - создать массив покупателей, массив товаров и массив заказов;
//3 - создать статический метод “совершить покупку” со строковыми параметрами,
// соответствующими полям объекта заказа. Метод должен вернуть объект заказа
//4 - Если в метод передан несуществующий покупатель, товар или отрицательное количество,
// метод должен выбросить соответствующее исключение;
//5 - Вызвать метод совершения покупки несколько раз таким образом, чтобы
// заполнить массив покупок возвращаемыми значениями. Обработать исключения.
//6 - Вывести в консоль итоговое количество совершённых покупок после выполнения приложения.
public class Main {
    static Customer[] customers;
    static Product[] products;

    static Order[] orders;

    public static void main(String[] args) {
        customers = new Customer[]{new Customer("Ivanov Ivan", 33, "+333333333"),
                new Customer("Dart Veider", 77, "+666666666")};

        Product tea = new Product("tea", 30);
        Product water = new Product("water", 100);
        Product bread = new Product("bread", 400);
        Product apple = new Product("apple", 120);
        Product ice = new Product("ice", 600);

        products = new Product[]{tea, water, bread, apple, ice};
        orders = new Order[]{makePurchase("+333333333", "tea", 1),
        makePurchase("+666666666", "apple", 3),
        makePurchase("+11166666", "apple", 3),
        };
        System.out.println(orders.length);


    }
    public static Order makePurchase(String phone, String title, int amount) {
        Customer customer = customerChecker(phone);
        Product product = productChecker(title);
        int quantity = amountChecker(amount);

        return new Order(customer, product, quantity);
    }
    public static Customer customerChecker(String phone)throws CustomerException {
        Customer customer = null;
        for (Customer cust : customers) {
            if (cust.getPhone().equals(phone)) {
                customer = cust;
            }
        }
        if (customer == null) {
            throw new CustomerException("Phone number not found");
        }
        return customer;
    }
    public static Product productChecker(String title) throws ProductException{
        Product product = null;
        for (Product prod : products) {
            if (prod.getTitle().equals(title)) {
                product = prod;
            }
        }
        if (product == null) {
            throw new ProductException("This title not found");
        }
        return product;
    }
    public static int amountChecker(int amount) throws AmountException{
        if (amount < 1) {
            throw new AmountException("Amount is not correct");
        }
        return amount;
    }
}
