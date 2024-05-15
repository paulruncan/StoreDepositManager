package DAO;

import Model.Bill;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import Connection.ConnectionFact;

/**
 * Acceses the data from the database
 */
public class BillDAO {
    private final String inserString = "INSERT INTO Bill(customerName,productName,quantity) values(?,?,?)";
    private final String selectAllString = "SELECT * FROM Bill";

    /**
     * Inserts a new entry to the database coresponding to a Bill object
     * @param bill the object that the entry corresponds to
     */
    public void insert( Bill bill ){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = inserString;
        try {
            connection = ConnectionFact.getConnection();
            statement=connection.prepareStatement(query);
            statement.setString(1, bill.customerName());
            statement.setString(2, bill.productName());
            statement.setInt(3,bill.quantity());
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
    }

    /**
     * Creates a list with all the entries from the Bill table
     * @return The list with all the entries from the Bill table
     */
    public List<Bill> findAll(){
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Bill> bills = new ArrayList<>();
        String query = selectAllString;
        try {
            connection = ConnectionFact.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String customerName = resultSet.getString("customerName");
                String productName = resultSet.getString("productName");
                int quantity = resultSet.getInt("quantity");
                System.out.println(customerName);
                System.out.println(productName);
                System.out.println(quantity);
                Bill bill = new Bill(id,customerName,productName,quantity);
                bills.add(bill);
            }
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFact.close(resultSet);
            ConnectionFact.close(statement);
            ConnectionFact.close(connection);
        }
        return null;
    }
}
