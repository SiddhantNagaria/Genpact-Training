package com.JDBCProject;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

public class ActiveEmployeesFilter implements Predicate {

	// Predicate Interface
	// should implement prediction interface
	// defines logic to test each row

	@Override
	public boolean evaluate(RowSet rs) {
		// keep only those rows where is-active is true
		try {
			return rs.getBoolean("is_active");
		}catch(SQLException e) {
			return false;
		}
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		//not used in our filter
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		//not used in our filter
		return false;
	}

}
