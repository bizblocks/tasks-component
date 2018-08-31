package com.groupstp.tasks.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "TASKS_TASKABLE_ENTITY_IMPL")
@Entity(name = "tasks$TaskableEntityImpl")
public class TaskableEntityImpl extends StandardEntity implements TaskableEntity{
    private static final long serialVersionUID = 4476977396181679094L;

    @NotNull
    @Column(name = "NAME", nullable = false, length = 50)
    protected String name;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "taskableEntity")
    protected List<Task> tasks;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void setTasks(List<Task> tasksList) {
        this.tasks = tasksList;
    }
}