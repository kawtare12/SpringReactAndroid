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

import lombok.RequiredArgsConstructor;
import ma.projet.entities.Filiere;
import ma.projet.repository.FiliereRepository;
import ma.projet.services.FiliereService;

@RestController
@RequestMapping("/api/v1/filieres")
@CrossOrigin(origins = "http://localhost:3000") 
//@RequiredArgsConstructor
public class FiliereController {
	
	@Autowired
	private FiliereService filiereService;
	

	@GetMapping
	public List<Filiere> findAllFiliere(){
		return filiereService.findAll();
	}
	
	@GetMapping("/{id}")
	// associe id entrer au chemin on entre que id 
	// responseEntity pour gerer e cas ou on trouve pas un element par son id pour faire le if else 
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Filiere filiere = filiereService.findById(id);
		if(filiere == null) {
			return new ResponseEntity<Object>("Filiere with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(filiere);
		}
	}
	
	@PostMapping
	//requestBody car on fait entrer tout l'objet dans swagger avc id,code et libelle 
	public Filiere createFiliere(@RequestBody Filiere filiere) {
		return filiereService.create(filiere);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateFiliere(@PathVariable Long id,@RequestBody Filiere filiere) {
		if(filiereService.findById(id) == null) {
			return new ResponseEntity<Object>("Filiere with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			filiere.setId(id);
			return ResponseEntity.ok(filiereService.update(filiere));
			//on entre id de la filiere qu'on veut modifier 
			// et sa envoie objet filiere "request body" on ecrit ce qu'on veut modifier
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFiliere(@PathVariable Long id){
		Filiere filiere = filiereService.findById(id);
		if(filiere == null) {
			return new ResponseEntity<Object>("Filiere with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			filiereService.delete(filiere);
			return ResponseEntity.ok("Filiere has been deleted");
		}
	}
}
