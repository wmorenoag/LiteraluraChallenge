package com.aluraLatam.literaluraChalllenge.service;

import com.aluraLatam.literaluraChalllenge.model.Autor;
import com.aluraLatam.literaluraChalllenge.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;
    public List<Autor> listarAutores(){
        return autorRepository.findAllconLibros();
    }
    public List<Autor> listarAutoresVivosEnAno(int ano){
        return autorRepository.findAutoresVivosEnAnoConLibros(ano);
    }
    public Autor crearAutor(Autor autor){
        return autorRepository.save(autor);
    }
    public Optional<Autor> obtenerAutorId(Long id){
        return autorRepository.findById(id);
    }
    public Optional<Autor> obtenerAutorNombre(String nombre){
        return autorRepository.findByNombre(nombre);
    }
    public Autor actualizarAutor(Long id, Autor autorDetalles){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no Encontrado"));
        autor.setNombre(autorDetalles.getNombre());
        autor.setAnoNacimiento(autorDetalles.getAnoNacimiento());
        autor.setAnoFallecimiento(autorDetalles.getAnoFallecimiento());
        return autorRepository.save(autor);
    }
    public void eliminarAutor(Long id){
        autorRepository.deleteById(id);
    }
}
