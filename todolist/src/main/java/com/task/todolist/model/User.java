package com.task.todolist.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	@NotBlank(message = "Username é obrigatório")
	private String username;
	
	@Column(unique = false)
	@NotBlank(message = "Password é obrigatório")
	private String password;
	
	@Column(nullable = false)
	private String role;

}
