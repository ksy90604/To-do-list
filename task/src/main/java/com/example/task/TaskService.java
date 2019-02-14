package com.example.task;

import java.util.List;

public interface TaskService {
	// 할 일 조회
	public Task getTask(String id) throws Exception;

	// 할 일 추가
	public void insertTask(Task task) throws Exception;

	// 자신의 아이디를 참조하고 있는 할 일 갯수
	public int referChild(String id) throws Exception;

	// 할 일 수정
	public void updateTask(Task task) throws Exception;

	// 할 일 목록 조회
	public List<Task> getTaskList() throws Exception;

	// 할 일 삭제
	public void deleteTask(Task task) throws Exception;

}
