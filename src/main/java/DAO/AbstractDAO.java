package DAO;

import Connection.ConnectionFact;

import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import connection.ConnectionFactory;

/**
 * Generic class used for accesing the database and modifying entries
 * @param <T> The generic parameter that will be used for the other DAOs
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * creates a query for Selecting entries from the database based on a field
     * @param field the field that entries are select based on
     * @return the string used for selecting entries from the database
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creates a query for adding entries to the database
     * @return the query used for adding entries to the database
     */
    public String createAddQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append("(");
        for(Field field : type.getDeclaredFields())
            if(field.getName()!="id")
                sb.append(field.getName()).append(",");
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        sb.append(" values(");
        sb.append("?,".repeat(type.getDeclaredFields().length-1));
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        System.out.println(sb.toString());
        return sb.toString();
        //return null;
    }

    /**
     * Creates a query for deleting entries from the database
     * @param field deleting is based on this field
     * @return the query for deleting entries
     */
    public String createRemoveQuery(String field){
        StringBuilder sb =new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creates a query for updating entries from the database
     * @param field the entry that should be modified is selected by this field
     * @return the query for updating entries
     */
    public String createUpdateQuery(String field){
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" set ");
        for(Field field1: type.getDeclaredFields())
            if(field1.getName()!="id")
                sb.append(field1.getName()).append("=?,");
        sb.deleteCharAt(sb.length()-1);
        sb.append(" WHERE " + field + "=?");
        return sb.toString();
    }
    /**
     *
     * @return a string used for getting all entries from a database
     */
    private String createAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("* ");
        sb.append("from ");
        sb.append(type.getSimpleName());
        //sb.append(" WHERE )
        return sb.toString();
    }


    /**
     * Finds all the entries from a database
     * @return a LIST with all the entries
     */
    public List<T> findAll() {
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createAllQuery();
        try {
            connection = ConnectionFact.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFact.close(resultSet);
            ConnectionFact.close(statement);
            ConnectionFact.close(connection);
        }
        return null;
    }


    /**
     *
     * @param id the value based on which the selection is made
     * @return an entry from the database that respects the id condition
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFact.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFact.close(resultSet);
            ConnectionFact.close(statement);
            ConnectionFact.close(connection);
        }
        return null;
    }

    /**
     * Inserts the entry to the database
     * @param t the instance of the object that should create an entry for the database
     * @return the instance t
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createAddQuery();
        try {
            connection = ConnectionFact.getConnection();
            statement=connection.prepareStatement(query);
            int i=1;
            for( Field field : t.getClass().getDeclaredFields() )
            {
                field.setAccessible(true);
                if(field.getName()!="id"){
                    statement.setObject(i++,field.get(t));
                }
                System.out.println(field.getName());
                System.out.println(field.get(t));
            }
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
        return t;
    }

    /**
     * Deletes an entry based on the id
     * @param id the value of the id that should be deleted
     */
    public void deleteById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createRemoveQuery("id");
        try {
            connection = ConnectionFact.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFact.close(statement);
            ConnectionFact.close(connection);
        }
    }

    /**
     * Updates the entry of the database corresponding to the instance of t
     * @param t the instance of the object that should be changed in the database
     * @return the instance t
     */
    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createUpdateQuery("id");
        try {
            connection = ConnectionFact.getConnection();
            statement=connection.prepareStatement(query);
            int i=1;
            for( Field field : t.getClass().getDeclaredFields() )
            {
                field.setAccessible(true);
                if(field.getName()!="id")
                    statement.setObject(i++,field.get(t));
                System.out.println(field.getName());
                System.out.println(field.get(t));
            }
            for( Field field : t.getClass().getDeclaredFields() )
            {
                field.setAccessible(true);
                if(field.getName()=="id")
                    statement.setObject(i++,field.get(t));
                System.out.println(field.getName());
                System.out.println(field.get(t));
            }
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }

        return t;
    }

    /**
     * Gets the names of the fields of the Class
     * @return the names of the fields
     */
    public String[] getFields(){
        String[] string = new String[type.getDeclaredFields().length];
        int iter =0;
        for(Field field : type.getDeclaredFields())
        {
            String fieldName =field.getName();
            string[iter++] = fieldName;
            System.out.println(fieldName);
        }
        return string;
    }

    /**
     * Creates a list with the objects that are taken from the table entries
     * @param resultSet based on this resultSet the objects are built
     * @return A list with the objects created from the table entries
     */
    public List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }
    public DefaultTableModel populateTable( List<T> objects) {
        try {
            Field field;
            //DefaultTableModel model = new DefaultTableModel();
            String[] columnNames = this.getFields();
            DefaultTableModel model = new DefaultTableModel(null, columnNames);
            String[] object = new String[this.getFields().length];
            for( T t : objects ) {
                for( int i = 0; i < this.getFields().length; i++ ) {
                    field = t.getClass().getDeclaredField(columnNames[i]);
                    field.setAccessible(true);
                    object[i] = field.get(t).toString();
                }
                model.addRow(object);
            }

            return model;
        } catch (Exception e){
            e.printStackTrace();
    }
        return null;
    }
}
