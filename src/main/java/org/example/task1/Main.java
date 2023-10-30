package org.example.task1;

import org.example.task1.exceptions.WrongLoginException;
import org.example.task1.exceptions.WrongPasswordException;

import java.util.Scanner;

//1 - Создать статический метод который принимает на вход три параметра:
// login, password и confirmPassword.
//        2 - Длина login должна быть меньше 20 символов. Если login не
//        соответствует этим требованиям, необходимо выбросить WrongLoginException.
//        3 -Длина password должна быть меньше 20 символов.
//        Также password и confirmPassword должны быть равны. Если password
//        не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//        4 - WrongPasswordException и WrongLoginException -
//        пользовательские классы исключения с двумя конструкторами –
//        один по умолчанию, второй принимает сообщение исключения и передает
//        его в конструктор класса Exception.
//        5 - В основном классе программы необходимо по-разному обработать исключения.
//        6 - Метод возвращает true, если значения верны или false в другом случае.
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Login: ");
            String login = scanner.next();
            System.out.println("Password: ");
            String password = scanner.next();
            System.out.println("Confirm password: ");
            String confirmPassword = scanner.next();
            System.out.println(loginPasswordCheck(login, password, confirmPassword));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    public static boolean loginPasswordCheck(String login, String password, String confirmPassword) {
        try {
            return checker(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean checker(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean result = true;
        if (login.length() > 20){
            throw new WrongLoginException("Login length is more than 20 symbols");
        }
        if (password.length() > 20 ){
            throw new WrongPasswordException("Password length is more than 20 symbols");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and confirm password are not equal ");
        }
        return result;
    }
}
