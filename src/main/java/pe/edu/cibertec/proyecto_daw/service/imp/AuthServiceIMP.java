package pe.edu.cibertec.proyecto_daw.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_daw.dto.LoginRequestDTO;
import pe.edu.cibertec.proyecto_daw.service.AuthService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AuthServiceIMP implements AuthService {

    //Referencia al archivo
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] checkAlumno(LoginRequestDTO loginRequestDTO) throws IOException {
        String[] datosAlumno = null;
        //Localiza el archivo
        Resource resource = resourceLoader.getResource("classpath:integrantes.txt");
        //Recupera el archivo y lee
        /*try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
            String line;
            //Mientras se lea una línea
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                //
                if(loginRequestDTO.codeAlumno().equals(datos[0]) && loginRequestDTO.passAlumno().equals(datos[1])){
                    //Inicializar array
                    datosAlumno = new String[3];
                    datosAlumno[0] = datos[0];
                    datosAlumno[1] = datos[1];
                    datosAlumno[2] = datos[2];
                    break;
                }
            }
            */
        // Recupera el archivo y lee
        //InputStream permite leer archivos desde diferentes ubicaciones, incluidas aquellas que están dentro de un archivo JAR empaquetado
        try (InputStream is = resource.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            // Mientras se lea una línea
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                System.out.println("Leyendo datos: " + Arrays.toString(datos)); // Imprimir datos leídos
                if (loginRequestDTO.codeAlumno().equals(datos[0]) && loginRequestDTO.passAlumno().equals(datos[1])) {
                    // Inicializar array
                    datosAlumno = new String[3];
                    datosAlumno[0] = datos[0];
                    datosAlumno[1] = datos[1];
                    datosAlumno[2] = datos[2];
                    break;
                }
            }
        }catch (IOException e){
            datosAlumno = null;
            throw new IOException(e);
        }
        //Retornamos los datos que se almacenan en el array
        return datosAlumno;
    }

    @Override
    public ArrayList<String> listarAlumnos() throws IOException {
        String[] datosAlumno = null;
        ArrayList<String> grupo = new ArrayList<String>();
        Resource resource = resourceLoader.getResource("classpath:integrantes.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
            String line;

            while ((line = br.readLine()) != null) {
                String[] nombres = line.split(";");
                grupo.add(nombres[2] + " " + nombres[3]);
            }
            System.out.println(grupo.toString());
        }catch (IOException e){
            grupo = null;
            throw new IOException(e);
        }
        return grupo;
    }


}
