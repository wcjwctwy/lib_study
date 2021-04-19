package cn.sf80.lib.study.camunda;

import static org.slf4j.LoggerFactory.getLogger;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Showcase {

  private final Logger logger = getLogger(this.getClass());

  @Autowired
  private RuntimeService runtimeService;

  @Autowired
  private TaskService taskService;

  private String processInstanceId;

  @RequestMapping("/test/{processName}")
  public void notify(@PathVariable String processName) {
    HashMap<String, Object> variables = new HashMap<>();
    variables.put("ts",2);
    processInstanceId = runtimeService.startProcessInstanceByKey(processName, variables).getProcessInstanceId();
    logger.info("started instance: {}", processInstanceId);

    Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
    taskService.complete(task.getId());
    logger.info("completed task: {}", task);

    // now jobExecutor should execute the async job
  }

  public String getProcessInstanceId() {
    return processInstanceId;
  }
}