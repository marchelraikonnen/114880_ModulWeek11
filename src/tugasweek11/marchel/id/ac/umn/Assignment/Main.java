package tugasweek11.marchel.id.ac.umn.Assignment;

import java.util.ArrayList;
import java.util.Scanner;
import tugasweek11.marchel.id.ac.umn.Assignment.exceptions.AuthenticationException;
import tugasweek11.marchel.id.ac.umn.Assignment.exceptions.ExcessiveFailedLoginException;

public class Main {

    private static ArrayList<User> listOfUser = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void initialize() {
        User admin = new User(
                "John",
                "Doe",
                'L',
                "Jl. Merpati No. 1 RT 1 RW 1, Banten",
                "adminuser",
                "Admin123"
        );
        listOfUser.add(admin);
    }

    public static void handleLogin() {
        System.out.print("Username : ");
        String username = input.nextLine();
        System.out.print("Password : ");
        String password = input.nextLine();

        boolean success = false;

        for (User u : listOfUser) {
            try {
                if (u.login(username, password)) {
                    System.out.println(u.greeting());
                    success = true;
                    break;
                }
            } catch (ExcessiveFailedLoginException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        if (!success) {
            try {
                throw new AuthenticationException("Username / password salah");
            } catch (AuthenticationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void handleSignUp() {
        System.out.print("Nama Depan : ");
        String first = input.nextLine();
        System.out.print("Nama Belakang : ");
        String last = input.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        char gender = input.nextLine().charAt(0);
        System.out.print("Alamat : ");
        String address = input.nextLine();

        String username;
        while (true) {
            System.out.print("Username : ");
            username = input.nextLine();
            if (username.length() <= 8) {
                System.out.println("Username harus lebih dari 8 karakter");
            } else break;
        }

        String password;
        while (true) {
            System.out.print("Password : ");
            password = input.nextLine();

            boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
            boolean hasDigit = password.chars().anyMatch(Character::isDigit);

            if (password.length() < 6 || password.length() > 16 || !hasUpper || !hasDigit) {
                System.out.println("Password harus mengandung huruf besar, angka, minimum 6 karakter dan maksimum 16 karakter");
            } else break;
        }

        User newUser = new User(first, last, gender, address, username, password);
        listOfUser.add(newUser);

        System.out.println("User telah berhasil didaftarkan");
    }

    public static void main(String[] args) {
        initialize();

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Sign Up");
            System.out.print("Pilihan : ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    handleLogin();
                    break;
                case "2":
                    handleSignUp();
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}
