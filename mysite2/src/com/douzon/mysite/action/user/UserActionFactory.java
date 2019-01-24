package com.douzon.mysite.action.user;

import com.douzon.mvc.action.AbstractActionFactory;
import com.douzon.mvc.action.Action;
import com.douzon.mysite.action.main.IndexAction;
import com.douzon.mysite.action.user.LoginformAction;
public class UserActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		if ("joinform".equals(actionName)) {
			action = new JoinFormAction();
		} else if ("join".equals(actionName)) {
			action=new JoinAction();
		}  else if ("joinsuccess".equals(actionName)) {
			action=new JoinSuccessAction();
		} 
		else if ("loginform".equals(actionName)) {
			action=new LoginformAction();
		} else {
			action = new IndexAction();
		}
		return action;
	}

}
