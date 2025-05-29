package co.icesi.taskManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.icesi.taskManager.dtos.TaskListDto;
import co.icesi.taskManager.mappers.TaskListMapper;
import co.icesi.taskManager.model.TaskList;
import co.icesi.taskManager.services.impl.TaskListService;


@RestController
@RequestMapping("/api/tasks-list")
public class TaskListController {
    @Autowired
    private TaskListService service;

    @Autowired
    private TaskListMapper taskListMapper;

    @GetMapping
    public ResponseEntity<List<TaskListDto>> getAllLists() {
        List<TaskList> lists = service.getAll();
        List<TaskListDto> listDtos = lists.stream()
                                        .map(taskListMapper::toDto)
                                        .toList();
        return ResponseEntity.ok(listDtos);
    }
}
