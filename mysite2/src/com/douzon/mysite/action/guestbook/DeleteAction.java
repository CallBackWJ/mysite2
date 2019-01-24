package com.douzon.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.GuestBookDao;
import com.douzon.mysite.vo.GuestBookVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long no = Long.parseLong(request.getParameter("no"));
		String password = request.getParameter("password");
		GuestBookVo vo = new GuestBookVo();
		vo.setNo(no);
		vo.setPassword(password);
		new GuestBookDao().delete(vo);
		WebUtils.redirect(request, response, request.getContextPath()+"/guestbook");
	}

}
