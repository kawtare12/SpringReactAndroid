package ma.projet.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import ma.projet.entities.Role;
import ma.projet.services.RoleService;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = "http://localhost:3000") 

public class RoleController {
	@Autowired
	private RoleService roleService;
	
	
	@GetMapping
	public List<Role> getAllRoles() {
		return roleService.findAll();
	}
	
	
	

	@GetMapping("/{id}")
	public Role getById(@PathVariable Long id) {
		return roleService.findById(id);

	}

	@PostMapping("")
	public Role createRole(@RequestBody Role role) {
//		Role role = roleRepository.findById(role.getRoles().get(0).getId()).get();
//		System.out.println(role.getName());
//		role.getRoles().add(role);
		return roleService.create(role);
	}

	@PutMapping("/{id}")
	public ResponseEntity updaterole(@PathVariable Long id, @RequestBody Role role) {

		if (role == null) {
			return new ResponseEntity<Object>("role avec ID " + id + " n exite pas", HttpStatus.BAD_REQUEST);
		} else {
			role.setId(id);
			roleService.update(role);
			return ResponseEntity.ok("UPDATE AVEC SUCCEs");
			// return ResponseEntity.ok("");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		Role role = roleService.findById(id);
		
		if (role == null) {
			return new ResponseEntity<Object>("role avec ID " + id + " n exite pas", HttpStatus.BAD_REQUEST);
		} else {
			roleService.delete(role);
			return ResponseEntity.ok(" supression avec succes ");

		}
	}
}
