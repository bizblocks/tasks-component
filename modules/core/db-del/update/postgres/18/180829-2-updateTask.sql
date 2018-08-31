-- alter table TASKS_TASK add column TASK_TYPICAL_ID uuid ^
-- update TASKS_TASK set TASK_TYPICAL_ID = <default_value> ;
-- alter table TASKS_TASK alter column TASK_TYPICAL_ID set not null ;
alter table TASKS_TASK add column TASK_TYPICAL_ID uuid not null ;
