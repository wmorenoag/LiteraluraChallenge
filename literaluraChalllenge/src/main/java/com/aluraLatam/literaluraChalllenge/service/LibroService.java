package com.aluraLatam.literaluraChalllenge.service;

import com.aluraLatam.literaluraChalllenge.model.Libro;
import com.aluraLatam.literaluraChalllenge.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    public List<Libro> listarLibros(){
        return libroRepository.findAll();
    }
    public List<Libro> listarLibrosIdioma(String idioma){
        return libroRepository.findByIdioma(idioma);
    }
    public Libro crearLibro(Libro libro){
        return libroRepository.save(libro);
    }
    public Optional<Libro> obtenerLibroId(Long id){
        return libroRepository.findById(id);
    }
    public Optional<Libro> obtenerLibroTitulo(String titulo){
        return libroRepository.findByTituloIgnoreCase(titulo);
    }
    public Libro actualizarLibro(Long id, Libro libroDetalles){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libro.setTitulo(libroDetalles.getTitulo());
        libro.setIdioma(libroDetalles.getIdioma());
        libro.setNumeroDescargas(libroDetalles.getNumeroDescargas());
        libro.setAutor(libroDetalles.getAutor());
        return libroRepository.save(libro);
    }
    public void eliminarLibro(Long id){
        libroRepository.deleteById(id);
    }
}
