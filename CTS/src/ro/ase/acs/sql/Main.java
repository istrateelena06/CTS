package ro.ase.acs.sql;

import ro.ase.acs.sql.classes.CreatorTable;
import ro.ase.acs.sql.classes.InserterData;
import ro.ase.acs.sql.classes.ReaderData;
import ro.ase.acs.sql.interfaces.IntCreatorTable;
import ro.ase.acs.sql.interfaces.IntInserterData;
import ro.ase.acs.sql.interfaces.IntReaderData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String  CONEXIUNE = "jdbc:sqlite:database.db";
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(CONEXIUNE);
            connection.setAutoCommit(false);

            IntCreatorTable tableCreator = new CreatorTable();
            tableCreator.createTable(connection);

            IntInserterData dataInserter = new InserterData();
            dataInserter.insertData(connection);

            IntReaderData dataReader = new ReaderData();
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}