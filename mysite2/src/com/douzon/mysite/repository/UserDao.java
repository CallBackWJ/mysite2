package com.douzon.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.douzon.mysite.vo.UserVo;

public class UserDao {
	
	public boolean insert(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql ="insert into user values(null,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getEmail());
			pstmt.setString(3, userVo.getPassword());
			pstmt.setString(4, userVo.getGender());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/webdb?autoReconnect=true&useSSL=false";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}
}
