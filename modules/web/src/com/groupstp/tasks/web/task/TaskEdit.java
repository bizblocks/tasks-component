package com.groupstp.tasks.web.task;

import com.groupstp.tasks.entity.*;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.components.*;
import org.apache.commons.lang.time.DateUtils;

import javax.inject.Inject;
import java.util.Date;
import java.util.Map;

public class TaskEdit extends AbstractEditor<Task> {

    @Inject
    private FieldGroup fieldGroup;

    @Inject
    UserSessionSource userSessionSource;

    private TaskTypical taskTypical;
    private TaskableEntityImpl taskableEntity;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        taskTypical = (TaskTypical) params.get("taskTypical");
        taskableEntity = (TaskableEntityImpl) params.get("taskableEntity");

        if (taskTypical != null && taskTypical.getInterval() > 0 && taskTypical.getIntervalType() != null) {

            ((DateField) fieldGroup.getComponent("startDate")).addValueChangeListener(e -> {

                Date endDate = countEndDateFromStartDate((Date) e.getValue(), taskTypical.getInterval(), taskTypical.getIntervalType());
                ((DateField) fieldGroup.getComponent("endDate")).setValue(endDate);

            });
        }

    }

    /**
     * @param startDate
     * @param interval     Integer
     * @param intervalType Hour,Day,Month....
     * @return - startDate + interval of intervalType (example: 01.01.2018 + 3 of Day = 04.01.2018)
     */
    private Date countEndDateFromStartDate(Date startDate, Integer interval, IntervalType intervalType) {
        switch (intervalType) {
            case Minutes:
                return DateUtils.addMinutes(startDate, interval);
            case Hours:
                return DateUtils.addHours(startDate, interval);
            case Days:
                return DateUtils.addDays(startDate, interval);
            case Month:
                return DateUtils.addMonths(startDate, interval);
        }
        return null;
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