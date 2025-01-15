package com.aaomile.service.impl;

// import java.io.IOException;
// import org.springframework.stereotype.Service;
// import org.springframework.util.ObjectUtils;
// import org.springframework.web.multipart.MultipartFile;
// import com.aaomile.helper.AppConstansts;
// import com.aaomile.service.ImageService;
// import com.cloudinary.Cloudinary;
// import com.cloudinary.Transformation;
// import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
// import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
// import com.aaomile.helper.AppConstansts;
import com.aaomile.service.ImageService;
// import com.cloudinary.Cloudinary;
// import com.cloudinary.Transformation;
// import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
// import java.io.File;
import java.nio.file.Path;


//This service is modified inorder to upload a link to the database but save the event with name cahanged according to the event name

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String uploadImage(MultipartFile eventBanner, String bannerName) {
        try {
            // Ensure the directory exists
            Path directory = Paths.get(uploadDir);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Validate the file
            if (eventBanner.isEmpty()) {
                throw new IllegalArgumentException("Uploaded file is empty.");
            }

            // Sanitize the banner name
            bannerName = bannerName.replaceAll("[^a-zA-Z0-9-_]", "_");
            String extension = getFileExtension(eventBanner.getOriginalFilename());
            String newFileName = bannerName.replaceAll("\\s+", "_") + extension;

            // Save the file
            Path filePath = directory.resolve(newFileName);
            eventBanner.transferTo(filePath.toFile());
            System.out.println("Saving file to: " + filePath.toAbsolutePath());

            // Return the relative path
            return "/images/uploads/eventBanner/" + newFileName;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload image: " + e.getMessage(), e);
        }
    }

    private String getFileExtension(String originalFilename) {
        int dotIndex = originalFilename.lastIndexOf('.');
        return (dotIndex > 0) ? originalFilename.substring(dotIndex) : "";
    }

    @Override
    public String getURLFromPublicID(String publicId) {
        return null;
    }
}
// @Service
// public class ImageServiceImpl implements ImageService {
//
//     private Cloudinary cloudinary;
//
//     public ImageServiceImpl(Cloudinary cloudinary) {
//         this.cloudinary = cloudinary;
//     }
//
//     @Override
//     public String uploadImage(MultipartFile eventBanner,String bannerName) {
//         //program to upload image to cloudinary
//         try {
//             byte[] data = new byte[eventBanner.getInputStream().available()];
//             eventBanner.getInputStream().read(data);
//             cloudinary.uploader().upload(data, ObjectUtils.asMap(
//                 "public_id",bannerName));
//                 return this.getURLFromPublicID(bannerName);
//         } catch (IOException e) {
//             e.printStackTrace();
//             return null;
//         }
//         //return url of image
//     }
//
//     @Override
//     public String getURLFromPublicID(String publicId) {
//         return cloudinary
//         .url()
//         .transformation(new Transformation<>()
//             .width(AppConstansts.EVENT_BANNER_WIDTH)
//             .height(AppConstansts.EVENT_BANNER_HEIGHT)
//             .crop(AppConstansts.EVENT_BANNER_CROP))
//         .generate(publicId);
//     }
// }
