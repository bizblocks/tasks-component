alter table TASKS_TASK_TYPICAL rename column task_id to task_id__u71829 ;
alter table TASKS_TASK_TYPICAL alter column task_id__u71829 drop not null ;
drop index IDX_TASKS_TASK_TYPICAL_ON_TASK ;
alter table TASKS_TASK_TYPICAL drop constraint FK_TASKS_TASK_TYPICAL_ON_TASK ;
