package com.example.photoapi;

import com.example.photoapi.PhotoUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoUrlRepository extends JpaRepository<PhotoUrl, Long> {
}
