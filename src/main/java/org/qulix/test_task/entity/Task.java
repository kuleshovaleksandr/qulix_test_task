package org.qulix.test_task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.qulix.test_task.model.Status;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Integer id;

    private String name;

    private Integer workTime;

    private Timestamp startDate;

    private Timestamp endDate;

    private Status status;

    private Integer projectId;
}
