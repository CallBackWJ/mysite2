package com.douzon.mysite.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read cookie
		int cnt=1;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null&& cookies.length>0)
		{
			for(Cookie c:cookies)
			{
				if("visitCount".equals(c.getName()))
				{
					System.out.println();
					cnt=Integer.parseInt(c.getValue());
					break;
				}
			}
		}
		
		
		
		//make cookie
		Cookie cookie=new Cookie("visitCount",""+(++cnt));
		cookie.setMaxAge(24*60*60);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		WebUtils.forward(request, response, "WEB-INF/views/main/index.jsp");
	}

}
