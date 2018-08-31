package com.groupstp.tasks.web.task;

import com.groupstp.tasks.entity.*;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.components.*;

import javax.inject.Inject;
import java.util.Date;
import java.util.Map;

import static com.groupstp.tasks.web.Utils.countEndDateFromStartDate;

public class TaskEdit extends AbstractEditor<Task> {

    @Inject
    private FieldGroup fieldGroup;

    @Inject
    UserSessionSource userSessionSource;

    private TaskTypical taskTypical;
    private TaskableEntity taskableEntity;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        taskTypical = (TaskTypical) params.get("taskTypical");
        taskableEntity = (TaskableEntity) params.get("taskableEntity");

        if (taskTypical != null && taskTypical.getInterval() > 0 && taskTypical.getIntervalType() != null) {

            ((DateField) fieldGroup.getComponent("startDate")).addValueChangeListener(e -> {

                Date endDate = countEndDateFromStartDate((Date) e.getValue(), taskTypical.getInterval(), taskTypical.getIntervalType());
                ((DateField) fieldGroup.getComponent("endDate")).setValue(endDate);
            });
        }
    }

    @Override
    public void ready() {
        super.ready();

        if (taskTypical != null) {
            ((PickerField) fieldGroup.getComponent("taskTypical")).setValue(taskTypical);
            ((TextField) fieldGroup.getComponent("taskTypicalDescription")).setValue(taskTypical.getDescription());
            ((PickerField) fieldGroup.getComponent("taskableEntity")).setValue(taskableEntity);
            ((LookupField) fieldGroup.getComponent("status")).setValue(TaskStatus.Assigned);
            ((PickerField) fieldGroup.getComponent("author")).setValue(userSessionSource.getUserSession().getCurrentOrSubstitutedUser());
        }
    }
}