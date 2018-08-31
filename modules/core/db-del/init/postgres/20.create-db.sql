-- begin TASKS_TASK
alter table TASKS_TASK add constraint FK_TASKS_TASK_ON_TASK_TYPICAL foreign key (TASK_TYPICAL_ID) references TASKS_TASK_TYPICAL(ID)^
alter table TASKS_TASK add constraint FK_TASKS_TASK_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID)^
alter table TASKS_TASK add constraint FK_TASKS_TASK_ON_PERFORMER foreign key (PERFORMER_ID) references SEC_USER(ID)^
alter table TASKS_TASK add constraint FK_TASKS_TASK_ON_DOCUMENT_EXAMPLE foreign key (DOCUMENT_EXAMPLE_ID) references TASKS_DOCUMENT_EXAMPLE(ID)^
create index IDX_TASKS_TASK_ON_TASK_TYPICAL on TASKS_TASK (TASK_TYPICAL_ID)^
create index IDX_TASKS_TASK_ON_AUTHOR on TASKS_TASK (AUTHOR_ID)^
create index IDX_TASKS_TASK_ON_PERFORMER on TASKS_TASK (PERFORMER_ID)^
create index IDX_TASKS_TASK_ON_DOCUMENT_EXAMPLE on TASKS_TASK (DOCUMENT_EXAMPLE_ID)^
-- end TASKS_TASK
-- begin TASKS_TASK_TEMPLATE
create unique index IDX_TASKS_TASK_TEMPLATE_UK_NAME on TASKS_TASK_TEMPLATE (NAME) where DELETE_TS is null ^
-- end TASKS_TASK_TEMPLATE
-- begin TASKS_TASK_TYPICAL
create unique index IDX_TASKS_TASK_TYPICAL_UK_NAME on TASKS_TASK_TYPICAL (NAME) where DELETE_TS is null ^
-- end TASKS_TASK_TYPICAL
-- begin TEMPLATE_TASK_TYPICAL_LINK
alter table TEMPLATE_TASK_TYPICAL_LINK add constraint FK_TEMTASTYP_ON_TASK_TEMPLATE foreign key (TASK_TEMPLATE_ID) references TASKS_TASK_TEMPLATE(ID)^
alter table TEMPLATE_TASK_TYPICAL_LINK add constraint FK_TEMTASTYP_ON_TASK_TYPICAL foreign key (TASK_TYPICAL_ID) references TASKS_TASK_TYPICAL(ID)^
-- end TEMPLATE_TASK_TYPICAL_LINK
