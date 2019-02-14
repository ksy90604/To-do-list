package com.example.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

	private TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@Override
	public Task getTask(String id) throws Exception {
		return taskRepository.findById(id);
	}
	 
	@Override
	public void insertTask(Task task) throws Exception {
		taskRepository.save(task);
	}

	@Override
	public int referChild(String id) throws Exception {
		// 자신의 아이디를 참조하고 있는 할 일 정보
		return taskRepository.countByParentIdAndFinYn(id, "N");
	}

	@Override
	public void updateTask(Task task) throws Exception {
		Task tempTask = new Task();
		// 입력하지 않은 값은 null이 되는 현상이 있어 DB조회해서 다시 넣어줌.
		tempTask = this.getTask(task.getId());
		task.setRegDate(tempTask.getRegDate());
		taskRepository.save(task);
	}

	@Override
	public List<Task> getTaskList() throws Exception {
		return taskRepository.findAll();
	}

	@Override
	public void deleteTask(Task task) throws Exception {
		Task parentTask = getTask(task.getParentId());
		if(parentTask != null) {
			taskRepository.delete(task);
		}
	}
}
