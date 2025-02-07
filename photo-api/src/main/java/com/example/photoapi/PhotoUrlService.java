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

  public String getRandomPhotoUrl() {
    List<PhotoUrl> photos = photoUrlRepository.findAll();
    if (photos.isEmpty()) {
      throw new IllegalStateException("No photos found in the database.");
    }
    Random random = new Random();
    int index = random.nextInt(photos.size());  // гарантировано положительное число
    return photos.get(index).getUrl();
  }

}