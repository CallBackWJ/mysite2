package com.douzon.mysite.vo;

public class BoardVo {

	private long no;
	private String title;
	private String contents;
	private String date;
	private long hit;
	private long g_no;
	private long o_no;
	private long depth;
	private UserVo user;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	public long getG_no() {
		return g_no;
	}
	public void setG_no(long g_no) {
		this.g_no = g_no;
	}
	public long getO_no() {
		return o_no;
	}
	public void setO_no(long o_no) {
		this.o_no = o_no;
	}
	public long getDepth() {
		return depth;
	}
	public void setDepth(long depth) {
		this.depth = depth;
	}
	public UserVo getUser() {
		return user;
	}
	public void setUser(UserVo user) {
		this.user = user;
	}
	
	
	
	
}
