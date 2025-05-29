package co.icesi.taskManager.dtos;

import lombok.Data;
import java.util.List;

@Data
public class TaskListDto {
    private Integer id;
    private String name;
    private Integer orderList;
    private List<TaskDto> tasks; // debes usar el mismo TaskDto
}
