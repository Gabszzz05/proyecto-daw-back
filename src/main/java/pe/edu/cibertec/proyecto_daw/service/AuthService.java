package pe.edu.cibertec.proyecto_daw.service;

import pe.edu.cibertec.proyecto_daw.dto.LoginRequestDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface AuthService {

    //Firma de los métodos
    String[] checkAlumno(LoginRequestDTO loginRequestDTO) throws IOException;

    ArrayList<String> listarAlumnos() throws IOException;

}
