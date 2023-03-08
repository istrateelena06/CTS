package ro.ase.acs.sql.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IntCreatorTable {
    void createTable(Connection connection) throws SQLException;
}
