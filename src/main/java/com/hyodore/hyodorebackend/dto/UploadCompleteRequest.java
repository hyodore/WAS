package com.hyodore.hyodorebackend.dto;

import java.util.List;
import lombok.Data;

@Data
public class UploadCompleteRequest {

  private String userId;
  private List<PhotoInfo> photos;
}