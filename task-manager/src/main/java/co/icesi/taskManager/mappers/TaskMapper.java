package co.icesi.taskManager.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.icesi.taskManager.dtos.TaskDto;
import co.icesi.taskManager.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "list.id", target = "listId")
    TaskDto taskToTaskDto(Task task);

    @Mapping(source = "listId", target = "list.id") // opcional para el otro sentido
    Task taskDtoToTask(TaskDto dto);
}