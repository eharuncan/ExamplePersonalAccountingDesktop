package org.example.app.ui;

import java.util.Objects;

import static org.example.app.App.userService;

public class GuestMenu {
    private final Common common;

    public GuestMenu(Common common) {
        this.common = common;
    }

    public void show() {
        System.out.println("\nHoşgeldiniz...");

        loops:
        while (true) {
            common.menuHeader();
            System.out.println("1- Giriş Yap");
            System.out.println("2- Kaydol");
            common.menuFooter();

            String input = common.getInput(null);

            if (Objects.equals(input, "1")) {
                String email;
                String password;

                while (true) {
                    System.out.println("\nEposta adresinizi giriniz:");
                    email = common.getInput(null);

                    System.out.println("\nŞifrenizi giriniz:");
                    password = common.getInput(null);

                    if (userService.login(email, password)) {
                        System.out.println("\nBaşarıyla kullanıcı girişi yapıldı.");
                        common.menuSelector();
                        break loops;
                    } else {
                        System.out.println("\nHata: Sistemde böyle bir kullanıcı bulunmuyor.");
                    }
                }
            } else if (Objects.equals(input, "2")) {

                while (true) {

                    System.out.println("\nAdınızı giriniz:");
                    String name = (common.getInput(null));

                    System.out.println("\nSoyadınızı giriniz:");
                    String surname = (common.getInput(null));

                    System.out.println("\nEposta adresinizi giriniz:");
                    String email = (common.getInput(null));

                    String password = (common.getInput(null));

                    String retypedPassword = (common.getInput(null));

                    if (userService.register(name, surname, email, password, retypedPassword)) {
                        System.out.println("\nKullanıcı kaydı başarıyla gerçekleşti.");
                        common.menuSelector();
                        break loops;
                    } else {
                        System.out.println("\nHata: kullanıcı kaydı oluşturulamadı.");
                    }
                }
            } else if (Objects.equals(input, "ç")) {
                break;
            } else {
                System.out.println("\nHata: Lütfen doğru seçeneği giriniz.");
            }
        }
    }
}
