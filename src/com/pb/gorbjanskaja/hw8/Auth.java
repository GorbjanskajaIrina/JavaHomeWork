package com.pb.gorbjanskaja.hw8;

import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;

    public Auth()   {
    }

    /*public Auth(String login, String password) {
        this.login = login;
        this.password = password;
    }*/
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginExeption,
            WrongPasswordException
    {
            if (Pattern.matches("[a-zA-Z0-9]{5,20}", login)) {
               login = this.login;
               // System.out.println("Логин Ок");
            } else {
                throw new WrongLoginExeption("Логин не соответствует требованиям!");
            }
            if ((Pattern.matches("[a-zA-Z0-9_]{5,50}", password)) ) {

                //System.out.println("Пароль Ок");
            } else {
                throw new WrongPasswordException("Пароль не соответствует требованиям!");
            }
            if (password.equals(confirmPassword)) {
                password = this.password;
                System.out.println("Регистрация прошла успешно");
            } else {
                throw new WrongPasswordException("Пароли не совпадают!");

            }

        }
    public void signIn(String login1, String password1) throws WrongLoginExeption
                {

        if (login1.equals(login) && password1.equals(password))
                {
            System.out.println("Поздравляем, Вы зашли! ");
        } else {
            throw new WrongLoginExeption("Неправильно введен логин или пароль");
        }

    }

}
