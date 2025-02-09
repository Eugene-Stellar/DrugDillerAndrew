package com.example.photoapi;

import com.example.photoapi.PhotoUrl;
import com.example.photoapi.PhotoUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PhotoUrlService {

  @Autowired
  private PhotoUrlRepository photoUrlRepository;

  private String lastReturnedUrl; // Хранит последнюю возвращённую ссылку

  public String getRandomPhotoUrl() {
    List<PhotoUrl> photos = photoUrlRepository.findAll();
    if (photos.isEmpty()) {
      throw new IllegalStateException("No photos found in the database.");
    }

    Random random = new Random();
    String newUrl;

    // Генерируем новый URL, который не равен предыдущему
    do {
      int index = random.nextInt(photos.size());
      newUrl = photos.get(index).getUrl();
    } while (photos.size() > 1 && newUrl.equals(lastReturnedUrl));

    // Сохраняем текущий URL как последний
    lastReturnedUrl = newUrl;

    return newUrl;
  }
}
