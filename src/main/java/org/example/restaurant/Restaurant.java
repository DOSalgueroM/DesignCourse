package org.example.restaurant;

import java.util.*;

interface MenuItem {
    String getName();
    double getPrice();
}

class Dish implements MenuItem {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Beverage implements MenuItem {
    private String name;
    private double price;

    public Beverage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Dessert implements MenuItem {
    private String name;
    private double price;

    public Dessert(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private MenuItem menuItem;
    private String specialRequests;

    public OrderItem(MenuItem menuItem, String specialRequests) {
        this.menuItem = menuItem;
        this.specialRequests = specialRequests;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }
}

class Table {
    private int tableNumber;
    private List<OrderItem> orderItems;
    private boolean isOccupied;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.orderItems = new ArrayList<>();
        this.isOccupied = false;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}

class Restaurant {
    private List<MenuItem> menu;
    private List<Table> tables;

    public Restaurant() {
        this.menu = new ArrayList<>();
        this.tables = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public List<Table> getTables() {
        return tables;
    }

    public Table findTable(int tableNumber) {
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }
        return null;
    }
}

class OrderManagementSystem {
    private Restaurant restaurant;

    public OrderManagementSystem(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void displayMenu() {
        System.out.println("Menu:");
        List<MenuItem> menu = restaurant.getMenu();
        for (MenuItem menuItem : menu) {
            System.out.println(menuItem.getName() + " - $" + menuItem.getPrice());
        }
    }

    public void takeOrder(int tableNumber, List<OrderItem> orderItems) {
        Table table = restaurant.findTable(tableNumber);
        if (table != null) {
            table.addOrderItem(orderItems.get(tableNumber));
            table.setOccupied(true);
            System.out.println("Order taken successfully.");
        } else {
            System.out.println("Table not found.");
        }
    }

    public void markOrderAsCompleted(int tableNumber) {
        Table table = restaurant.findTable(tableNumber);
        if (table != null) {
            table.setOccupied(false);
            System.out.println("Order marked as completed.");
        } else {
            System.out.println("Table not found.");
        }
    }

    public void generateInvoice(int tableNumber) {
        Table table = restaurant.findTable(tableNumber);
        if (table != null) {
            List<OrderItem> orderItems = table.getOrderItems();
            double totalCost = 0.0;
            System.out.println("Invoice for Table " + table.getTableNumber() + ":");
            for (OrderItem orderItem : orderItems) {
                MenuItem menuItem = orderItem.getMenuItem();
                String specialRequests = orderItem.getSpecialRequests();
                System.out.println(menuItem.getName() + " - $" + menuItem.getPrice());
                System.out.println("Special Requests: " + specialRequests);
                totalCost += menuItem.getPrice();
            }
            System.out.println("Total Cost: $" + totalCost);
        } else {
            System.out.println("Table not found.");
        }
    }
        public static void main(String[] args) {
            // Create a restaurant
            Restaurant restaurant = new Restaurant();

            // Create menu items
            MenuItem dish1 = new Dish("Pasta", 12.99);
            MenuItem dish2 = new Dish("Burger", 9.99);
            MenuItem beverage1 = new Beverage("Coke", 1.99);
            MenuItem dessert1 = new Dessert("Ice Cream", 4.99);

            // Add menu items to the restaurant's menu
            restaurant.addMenuItem(dish1);
            restaurant.addMenuItem(dish2);
            restaurant.addMenuItem(beverage1);
            restaurant.addMenuItem(dessert1);

            // Create tables
            Table table1 = new Table(1);
            Table table2 = new Table(2);

            // Add tables to the restaurant
            restaurant.addTable(table1);
            restaurant.addTable(table2);

            // Create an order management system
            OrderManagementSystem orderManagementSystem = new OrderManagementSystem(restaurant);

            // Display the menu
            orderManagementSystem.displayMenu();

            // Take an order for table 1
            List<OrderItem> orderItems = new ArrayList<>();
            orderItems.add(new OrderItem(dish1, "No onions"));
            orderItems.add(new OrderItem(beverage1, ""));
            orderItems.add(new OrderItem(dessert1, ""));
            orderManagementSystem.takeOrder(1, orderItems);

            // Mark the order for table 1 as completed
            orderManagementSystem.markOrderAsCompleted(1);

            // Generate an invoice for table 1
            orderManagementSystem.generateInvoice(1);
        }

    }