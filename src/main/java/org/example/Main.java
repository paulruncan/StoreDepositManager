package org.example;

import DAO.BillDAO;
import DAO.CustomerDAO;
import Model.Bill;
import Model.Customer;
import Views.FirstPage;
import Views.MainPage;

import javax.swing.*;

/**
 * This is main page
 */
public class Main {
    public static void main( String[] args ) {
        JFrame frame = new MainPage("BLL");
        frame.setVisible(true);
    }
}