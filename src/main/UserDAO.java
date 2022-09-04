package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private DBUtil db;

	public boolean findUser(String userName, String userPassword) {
		db = new DBUtil();
		Connection conn = db.getConnection();
		String sql = "select passwd from user1 where username=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String rPassword = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				rPassword = rset.getString("passwd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rPassword != null && rPassword.equals(userPassword)) {
			return true;
		}
		return false;
	}

}
