package org.qulix.test_task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.qulix.test_task.model.Status;

//import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Integer id;

    private Integer workTime;

//    private LocalDateTime startTime;
//
//    private LocalDateTime endTime;

    private Status status;

    private Integer projectId;
}
