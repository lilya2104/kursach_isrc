package org.example;

import java.util.ArrayList;

public class User {
    private String email;
    private String name;
    private String password;
    private ArrayList<String> cards = new ArrayList<>();

    public User(String email, String name, String password) {
        this.setEmail(email);
        this.setName(name);
        this.setPassword(password);
    }
    public User() {}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (emailValidation(email)) this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (!name.isEmpty()) this.name = name;
        else throw new IllegalArgumentException("The name is incorrect!!");
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if (password.length() > 4) this.password = password;
        else throw new IllegalArgumentException("The password is incorrect!!");
    }

    public ArrayList<String> getCards() {
        return cards;
    }
    public void setCards(ArrayList<String> cards) {
        this.cards = cards;
    }


//проверяет корректность адреса электронной почты
    public boolean emailValidation(String email) {
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) return true;
        throw new IllegalArgumentException("The email address was entered incorrectly!!");
    }
//проверяет корректность номера карты
    public boolean cardValidation(String card) {
        if (card.matches("^(\\d{4}[ -]?){3}\\d{4}$|^\\d{16}$")) return true;
        throw new IllegalArgumentException("The card number was entered incorrectly!!");
    }
//привязывает новую карту к аккаунту (максимальное количество привязанных карт - 3)
    public boolean addCard (String card) {
        if (cardValidation(card) && cards.size() < 3) {
            cards.add(card);
            return true;
        }
        return false;
    }
}
