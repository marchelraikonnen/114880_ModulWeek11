package tugasweek11.marchel.id.ac.umn.Assignment;

import tugasweek11.marchel.id.ac.umn.Assignment.exceptions.AuthenticationException;
import tugasweek11.marchel.id.ac.umn.Assignment.exceptions.ExcessiveFailedLoginException;
import tugasweek11.marchel.id.ac.umn.Assignment.exceptions.InvalidPropertyException;

public class User {

    private String firstName;
    private String lastName;
    private char gender;
    private String address;
    private String username;
    private String password;

    private int failedLoginCount = 0;

    public User(String firstName, String lastName, char gender, String address, String username, String password) {
        try {
            setFirstName(firstName);
            setLastName(lastName);
            setGender(gender);
            setAddress(address);
            setUsername(username);
            setPassword(password);
        } catch (InvalidPropertyException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean login(String username, String password)
            throws ExcessiveFailedLoginException {

        if (failedLoginCount >= 3) {
            throw new ExcessiveFailedLoginException("Akun telah dikunci karena gagal login 3x");
        }

        if (this.username.equals(username) && this.password.equals(password)) {
            failedLoginCount = 0;
            return true;
        }

        failedLoginCount++;
        return false;
    }

    public String greeting() {
        return "Selamat datang, " + firstName + " " + lastName;
    }

    // ========== Setter dengan Validasi ==========
    public void setFirstName(String firstName) throws InvalidPropertyException {
        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidPropertyException("Nama depan tidak boleh kosong");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws InvalidPropertyException {
        if (lastName == null || lastName.isEmpty()) {
            throw new InvalidPropertyException("Nama belakang tidak boleh kosong");
        }
        this.lastName = lastName;
    }

    public void setGender(char gender) throws InvalidPropertyException {
        if (gender != 'L' && gender != 'P') {
            throw new InvalidPropertyException("Gender harus 'L' atau 'P'");
        }
        this.gender = gender;
    }

    public void setAddress(String address) throws InvalidPropertyException {
        if (address == null || address.isEmpty()) {
            throw new InvalidPropertyException("Alamat tidak boleh kosong");
        }
        this.address = address;
    }

    public void setUsername(String username) throws InvalidPropertyException {
        if (username.length() <= 8) {
            throw new InvalidPropertyException("Username harus lebih dari 8 karakter");
        }
        this.username = username;
    }

    public void setPassword(String password) throws InvalidPropertyException {
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);

        if (password.length() < 6 || password.length() > 16 || !hasUpper || !hasDigit) {
            throw new InvalidPropertyException(
                    "Password harus mengandung huruf besar, angka, min 6 karakter, max 16"
            );
        }
        this.password = password;
    }
}

