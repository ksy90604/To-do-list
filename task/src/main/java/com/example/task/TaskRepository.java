package com.example.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	Task findById(String id);
	int countByParentIdAndFinYn(String parentId, String finYn);
}