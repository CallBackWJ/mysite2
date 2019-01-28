package com.douzon.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.vo.BoardVo;
import com.douzon.mysite.vo.UserVo;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserVo user = new UserVo();
		user.setNo(Long.parseLong(request.getParameter("no")));
		long g_no=Long.parseLong(request.getParameter("g_no"));
		long o_no=Long.parseLong(request.getParameter("o_no"));
		long depth=Long.parseLong(request.getParameter("depth"));
		
		String title=request.getParameter("title");
		String contents=request.getParameter("content");
		
		
		BoardVo vo=new BoardVo();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setUser(user);
		vo.setG_no(g_no);
		vo.setO_no(o_no);
		vo.setDepth(depth);
		
		new BoardDao().reply(vo);
		
		WebUtils.redirect(request, response, request.getContextPath() + "/board");
	}

}
