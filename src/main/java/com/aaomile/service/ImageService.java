package com.aaomile.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadImage(MultipartFile eventBanner,String bannerName);

    String getURLFromPublicID(String publicId);

}
