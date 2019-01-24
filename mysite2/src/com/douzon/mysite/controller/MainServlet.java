package com.douzon.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.AbstractActionFactory;
import com.douzon.mvc.action.Action;
import com.douzon.mysite.action.main.MainActionFactory;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		AbstractActionFactory af = new MainActionFactory();

		String actionName = request.getParameter("a");
		Action action = af.getAction(actionName);
		action.execute(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
