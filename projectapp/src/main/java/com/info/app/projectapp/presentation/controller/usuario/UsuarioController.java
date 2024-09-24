package com.info.app.projectapp.presentation.controller.usuario;

import com.info.app.projectapp.presentation.dto.usuario.UsuarioDto;
import com.info.app.projectapp.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping("api/v1/usuario")
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioDto usuario) {
        UsuarioDto usuarioDto = usuarioService.createUsuario(usuario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioDto);
    }

}
