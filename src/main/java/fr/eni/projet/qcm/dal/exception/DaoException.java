package fr.eni.projet.qcm.dal.exception;

import java.sql.SQLException;

/**
 * Exception class for DAO Methods.
 * 
 * @author externe
 *
 */
public class DaoException extends Exception {

    private static final long serialVersionUID = 5373358650308469523L;

    public DaoException(SQLException e) {
        super(e);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
