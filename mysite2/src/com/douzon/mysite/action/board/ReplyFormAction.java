package com.douzon.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.vo.BoardVo;

public class ReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardVo board=new BoardDao().get(Long.parseLong(request.getParameter("no")));
		
		request.setAttribute("board", board);
		WebUtils.forward(request, response, "/WEB-INF/views/board/reply.jsp");
	}

}
