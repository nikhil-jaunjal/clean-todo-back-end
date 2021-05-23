package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.NoteEntity;

@Repository
public interface NoteRepository extends CrudRepository<NoteEntity, Long>{

	List<NoteEntity> findNoteByUserId(Long id);

}
