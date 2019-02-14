package com.example.task;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Task {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id; 				// id

	@Column(name = "title")
	private String title; 			// 할일

	@CreationTimestamp
	@Column(name = "reg_date")
	private LocalDateTime regDate; 	// 등록일

	@UpdateTimestamp
	@Column(name = "upd_date")
	private LocalDateTime updDate; 	// 수정일

	@Column(name = "fin_yn")
	private String finYn = "N"; 	// 완료여부

	@Column(name = "parent_id")
	private String parentId; 		// 참조 부모 id

	protected Task() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getUpdDate() {
		return updDate;
	}

	public void setUpdDate(LocalDateTime updDate) {
		this.updDate = updDate;
	}

	public String getFinYn() {
		return finYn;
	}

	public void setFinYn(String finYn) {
		this.finYn = finYn;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return String.format("Task[id='%d', title='%s']", id, title);
	}

}
