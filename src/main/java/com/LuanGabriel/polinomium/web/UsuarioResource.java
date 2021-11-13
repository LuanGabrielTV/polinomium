package com.LuanGabriel.polinomium.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.LuanGabriel.polinomium.domain.Usuario;
import com.LuanGabriel.polinomium.service.UsuarioService;

import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path="/usuarios")

public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping(value="/criar/{nome}")
    public String helloApp(@PathVariable String nome){
        Usuario user = new Usuario();
        user.setNome(nome);
        usuarioService.save(user);
        return user.getNome() + " criado!";
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Usuario> getPessoa(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.findOne(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok().body(usuario.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value="/")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> lista = usuarioService.findAllList();
        if(lista.size()>0){
            return ResponseEntity.ok().body(lista);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> createPessoa(@RequestBody Usuario user) throws URISyntaxException{
        Long id = user.getId();
        if(id != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Um novo usuário não pode ter um ID");
        }
        Usuario usuario = usuarioService.save(user);
        return ResponseEntity.created(new URI("/api/usuarios" + usuario.getId())).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.findOne(id);
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario user) throws URISyntaxException{
        if(user.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user null id");
        }

        Usuario usuario = usuarioService.save(user);
        return ResponseEntity.ok().body(usuario);
    }
    
}