package com.douzon.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.vo.BoardVo;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		String kwd=request.getParameter("kwd");
		String page=request.getParameter("page");
		if(page==null)page="1";
		
		
		
		List<BoardVo> list = dao.getList(kwd,Long.parseLong(page));

		Paging paging=new Paging();
		paging.makeBlock((int)Long.parseLong(page));
		paging.makeLastPageNum(dao.getCount(kwd));
		Integer blockStartNum = paging.getBlockStartNum();
		Integer blockLastNum = paging.getBlockLastNum();
		Integer lastPageNum = paging.getLastPageNum();
		
		request.setAttribute("kwd", kwd);
		request.setAttribute("curPageNum", (int)Long.parseLong(page));
		request.setAttribute("blockStartNum", blockStartNum);
		request.setAttribute("blockLastNum", blockLastNum);
		request.setAttribute("lastPageNum", lastPageNum);
		
		// 데이터를 request범위에 저장
		request.setAttribute("list", list);

		// 포워딩
		WebUtils.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
