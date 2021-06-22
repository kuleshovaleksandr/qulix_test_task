package org.qulix.test_task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private Integer id;

    private String name;

    private String shortName;

    private String describe;
}
