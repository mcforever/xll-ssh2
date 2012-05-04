package com.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class SysInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invoke) throws Exception {
		if (null == ActionContext.getContext().getSession().get("sessionUser")) {
            return Action.LOGIN;
        } else {
            return invoke.invoke();
        }
	}

}
