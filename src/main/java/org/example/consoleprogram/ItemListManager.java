package org.example.consoleprogram;

import java.util.ArrayList;
import java.util.List;

public class ItemListManager<T>{
    private ArrayList<Item> itemList;
    private int pageSize;
    private int currentPage;
    private int totalItems;


    public ItemListManager() {
        this.itemList = new ArrayList<>();
        this.pageSize = 10;
        this.currentPage = 1;
        this.totalItems = 4;
    }


    public void addItem(T itemName) {

        itemList.add(new Item(itemName));
        System.out.println("Item added: " + itemName);

    }



    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        System.out.println("Page size set to: " + pageSize);
    }


    public void displayPaginatedList() {

        /*int totalPages = (int) Math.ceil((double) itemList.size() / pageSize);

        if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, itemList.size());

        System.out.println("\nPágina " + currentPage + " de " + totalPages); // Cambiado de pageSize a totalPages
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println((i + 1) + ". " + itemList.get(i).getData());
        }*/
        int totalItems = itemList.size();

        if (totalItems == 0) {
            System.out.println("The list is empty.");
            return;
        }

        int startIndex = currentPage * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalItems);
        Item<T> item = itemList.get(currentPage);
        for (int i = 0; i < endIndex; i++) {
            //Item<T> item = itemList.get(currentPage);
            System.out.println((i + 1) + ". " + item.getData());
        }

        System.out.println("Page " + (currentPage + 1) + "/" + pageSize);
    }
        //int totalPages = (int) Math.ceil((double) itemList.size() / pageSize);
        // Check if current page is within valid range
        /*int totalPages = currentPage + 1;
        if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, itemList.size());

        System.out.println("\nPage " + currentPage + " of " + totalPages);
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }*/
    //}


    /*public void displayPaginatedList() {
        int startIndex = (currentPage) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, itemList.size());

        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.println((i + 1) + ". " + item.getData());
        }

        System.out.println("Page " + currentPage + "/" + pageSize);
    }*/



    public int getTotalPages() {
        return (int) Math.ceil((double) itemList.size() / pageSize);
    }



    public void handlePaginationCommand(String command) {
        switch (command.toLowerCase()) {
            case "first":
                currentPage = 1;
                break;
            case "last":
                currentPage = pageSize;
                break;
            case "next":
                //currentPage = Math.min(currentPage + 1, pageSize);
                currentPage++;
                break;
            case "prev":
                //currentPage = Math.max(currentPage - 1, 1);
                currentPage--;
                break;
            case "exit":
                System.out.println("Exiting the program.");
                System.exit(0);
            default:
                if (command.startsWith("goto")) {
                    try {
                        int page = Integer.parseInt(command.substring(5).trim());
                        currentPage = Math.max(1, Math.min(page, getTotalPages()));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid page number. Please enter a valid number.");
                    }
                } else {
                    System.out.println("Invalid command. Please try again.");
                }
        }
    }
}
