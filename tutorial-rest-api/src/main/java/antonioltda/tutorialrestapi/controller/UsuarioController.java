package antonioltda.tutorialrestapi.controller;

import antonioltda.tutorialrestapi.model.UsuarioModel;
import antonioltda.tutorialrestapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(path = "/api/usuario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){

        return repository.findById(codigo)
                //Se ele retornou alguma coisa, vai dar "ok" para mim
                .map(record -> ResponseEntity.ok().body(record))
                //Caso contrario vai ser NotFound e vai me retornar o build
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping(path = "/api/usuario/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario){
        return repository.save(usuario);
    }
}
