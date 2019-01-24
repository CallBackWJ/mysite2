package com.douzon.mysite.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebUtils.forward(request, response, "WEB-INF/views/main/index.jsp");
	}

}
