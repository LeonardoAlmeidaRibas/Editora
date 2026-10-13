package dw.editora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dw.editora.entity.Autor;
import dw.editora.repository.AutorRepository;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    public Autor salvar (Autor autor){
        return autorRepository.save(autor);
    }

    public List<Autor> listarTodos(){
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Long id){
        return autorRepository.findById(id);
    }

    public boolean deletar(Long id){
        if (autorRepository.existsById(id)){
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}