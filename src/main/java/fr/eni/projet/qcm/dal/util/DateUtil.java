package fr.eni.projet.qcm.dal.util;

public final class DateUtil {

    public static java.util.Date JDBCDateToUtilDate(java.sql.Date date) {
    	return new java.util.Date(date.getTime());
    }
    public static java.sql.Date UtilDateToJDBCDate(java.util.Date date) {
    	return new java.sql.Date(date.getTime());
    }

}
