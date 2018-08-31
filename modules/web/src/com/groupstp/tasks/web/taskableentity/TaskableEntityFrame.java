package com.groupstp.tasks.web.taskableentity;

import com.groupstp.tasks.entity.Task;
import com.groupstp.tasks.entity.TaskTypical;
import com.groupstp.tasks.entity.TaskableEntityImpl;
import com.groupstp.tasks.web.task.TaskListFrame;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.icons.CubaIcon;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Controller for component's main screen
 *
 */
public class TaskableEntityFrame extends AbstractLookup {

    private static final Logger log = LoggerFactory.getLogger(TaskListFrame.class);

    @Inject
    private Table<TaskableEntityImpl> entitiesTable;

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private CollectionDatasource<TaskableEntityImpl, UUID> entitiesDs;

    @Inject
    private ButtonsPanel buttonsPanel;

    @Inject
    DataManager dataManager;

    @Inject
    Metadata metadata;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        initFrame();
    }

    /**
     * Initialize screen's components
     */
    private void initFrame() {

        EditAction action = (EditAction) entitiesTable.getAction(EditAction.ACTION_ID);
        Objects.requireNonNull(action).setAfterCommitHandler(entity -> entitiesDs.refresh());

        makeButton(CubaIcon.CALENDAR_PLUS_O, new BaseAction("assigntask") {
            @Override
            public void actionPerform(Component component) {
                super.actionPerform(component);
                Set<TaskableEntityImpl> selected = entitiesTable.getSelected();

                selected.forEach(taskableEntity -> {

                    openLookup(TaskTypical.class, items -> {
                        if (items.size() == 0) {
                            return;
                        } else if (items.size() > 1) {
                            throw new IllegalArgumentException("Only one typical task can be selected!");
                        }
                        TaskTypical taskTypical = (TaskTypical) items.iterator().next();
                        Task task = metadata.create(Task.class);

                        openEditor(task, WindowManager.OpenType.DIALOG, ParamsMap.of("taskTypical", taskTypical, "taskableEntity", taskableEntity));

                    }, WindowManager.OpenType.DIALOG);

                    dataManager.commit(taskableEntity);
//                    log.info("Successfully assign task to document {} ", taskableEntity.getName());
                });
            }
        });

        makeButton(CubaIcon.CALENDAR, new BaseAction("assigntasks") {
            @Override
            public void actionPerform(Component component) {
                super.actionPerform(component);
                Set<TaskableEntityImpl> selected = entitiesTable.getSelected();

                selected.forEach(task -> {

                    //todo templates

                });
            }
        });

    }

    /**
     * Make the button from Strategy and add it to screen
     *
     * @param cubaIcon   - example CubaIcon.CHECK.source()
     * @param action - Pattern Strategy
     */
    private void makeButton(CubaIcon cubaIcon, BaseAction action) {
        Button button = componentsFactory.createComponent(Button.class);
        button.setAction(action);
        button.setCaption(getMessage(action.getId()));
        button.setIcon(cubaIcon.source());
        buttonsPanel.add(button);
    }

}

