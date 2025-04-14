package com.hyodore.hyodorebackend.service;

import com.hyodore.hyodorebackend.entity.Photo;
import com.hyodore.hyodorebackend.repository.PhotoRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoService {

  private final PhotoRepository photoRepository;
  private final UserService userService;

  public List<Photo> findNewPhotosSince(String userId, LocalDateTime since) {
    String familyId = userService.getFamilyIdByUserId(userId);
    return photoRepository.findByFamilyIdAndDeletedFalseAndUploadedAtAfter(familyId, since);
  }

  public List<Photo> findDeletedPhotosSince(String userId, LocalDateTime since) {
    String familyId = userService.getFamilyIdByUserId(userId);
    return photoRepository.findByFamilyIdAndDeletedTrueAndDeletedAtAfter(familyId, since);
  }
}
