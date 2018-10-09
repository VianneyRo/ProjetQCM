package fr.eni.projet.qcm.dal.util;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.projet.qcm.common.exception.TechnicalException;

public class JDBCUtil {

    /**
     * Try Rollback if connection not null. 
     * 
     * @param connection
     */
    public static void safeRollback(Connection connection) {
        if(connection != null) {
            try {
                connection.rollback();
                
            } catch (SQLException e) {
                throw new TechnicalException("ERROR ROllback", e);
            }
        }
    }
}
