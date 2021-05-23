package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Note")
public class NoteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "noteId")
	private Long noteId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;	
	
	@Column(name = "userId")
	private Long userId;
}
