package br.com.allanlf.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allanlf.model.Colaborador;
import br.com.allanlf.model.ColaboradorDto;
import br.com.allanlf.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	ColaboradorRepository repository;
	
	public List<Colaborador> listAll() {
		return repository.findAll();
	}
	
	public Optional<Colaborador> findById(Long id) {
		return repository.findById(id);
	}
	
	public Colaborador create(Colaborador colaborador) {
	    if (colaborador.getChefeId() != null) {
	        Colaborador chefe = repository.findById(colaborador.getChefeId())
	            .orElseThrow(() -> new RuntimeException("Chefe não encontrado"));
	        colaborador.setChefe(chefe);
	    }
	    colaborador.setScore(getSecurityScore(colaborador.getSenha()));
	    colaborador.setSenha(hashPassword(colaborador.getSenha()));
	    return repository.save(colaborador);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public ColaboradorDto toDto(Colaborador colaborador) {
	    String chefeNome = colaborador.getChefe() != null ? colaborador.getChefe().getNome() : null;
	    return new ColaboradorDto(colaborador.getNome(), colaborador.getScore(), chefeNome);
	}

	
	private int getSecurityScore(String password) {
        int score = 0;

        // Comprimento da senha
        if (password.length() >= 10) {
            score += 20;
        } else if (password.length() >= 8) {
            score += 10;
        }

        // Se tem letras minúsculas
        if (password.matches(".*[a-z].*")) {
            score += 20;
        }

        // Se tem letras maiúsculas
        if (password.matches(".*[A-Z].*")) {
            score += 20;
        }

        // Se tem números
        if (password.matches(".*[0-9].*")) {
            score += 20;
        }

        // Se tem caracteres especiais
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            score += 20;
        }

        return score;
    }
	
	//Este método gera um hash da senha
    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    //Este método verifica se o texto sem formatação fornecido corresponde ao hash
//    private boolean checkPassword(String plainPassword, String hashedPassword) {
//        return BCrypt.checkpw(plainPassword, hashedPassword);
//    }
}
