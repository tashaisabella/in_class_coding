package com.jac.in_class_coding;

public class MyController {
    private ConsoleView view;
    private CustomerDatabase customerDatabase;

    // Constructor
    public MyController() {
    }

    /** Method to configure this controller */
    public void configure(ConsoleView view, CustomerDatabase customerDatabase) {
        this.view = view;
        this.customerDatabase = customerDatabase;
    }

    /** return false if exit */
    public boolean getAndDoNextAction() {
        UserChoice choice = view.requestAction();

        switch (choice) {
            case CREATE -> { doCreate(); return true; }
            case GETBYID -> { doGetById(); return true;}
            case EXIT -> { return false; }
            default -> {return true;}
        }
    }

    private void doGetById() {
        int id = view.getIdToRetrieve();

        Customer customer = customerDatabase.findCustomerById(id);

        view.showCustomer(customer);
    }

    public void doCreate() {
        Customer myCustomer = view.getCustomer();

        if (myCustomer != null) {
            customerDatabase.save(myCustomer);
        }
    }
}
