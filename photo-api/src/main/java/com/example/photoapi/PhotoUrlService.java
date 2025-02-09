package com.example.photoapi;

import com.example.photoapi.PhotoUrl;
import com.example.photoapi.PhotoUrlRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
/*
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
}*/

@Service
public class PhotoUrlService {

  @Autowired
  private PhotoUrlRepository photoUrlRepository;

  private final Queue<String> lastReturnedUrls = new LinkedList<>(); // Очередь для хранения последних ссылок
  private final int historySize = 10; // Размер истории (можно изменить на 15 или другое значение)

  public String getRandomPhotoUrl() {
    List<PhotoUrl> photos = photoUrlRepository.findAll();
    if (photos.isEmpty()) {
      throw new IllegalStateException("No photos found in the database.");
    }

    // Получаем список всех URL-ов
    List<String> allUrls = photos.stream().map(PhotoUrl::getUrl).toList();
    String newUrl;

    Random random = new Random();
    do {
      int index = random.nextInt(allUrls.size());
      newUrl = allUrls.get(index);
    } while (allUrls.size() > historySize && lastReturnedUrls.contains(newUrl));

    // Обновляем историю последних ссылок
    lastReturnedUrls.add(newUrl);
    if (lastReturnedUrls.size() > historySize) {
      lastReturnedUrls.poll(); // Удаляем самую старую ссылку из истории
    }

    return newUrl;
  }
}

