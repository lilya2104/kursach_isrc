package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, User> users = new HashMap<>();

        User u1 = new User("vasya@mail.ru", "vasya", "vpassword");
        u1.addCard("1234123412341234");
        users.put("1231231234", u1);

        User u2 = new User("ira@mail.ru", "ira", "irapassword");
        u2.addCard("5678-5678-5678-5678");
        u2.addCard("5555555555555555");
        u2.addCard("6666 6666 6666 6666");
        users.put("5556667788", u2);


        System.out.print("Введите номер телефона: ");
        String number = numberRedact(scan.nextLine());

        if (!users.containsKey(number)) {
            System.out.println("Этот номер не зарегистрирован:(( Пройдите регистрацию");
            System.out.print("Введите имя: ");
            String name = scan.nextLine();
            System.out.print("Введите адрес электронной почты: ");
            String email = scan.nextLine();
            System.out.print("Придумайте пароль: ");
            String password = scan.nextLine();
            User u3 = new User(email, name, password);
            users.put(number, u3);
            System.out.println("Вы зарегистрированы:))");
        }
        else {
            System.out.print("Код из сообщения: ");
            if (!numSmsValid(scan.nextLine())) System.out.println("Код неверный!!");
            System.out.print("Пароль: ");
            String psswrd = scan.nextLine();
            if (!psswrd.equals(users.get(number).getPassword())) System.out.println("Пароль неверный!!");
        }

        User current_user = users.get(number);
        System.out.println(String.format("Ваш аккаунт: %s, %s", current_user.getName(), current_user.getEmail()));
        boolean flag = true;
        while (flag) {
            System.out.println("Дополнительные дейсвия:" +
                    " 1 - показать привязанные карты," +
                    " 2 - добавить карту," +
                    " 3 - показать пароль");
            System.out.print("Введите действие: ");
            String action = scan.nextLine();
            switch (action) {
                case "1":
                    for (String card : current_user.getCards()) System.out.println(card);
                    break;
                case "2":
                    System.out.print("Введите номер карты, которую хотите добавить: ");
                    if (current_user.addCard(scan.nextLine()))
                        System.out.println("Карта добавлена");
                    else System.out.println("Нельзя привязать больше трёх карт к профилю!!");
                    break;
                case "3":
                    System.out.println(current_user.getPassword());
                default:
                    System.out.println("Такой команды не существует!!");
                    flag = false;
            }
        }
    }

    public static boolean numberValidation(String number) {
        if (number.matches("^(\\+?7|8)\\s?(\\(?\\d{3}\\)?|\\d{3})\\s?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}$"))
            return true;
        return false;
    }
    public static String numberRedact(String number) {
        if (numberValidation(number)) {
            number = number.replaceAll("[\\s()\\-]", "");

            if (number.length() == 12) number = number.substring(2);
            if (number.length() == 11) number = number.substring(1);
            return number;
        }
        return null;
    }
    public static boolean numSmsValid(String numSMS) {
        if (numSMS.equals("0987")) return true;
        return false;
    }
}
