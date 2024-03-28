import java.util.*;
public class UserLogin {

    private static final String MAIN_PASSWORD = "password";
    private static final int MAX_LOGINP_ATTEMPTS = 3;
    private int loginAttempts = 0;

    public void login(String enterPass) throws LoginException, InvalidPasswordException {
        if (loginAttempts >= MAX_LOGINP_ATTEMPTS - 1) {
            loginAttempts++;
            throw new LoginException("You reached the maximum attempts");
        }

        if (!enterPass.equals(MAIN_PASSWORD)) {
            loginAttempts++;
            throw new InvalidPasswordException("Invalid password. Please try again");
        }

        loginAttempts = 0;
        System.out.println("Login successful!");
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        UserLogin login = new UserLogin();

        for (int i = 0; i < MAX_LOGINP_ATTEMPTS; i++) {
            System.out.print("Enter password: ");
            String password = user.nextLine();

            try {
                login.login(password);
                break;
            } catch (LoginException e) {
                System.out.println(e.getMessage());
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
                }
            }
        }
    }
