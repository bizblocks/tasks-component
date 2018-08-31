package com.groupstp.tasks.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Collection;

@NamePattern("%s|name")
@Table(name = "TASKS_TASK_TYPICAL")
@Entity(name = "tasks$TaskTypical")
public class TaskTypical extends StandardEntity {
    private static final long serialVersionUID = -6784089328712351409L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true, length = 50)
    protected String name;

    @NotNull
    @Lob
    @Column(name = "DESCRIPTION", nullable = false)
    protected String description;


    @Column(name = "INTERVAL_")
    protected Integer interval;

    @Column(name = "INTERVAL_TYPE")
    protected Integer intervalType;

    @ManyToMany(mappedBy = "tasks")
    protected Collection<TaskTemplate> taskTemplates;

    public Collection<TaskTemplate> getTaskTemplates() {
        return taskTemplates;
    }

    public void setTaskTemplates(Collection<TaskTemplate> taskTemplates) {
        this.taskTemplates = taskTemplates;
    }


    public IntervalType getIntervalType() {
        return intervalType == null ? null : IntervalType.fromId(intervalType);
    }

    public void setIntervalType(IntervalType intervalType) {
        this.intervalType = intervalType == null ? null : intervalType.getId();
    }




    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getInterval() {
        return interval;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}