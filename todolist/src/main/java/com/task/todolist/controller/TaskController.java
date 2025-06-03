package com.task.todolist.controller;

import com.task.todolist.model.Task;
import com.task.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/tarefas")
public class TaskController {
	
	private final TaskService taskService;
	
	
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	// criar nova tarefa
	@PostMapping
	public ResponseEntity<Task> criarTarefa(@Valid @RequestBody Task task) {
		Task novaTask = taskService.criarTarefa(task);
		return ResponseEntity.ok(novaTask);
	}
	
	// Listar todas as tarefas
	@GetMapping
	public ResponseEntity<List<Task>> listarTarefas() {
		List<Task> tarefas = taskService.listarTarefas();
		return ResponseEntity.ok(tarefas);
	}
	
	// Buscar uma tarefa pelo id
	@GetMapping("/{id}")
	public ResponseEntity<Task> buscarTarefaPorId(@PathVariable Long id) {
		return taskService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// Atualizar uma tarefa
	@PutMapping("/{id}")
	public ResponseEntity<Task> atualizarTarefa(@PathVariable Long id, @Valid @RequestBody Task task) {
		return taskService.atualizarTarefa(id, task)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// deletar uma tarefa
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
		taskService.deletarTarefa(id);
		return ResponseEntity.noContent().build();
	}

}
