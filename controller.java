package com.example.day4.b;

import com.example.day4.model.Api;
import com.example.day4.model.emp;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class controller {
    ArrayList<emp> e=new ArrayList<emp>();
    @GetMapping("/user")

    public ArrayList<emp>getUsers(){

        return e;
    }

    @PostMapping("/add")
    public ResponseEntity addEmp(@RequestBody @Valid emp user, Errors error) {
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();//مهم من اجل الوصول لرسالة في User
            return ResponseEntity.status(400).body(message);
        }
        e.add(user);
        return  ResponseEntity.status(200).body(new Api("emp add"));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateEmp( @PathVariable int index,@RequestBody @Valid emp user,Errors error){
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();//مهم من اجل الوصول لرسالة في User
            return ResponseEntity.status(400).body(message);
        }
        e.set(index,user);
        return  ResponseEntity.status(200).body(new Api ("emp update"));
    }
    @DeleteMapping ("/{index}")
    public ResponseEntity deledtEmp(@PathVariable int index,Errors error){


        e.remove(index);
        return ResponseEntity.status(200).body(new Api ("emp deleted"));
    }
}
