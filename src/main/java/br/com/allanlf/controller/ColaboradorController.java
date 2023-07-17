package br.com.allanlf.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.allanlf.model.Colaborador;
import br.com.allanlf.model.ColaboradorDto;
import br.com.allanlf.service.ColaboradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	@Autowired
	ColaboradorService service;

	@GetMapping
	public ResponseEntity<List<ColaboradorDto>> getAll() {
	    List<Colaborador> colaboradores = service.listAll();
	    List<ColaboradorDto> colaboradorDtos = colaboradores.stream()
	        .map(service::toDto)
	        .collect(Collectors.toList());
	    return new ResponseEntity<>(colaboradorDtos, HttpStatus.OK);
	}

	
	@GetMapping("/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
        Optional<Colaborador> colaborador = service.findById(id);
        if (colaborador.isPresent()) {
            return new ResponseEntity<>(colaborador.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping
	public ResponseEntity<Colaborador> create(@Valid @RequestBody Colaborador colaborador) {
		Colaborador savedColaborador = service.create(colaborador);
	    return new ResponseEntity<>(savedColaborador, HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam Long id) {
		Optional<Colaborador> colaborador = service.findById(id);
		if(colaborador.isPresent()) {
			service.delete(id);
			return new ResponseEntity<String>("Colaborador deletado com successo", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Colaborador não encontrado", HttpStatus.NOT_FOUND);
		}
	}

}
