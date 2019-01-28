package com.douzon.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.repository.GuestBookDao;
import com.douzon.mysite.vo.GuestBookVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				long no = Long.parseLong(request.getParameter("no"));
				
				if(new BoardDao().delete(no))
				{
					System.out.println("게시판 삭제 성공:"+no);
				}else
				{
					System.out.println("게시판 삭제 실패:"+no);
				}
				WebUtils.redirect(request, response, request.getContextPath()+"/board");

	}

}
