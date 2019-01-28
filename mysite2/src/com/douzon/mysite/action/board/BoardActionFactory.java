package com.douzon.mysite.action.board;

import com.douzon.mvc.action.AbstractActionFactory;
import com.douzon.mvc.action.Action;


public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("view".equals(actionName)) {
			action = new ViewAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else if ("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		} else if ("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("writeform".equals(actionName)) {
			action = new WriteFormAction();
		} else if ("reply".equals(actionName)) {
			action = new ReplyAction();
		} else if ("replyform".equals(actionName)) {
			action = new ReplyFormAction();
		} else {
			action = new BoardListAction();
		}
		return action;
	}

}
