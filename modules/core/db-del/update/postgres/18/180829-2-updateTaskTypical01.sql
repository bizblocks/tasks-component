alter table TASKS_TASK_TYPICAL rename column date_time to date_time__u34930 ;
alter table TASKS_TASK_TYPICAL alter column date_time__u34930 drop not null ;
alter table TASKS_TASK_TYPICAL add column INTERVAL_ integer ;
alter table TASKS_TASK_TYPICAL add column INTERVAL_TYPE integer ;
