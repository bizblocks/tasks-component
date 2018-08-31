package com.groupstp.tasks.entity;

import java.util.List;

/**
 * All entities used this interface can work with TaskWorkerService
 */
public interface TaskableEntity {

    List<Task> getTasks();

    void setTasks(List<Task> tasks);

}
