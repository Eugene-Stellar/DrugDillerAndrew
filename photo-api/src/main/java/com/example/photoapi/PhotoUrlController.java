package com.example.photoapi;

import com.example.photoapi.PhotoUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // Разрешаем доступ для всех доменов
    registry.addMapping("/**") // Применить для всех эндпоинтов
        .allowedOrigins("*") // Разрешить доступ с любых доменов
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешенные методы
        .allowedHeaders("*") // Разрешить любые заголовки
        .exposedHeaders("Authorization"); // При необходимости, чтобы указать, что возвращаем в заголовках
  }
}

@RestController
public class PhotoUrlController {

  @Autowired
  private PhotoUrlService photoUrlService;

  @GetMapping("/photo")
  public String getRandomPhotoUrl(@RequestParam(required = false, defaultValue = "1") int number) {
    return photoUrlService.getRandomPhotoUrl();
  }
}