package com.example.demo.control;

import java.util.List;

import com.example.demo.services.user_s;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/users")
public class user {
    @Autowired
    private user_s users;
    @GetMapping("/")
    public ResponseEntity<List<com.example.demo.dto.user>> findAll(){
        List<com.example.demo.dto.user> list = users.getAllElements();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<com.example.demo.dto.user> findById(@PathVariable String id){
        com.example.demo.dto.user usuario = users.getById(id);
        return ResponseEntity.ok(usuario);
    }
    @PostMapping("/")
    public ResponseEntity<com.example.demo.dto.user> save(@RequestBody com.example.demo.dto.user user){
        com.example.demo.dto.user saved = users.save(user);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<com.example.demo.dto.user> update(@RequestBody com.example.demo.dto.user user, @PathVariable String id){
        com.example.demo.dto.user update = users.update(user, id);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        users.delete(id);
        return ResponseEntity.noContent().build();
    }
}