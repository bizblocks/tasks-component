-- begin TASKS_TASK
create table TASKS_TASK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TASK_TYPICAL_ID uuid not null,
    START_DATE date,
    END_DATE date,
    STATUS integer not null,
    CONTROL boolean,
    AUTHOR_ID uuid not null,
    PERFORMER_ID uuid not null,
    TASKABLE_ENTITY_ID uuid not null,
    COMMENT_ text,
    --
    primary key (ID)
)^
-- end TASKS_TASK
-- begin TASKS_TASK_TEMPLATE
create table TASKS_TASK_TEMPLATE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50) not null,
    DESCRIPTION varchar(255),
    --
    primary key (ID)
)^
-- end TASKS_TASK_TEMPLATE

-- begin TASKS_TASK_TYPICAL
create table TASKS_TASK_TYPICAL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50) not null,
    DESCRIPTION text not null,
    INTERVAL_ integer,
    INTERVAL_TYPE integer,
    --
    primary key (ID)
)^
-- end TASKS_TASK_TYPICAL
-- begin TEMPLATE_TASK_TYPICAL_LINK
create table TEMPLATE_TASK_TYPICAL_LINK (
    TASK_TEMPLATE_ID uuid,
    TASK_TYPICAL_ID uuid,
    primary key (TASK_TEMPLATE_ID, TASK_TYPICAL_ID)
)^
-- end TEMPLATE_TASK_TYPICAL_LINK
-- begin TASKS_TASKABLE_ENTITY_IMPL
create table TASKS_TASKABLE_ENTITY_IMPL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50) not null,
    --
    primary key (ID)
)^
-- end TASKS_TASKABLE_ENTITY_IMPL
