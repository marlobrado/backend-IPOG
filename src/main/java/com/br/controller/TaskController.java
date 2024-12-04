package com.br.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.repository.TaskRepository;
import com.br.exception.ResourceNotFoundException;
import com.br.model.Task;

//o endereço dos serviços será : http://localhost/8080/ctast/

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ctask/")
@RestController
public class TaskController {

	//cria uma instancia do repositório JPA Hibernate
	@Autowired
	private TaskRepository uRep;
	
	//consulta todas as tarefas
	@GetMapping("/task")
	public List<Task> listar(){
		
		return this.uRep.findAll();
	}
	//consulta por id http://localhost:8080/ctask/task/{id}
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> consultar(@PathVariable Long id){
		
		Task task = this.uRep.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Tarefa não encontrado"));
		
		return ResponseEntity.ok(task);
	}
	
	// inserir nova tarefa
	// POST - http://localhost:8080/ctask/task + dados a ser inseridos
	
	@PostMapping("/task")
	public Task inserir(@RequestBody Task task) {
		return this.uRep.save(task);
		
	}
	
	// editar uma tarefa
	//PUT http://localhost:8080/ctask/task/{id} + DADOS A SEREM ALTERADOS NO CORPO
	@PutMapping("/task/{id}")
	public ResponseEntity<Task> alterar(@PathVariable Long id, @RequestBody Task task){
		
		Task tsk = this.uRep.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Tarefa não encontrado"));
		
		tsk.setId(id);
		tsk.setTitle(task.getTitle());
		tsk.setDescription(task.getDescription());
		
		Task taskAtualizada = uRep.save(tsk);
		
		return ResponseEntity.ok(taskAtualizada);
		
	}
	// excluir uma tarefa existente
	//DELETE http://localhost:8080/ctask/task/{id}
	@DeleteMapping("/task/{id}")
	public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id){
		
		Task task = this.uRep.findById(id).orElseThrow(()->
		new ResourceNotFoundException("tarefa nao encontrada " + id));
		
		this.uRep.delete(task);
		
		Map<String, Boolean> resposta = new HashMap<>();
		
		resposta.put("tarefa excluida", Boolean.TRUE);
		
		return ResponseEntity.ok(resposta);
		
	}
}
