package com.mysql;

import java.sql.*;

public class MySqlConnector {

    private final MySqlProperties mySqlProperties;

    private Connection connection;

    public MySqlConnector(MySqlProperties mySqlProperties) {
        this.mySqlProperties = mySqlProperties;
    }

    public void connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", this.mySqlProperties.getHost(),
                    this.mySqlProperties.getPort(), this.mySqlProperties.getDatabaseName()),
                    this.mySqlProperties.getUserName(), this.mySqlProperties.getPassword());

            System.out.println("Connected to the database!");

        } catch (Exception e) {
            System.out.println("Exception Occurred while connecting to MySQL " + e);
        }
    }

    public void disconnect() {

        try {
            if (this.connection != null) {
                this.connection.close();
            }
            System.out.println("Connection closed ");
        } catch (Exception e) {
            System.out.println("Exception Occurred while disconnecting MySQL " + e);
        }
    }

    public void showTables() {

        try {
            DatabaseMetaData metaData = this.connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (resultSet.next()) {
                System.out.println(resultSet.getString("TABLE_NAME"));
            }
        } catch (Exception e) {
            System.out.println("Exception Occurred while Showing tables in MySQL " + e);
        }
    }

    public void createTable() {

        String sql = String.format("CREATE TABLE %s (id INT NOT NULL, name VARCHAR(45) NOT NULL, PRIMARY KEY (id))", mySqlProperties.getTableName());
        Statement statement = null;

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (Exception e) {
            System.out.println("Exception Occurred while creating table in MySQL " + e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {

            }
        }
    }

    public void dropTable() {

        String sql = String.format("DROP TABLE %s", mySqlProperties.getTableName());
        Statement statement = null;

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table dropped successfully");
        } catch (Exception e) {
            System.out.println("Exception Occurred while dropping table in MySQL " + e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {

            }
        }
    }

    public void selectFromTable() {

        String sql = String.format("SELECT * FROM %s", this.mySqlProperties.getTableName());
        PreparedStatement statement = null;

        try {
            statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id") + " name: " + resultSet.getString("name"));
            }
            System.out.println("Table selected successfully");
        } catch (Exception e) {
            System.out.println("Exception Occurred while selecting rows from table in MySQL " + e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {

            }
        }
    }

    public void insertIntoTable(int id, String name) {

        String sql = String.format("INSERT INTO %s VALUES (?, ?)", this.mySqlProperties.getTableName());
        PreparedStatement statement = null;

        try {
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);

            statement.executeUpdate();
            System.out.println("Row inserted into table successfully");
        } catch (Exception e) {
            System.out.println("Exception Occurred while inserting row in table in MySQL " + e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {

            }
        }
    }


    public void updateTable(int id, String name) {

        String sql = String.format("UPDATE %s SET id=? WHERE name=?", this.mySqlProperties.getTableName());
        PreparedStatement statement = null;

        try {
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);

            statement.executeUpdate();
            System.out.println("Row updated in table successfully");
        } catch (Exception e) {
            System.out.println("Exception Occurred while updating row in table in MySQL " + e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {

            }
        }
    }

    public void deleteFromTable(int id) {

        String sql = String.format("DELETE FROM %s WHERE id=?", this.mySqlProperties.getTableName());
        PreparedStatement statement = null;

        try {
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println("Row deleted from table successfully");
        } catch (Exception e) {
            System.out.println("Exception Occurred while deleting row from table in MySQL " + e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {

            }
        }
    }

    public void truncateTable() {

        String sql = String.format("TRUNCATE TABLE %s", this.mySqlProperties.getTableName());
        PreparedStatement statement = null;

        try {
            statement = this.connection.prepareStatement(sql);
            statement.executeUpdate(sql);
            System.out.println("Table truncated successfully");
        } catch (Exception e) {
            System.out.println("Exception Occurred while truncating table in MySQL " + e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {

            }
        }
    }
}
