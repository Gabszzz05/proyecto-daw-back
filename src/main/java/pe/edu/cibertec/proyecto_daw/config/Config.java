package pe.edu.cibertec.proyecto_daw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Esto aplica CORS a todos los endpoints.
                .allowedOrigins("https://app-proyecto-frontend.azurewebsites.net")  // Permite solicitudes solo desde este dominio.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos.
                .allowCredentials(true);  // Permite enviar cookies en las solicitudes.
    }
}
