package com.groupstp.tasks.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "TASKS_TASK")
@Entity(name = "tasks$Task")
public class Task extends StandardEntity {

    private static final long serialVersionUID = 8564942625551240057L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TASK_TYPICAL_ID")
    protected TaskTypical taskTypical;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    protected Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    protected Date endDate;


    @NotNull
    @Column(name = "STATUS", nullable = false)
    protected Integer status;

    @Column(name = "CONTROL")
    protected Boolean controlNeeded;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AUTHOR_ID")
    protected User author;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PERFORMER_ID")
    protected User performer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TASKABLE_ENTITY_ID")
    protected TaskableEntityImpl taskableEntity;

    public TaskableEntityImpl getTaskableEntity() {
        return taskableEntity;
    }

    public void setTaskableEntity(TaskableEntityImpl taskableEntity) {
        this.taskableEntity = taskableEntity;
    }

    @Lob
    @Column(name = "COMMENT_")
    protected String comment;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }


    public void setStatus(TaskStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public TaskStatus getStatus() {
        return status == null ? null : TaskStatus.fromId(status);
    }


    public void setTaskTypical(TaskTypical taskTypical) {
        this.taskTypical = taskTypical;
    }

    public TaskTypical getTaskTypical() {
        return taskTypical;
    }


    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }


    public void setPerformer(User performer) {
        this.performer = performer;
    }

    public User getPerformer() {
        return performer;
    }

    public void setControlNeeded(Boolean control) {
        this.controlNeeded = control;
    }

    public Boolean getControlNeeded() {
        return controlNeeded;
    }

    public void setStartDate(Date begin) {
        this.startDate = begin;
    }

    public Date getStartDate() {
        return startDate;
    }


    public void setEndDate(Date deadline) {
        this.endDate = deadline;
    }

    public Date getEndDate() {
        return endDate;
    }


}