package com.example.photoapi;

import com.example.photoapi.PhotoUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoUrlController {

  @Autowired
  private PhotoUrlService photoUrlService;

  @GetMapping("/photo")
  public String getRandomPhotoUrl(@RequestParam(required = false, defaultValue = "1") int number) {
    return photoUrlService.getRandomPhotoUrl();
  }
}