package com.action;

import java.util.List;
import java.util.Map;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.model.ActivityCoordinates;
import org.jbpm.api.task.Task;



public class Jbpm4Action extends BaseAction {

	private ProcessEngine processEngine;
    private RepositoryService repositoryService;
    private ExecutionService executionService;
    private TaskService taskService ;
    private String id;
    private List<ProcessDefinition> processDefinitionList;
    private List<ProcessInstance> processInstanceList;
    private List<Task> taskList;
    private ActivityCoordinates ac; 
    private Map<String, Object> map;
    private String result;
    
    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
    
    public ActivityCoordinates getAc(){
        return ac;
    }

    public List<ProcessInstance> getProcessInstanceList(){
        return processInstanceList;
    }

    public List<Task> getTaskList(){
        return taskList;
    }

    private void init(){
        repositoryService=processEngine.getRepositoryService();
        executionService=processEngine.getExecutionService();
        taskService=processEngine.getTaskService();
    }
    
    public List<ProcessDefinition> getProcessDefinitionList(){
        return processDefinitionList;
    }
    
}
