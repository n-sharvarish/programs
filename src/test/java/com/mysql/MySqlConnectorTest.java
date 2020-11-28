package com.mysql;

import com.example.BaseTest;
import org.testng.annotations.Test;

public class MySqlConnectorTest extends BaseTest {

    //@Test
    public void testMySqlConnector() {

        MySqlProperties mySqlProperties = new MySqlProperties();
        mySqlProperties.setHost("localhost");
        mySqlProperties.setPort(3306);
        mySqlProperties.setUserName("root");
        mySqlProperties.setPassword("password");
        mySqlProperties.setDatabaseName("mydb");
        mySqlProperties.setTableName("employee");

        MySqlConnector mySqlConnector = new MySqlConnector(mySqlProperties);
        mySqlConnector.connect();

        System.out.println();
        mySqlConnector.showTables();

        System.out.println();
        mySqlConnector.createTable();

        System.out.println();
        mySqlConnector.showTables();

        System.out.println();
        mySqlConnector.insertIntoTable(1, "Scott Tiger");
        mySqlConnector.insertIntoTable(2, "Scott Tigress");
        mySqlConnector.insertIntoTable(3, "Scott Tiger Cub");

        System.out.println();
        mySqlConnector.selectFromTable();

        System.out.println();
        mySqlConnector.updateTable(4, "Scott Tiger Cub");

        System.out.println();
        mySqlConnector.selectFromTable();

        System.out.println();
        mySqlConnector.deleteFromTable(4);

        System.out.println();
        mySqlConnector.selectFromTable();

        System.out.println();
        mySqlConnector.truncateTable();

        System.out.println();
        mySqlConnector.selectFromTable();

        System.out.println();
        mySqlConnector.dropTable();

        System.out.println();
        mySqlConnector.disconnect();
    }
}
