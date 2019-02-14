package com.example.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
	
    // 할 일 리스트
	@GetMapping(value = "/list")
	public List<Task> getTaskList() throws Exception {
        return taskService.getTaskList();
    }
	
	// 할 일 상세보기
	@GetMapping(value = "/{id}")
	public Task taskView(@PathVariable("id") String id) throws Exception {
        return taskService.getTask(id);
    }
	
	// 할 일 추가
	@PostMapping
    public void insertTask(@RequestParam(value="title", required=true) String title, 
    		@RequestParam(value="parentId", required=false) String parentId) throws Exception {
		Task task = new Task();
		task.setTitle(title);
		task.setParentId(parentId);
		
		taskService.insertTask(task);
    }
	
	// 할 일 수정
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public void updateTask(@PathVariable("id")String id, @RequestBody Task task) throws Exception {
		taskService.updateTask(task);
    }
	
	// 자신의 아이디를 참조하고 있는 할 일 갯수
	@RequestMapping(value = "/child/{id}", method=RequestMethod.GET)
	public int parentView(@PathVariable("id") String id) throws Exception {
        return taskService.referChild(id);
    }
	
	// 할 일 삭제
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public void deleteTask(@PathVariable("id")String id, @RequestBody Task task) throws Exception {
		taskService.deleteTask(task);
    }
}
