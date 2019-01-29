package com.douzon.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.douzon.mysite.vo.BoardVo;
import com.douzon.mysite.vo.UserVo;

public class BoardDao {

	public List<BoardVo> getList(String kwd, long page) {
		List<BoardVo> list = new ArrayList<BoardVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;

		if (kwd == null)
			kwd = "";
		try {
			conn = getConnection();
			String sql = "select * from board where title like '%" + kwd + "%' or contents like '%" + kwd
					+ "%' order by g_no desc, o_no asc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, (page * 5) - 5);
			pstmt.setLong(2, 5);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				long no = rs.getLong(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				contents = contents.replace("\r\n", "<br>");
				String date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(4));
				long hit = rs.getLong(5);
				long g_no = rs.getLong(6);
				long o_no = rs.getLong(7);
				long depth = rs.getLong(8);
				UserVo user = new UserDao().get(rs.getLong(9));

				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setDate(date);
				vo.setHit(hit);
				vo.setG_no(g_no);
				vo.setO_no(o_no);
				vo.setDepth(depth);
				vo.setUser(user);

				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println(e);

		} finally {

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return list;
	}

	public boolean insert(BoardVo boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "insert into board values(null,?,?,now(),0,ifnull((select MAX(b.g_no)+1 from board b),1),1,0,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardVo.getTitle());
			pstmt.setString(2, boardVo.getContents());
			pstmt.setLong(3, boardVo.getUser().getNo());

			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
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

	public BoardVo get(long no) {
		BoardVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql1 = "update board set hit = hit + 1 where no =?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setLong(1, no);
			pstmt.executeUpdate();

			String sql2 = "select * from board where no=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new BoardVo();
				vo.setNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setContents(rs.getString(3));
				vo.setDate(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(4)));
				vo.setHit(rs.getLong(5));
				vo.setG_no(rs.getLong(6));
				vo.setO_no(rs.getLong(7));
				vo.setDepth(rs.getLong(8));
				vo.setUser(new UserDao().get(rs.getLong(9)));

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	public boolean delete(long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "delete from board where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);

			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean update(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "update board set title=? , contents=? where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setLong(3, vo.getNo());

			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean reply(BoardVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String check = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql1 = "select if((select count(*) from board b where g_no=? and o_no=?) = 0,'true','false')";
			String sql2 = "update board set o_no=o_no+1 where g_no= ? and o_no>= ?";
			String sql3 = "insert into board values(null,?,?,now(),0,?,?,?,?)";

			pstmt = conn.prepareStatement(sql1);
			pstmt.setLong(1, vo.getG_no());
			pstmt.setLong(2, vo.getO_no());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				check = rs.getString(1);
				System.out.println(check);
			}
			if ("false".equals(check)) {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setLong(1, vo.getG_no());
				pstmt.setLong(2, vo.getO_no()+1);
				pstmt.executeUpdate();
			}

			pstmt = conn.prepareStatement(sql3);

			pstmt.setString(1, "RE:" + vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setLong(3, vo.getG_no());
			pstmt.setLong(4, vo.getO_no() + 1);
			pstmt.setLong(5, vo.getDepth() + 1);
			pstmt.setLong(6, vo.getUser().getNo());

			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int getCount() {
		List<BoardVo> list = new ArrayList<BoardVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			conn = getConnection();
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				BoardVo vo = new BoardVo();

				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println(e);

		} finally {

			try {
				if (conn != null)
					conn.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return list.size();
	}
}
