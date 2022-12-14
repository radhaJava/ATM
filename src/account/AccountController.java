package account;

import Util.PrintHandler;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountController extends PrintHandler {
    private final AccountModel model;
    private final AccountView view;
    Scanner scanner = new Scanner(System.in);

    public AccountController(AccountModel model, AccountView view) {
        this.model = model;
        this.view = view;
    }

    public void requestUserInput() {
        String input = scanner.nextLine();
        try {
            int selectedOption = Integer.parseInt(scanUserInput((input)));
            model.handleOption(selectedOption);
        } catch (NumberFormatException | IndexOutOfBoundsException | InputMismatchException | IOException exception) {
            onInvalidInput();
            requestUserInput();
        }
    }
}

