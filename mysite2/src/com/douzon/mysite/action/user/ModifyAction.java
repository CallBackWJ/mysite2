package com.douzon.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.UserDao;
import com.douzon.mysite.vo.UserVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long no = Long.parseLong(request.getParameter("no"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		
		UserVo vo = new UserVo();
		vo.setNo(no);
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);
		
		boolean result=new UserDao().update(vo);
		
		if(result){
		HttpSession session=request.getSession(true);
		session.setAttribute("authuser", vo);
		}
		WebUtils.redirect(request, response, request.getContextPath());

	}

}
