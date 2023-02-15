package it.epicode.w5.d3.le1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.w5.d3.le1.entities.Messaggio;
import it.epicode.w5.d3.le1.services.MessaggioSrv;
import it.epicode.w5.d3.le1.services.UtenteSrv;
import jakarta.websocket.server.PathParam;

@RestController
//@RequestMapping("/")
public class MessageController {
	
	@Autowired
	MessaggioSrv ms;

	@PostMapping("/messages")
	public ResponseEntity<Object> saveMessage(@RequestBody Messaggio m) {
		 
	Messaggio messaggio = ms.save(m);
	 return new ResponseEntity<>(messaggio, HttpStatus.CREATED);
	}
	
	@GetMapping("/messages/{id}")
	public Optional<Messaggio> getMessages(@PathVariable int id) {
		return ms.getMessage(id);
	};
	
	@PutMapping("messages/{id}")
	public ResponseEntity<Object> update(
			@PathVariable Integer id, 
			@RequestBody Messaggio _message){
		Optional<Messaggio> messaggioObj = ms.getMessage(id);
		
		Messaggio messaggio = messaggioObj.get();
		messaggio.setTesto(_message.getTesto());
		ms.save(messaggio);
		
		return new ResponseEntity<>(messaggio, HttpStatus.CREATED); 
		
	}
	
	
	@DeleteMapping("messages/{id}")
	public ResponseEntity<Object> delete(
			@PathVariable int id){
		Optional<Messaggio> messaggioObj = ms.getMessage(id);
		ms.delete(messaggioObj.get());
		return new ResponseEntity<>(String.format("Messaggio con id %d eliminato", id), HttpStatus.OK);
		
	}
	
	@GetMapping("/messages")
	Page<Messaggio> getMessaggioByPage(@RequestParam int pageSize, @RequestParam int pageNumber){
		return ms.getAllPag(pageNumber, pageSize);
	}
	
	
	
	
	
	
	
	
	
	
	

}
