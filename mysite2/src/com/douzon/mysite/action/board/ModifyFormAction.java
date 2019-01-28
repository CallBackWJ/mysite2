package com.douzon.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.vo.BoardVo;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardDao dao = new BoardDao();
		long no = Long.parseLong(request.getParameter("no"));
		BoardVo vo = dao.get(no);

		// 데이터를 request범위에 저장
		request.setAttribute("vo", vo);
		WebUtils.forward(request, response, "/WEB-INF/views/board/modify.jsp");
	}

}
