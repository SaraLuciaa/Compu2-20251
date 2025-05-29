package co.icesi.taskManager.mappers;

import co.icesi.taskManager.dtos.TaskListDto;
import co.icesi.taskManager.model.TaskList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface TaskListMapper {
    TaskListDto toDto(TaskList list);
}