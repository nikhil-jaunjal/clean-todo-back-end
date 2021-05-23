package com.example.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.config.CustomDozerHelper;
import com.example.models.NoteEntity;
import com.example.repositories.NoteRepository;
import com.example.services.NoteService;

@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteRepository noteRepository;
	private Mapper mapper = new DozerBeanMapper();
	
	@Override
	public Object save(NoteEntity noteEntity) throws Exception {
		Map<String, Object> data = new HashMap<>();		
		try {						
			data.put("success", noteRepository.save(noteEntity));
		} catch (Exception e) {	
			e.printStackTrace();
			data.put("error", e.getMessage());
		}
		return data;
	}

	@Override
	public Object delete(Long id) throws Exception {
		Map<String, Object> data = new HashMap<>();
		try {				
			noteRepository.deleteById(id);
			data.put("success", "note data of id "+ id + " deleted");
		}catch (Exception e) {
			e.printStackTrace();
			data.put("error", e.getMessage());
		}
		return data;
	}

	@Override
	public Object getNote(Long id) throws Exception {
		Map<String, Object> data = new HashMap<>();
		try {;
			data.put("note", noteRepository.findById(id));
		} catch(Exception e) {
			e.printStackTrace();
			data.put("error", e.getMessage());
		}
		return data;
	}
	
	@Override
	public Object getAllNotes() throws Exception{		
			Map<String, Object> data = new HashMap<>();		
			try {			
				List<NoteEntity> noteList =  (List<NoteEntity>) noteRepository.findAll();
				data.put("noteList",CustomDozerHelper.map(mapper, noteList, NoteEntity.class));
			} catch (Exception e) {	
				e.printStackTrace();
				data.put("error", e.getMessage());
			}
			return data;		
	}
	
	@Override
	public Object getNotesByUserId(Long id) throws Exception{
		Map<String, Object> data = new HashMap<>();		
		try {			
			List<NoteEntity> noteList =  (List<NoteEntity>) noteRepository.findNoteByUserId(id);
			data.put("noteList",CustomDozerHelper.map(mapper, noteList, NoteEntity.class));
		} catch (Exception e) {	
			e.printStackTrace();
			data.put("error", e.getMessage());
		}
		return data;
	}

}
