package com.douzon.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.repository.UserDao;
import com.douzon.mysite.vo.BoardVo;
import com.douzon.mysite.vo.UserVo;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserVo user = new UserVo();
		user.setNo(Long.parseLong(request.getParameter("no")));
		String title=request.getParameter("title");
		String contents=request.getParameter("content");
		
		
		BoardVo vo=new BoardVo();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setUser(user);
		
		new BoardDao().insert(vo);
		
		WebUtils.redirect(request, response, request.getContextPath() + "/board");
	}

}
