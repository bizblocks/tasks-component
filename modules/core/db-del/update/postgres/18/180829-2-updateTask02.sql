alter table TASKS_TASK rename column control_done to control_done__u28841 ;
alter table TASKS_TASK rename column task_done to task_done__u19946 ;
alter table TASKS_TASK add column STATUS integer ^
update TASKS_TASK set STATUS = 5 where STATUS is null ;
alter table TASKS_TASK alter column STATUS set not null ;
