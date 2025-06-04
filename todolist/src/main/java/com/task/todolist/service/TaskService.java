package com.task.todolist.service;

import com.task.todolist.model.Task;
import com.task.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	//Criar tarefa
	public Task criarTarefa(Task task) {
		return taskRepository.save(task);
	}
	
	//Listar todas as tarefas
	public List<Task> listarTarefas() {
		return taskRepository.findAll();
	}
	
	//buscar tarefa pelo id
	public Optional<Task> buscarPorId(Long id) {
		return taskRepository.findById(id);
	}
	
	//Atualizar uma tarefa existente
	public Optional<Task> atualizarTarefa(Long id, Task taskAtualizada) {
		return taskRepository.findById(id).map(task -> {
			task.setTitulo(taskAtualizada.getTitulo());
			task.setDescricao(taskAtualizada.getDescricao());
			task.setConcluida(taskAtualizada.getConcluida());
			return taskRepository.save(task);
		});
	}
	
	//deletar uma tarefa
	public void deletarTarefa(Long id) {
		taskRepository.deleteById(id);
	}

}
