package com.douzon.mysite.action.guestbook;

import com.douzon.mvc.action.AbstractActionFactory;
import com.douzon.mvc.action.Action;
import com.douzon.mysite.action.main.IndexAction;
import com.douzon.mysite.action.user.JoinAction;
import com.douzon.mysite.action.user.JoinFormAction;
import com.douzon.mysite.action.user.JoinSuccessAction;
import com.douzon.mysite.action.user.LoginformAction;

public class GuestBookActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		} else if ("insert".equals(actionName)) {
			action = new InsertAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else {
			action = new GuestBookListAction();
		}
		return action;
	}

}
