package com.test.action;

import org.jbpm.api.ProcessEngine;

import com.opensymphony.xwork2.ActionSupport;

public class Jbpm4TestAction extends  ActionSupport {

	private ProcessEngine processEngine;

	public ProcessEngine getProcessEngine() {
		return processEngine;
	}

	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}
	
	public String testJbpm(){
		System.out.println("整合成功");
		System.out.println("processEngine: " + processEngine);
		return SUCCESS;
	}
}
