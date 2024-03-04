package org.example.pagination;

import java.util.Scanner;

public class MainPagination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ICommandExecute commandExecute = null;
        IPagination<String> pagination = null;
        while(true) {
            String cmd = scanner.nextLine();
            commandExecute.execute(cmd, pagination);
        }
    }
}
