package com.aaomile.service.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aaomile.helper.AppConstansts;
import com.aaomile.service.ImageService;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ImageServiceImpl implements ImageService {

    private Cloudinary cloudinary;
    
    public ImageServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }



    @Override
    public String uploadImage(MultipartFile eventBanner,String bannerName) {
        
        //program to upload image to cloudinary

        
        try {
            byte[] data = new byte[eventBanner.getInputStream().available()];
            eventBanner.getInputStream().read(data);
            cloudinary.uploader().upload(data, ObjectUtils.asMap(
                "public_id",bannerName));
                return this.getURLFromPublicID(bannerName);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        //return url of image
        
    }



    @Override
    public String getURLFromPublicID(String publicId) {

        return cloudinary
        .url()
        .transformation(new Transformation<>()
            .width(AppConstansts.EVENT_BANNER_WIDTH)
            .height(AppConstansts.EVENT_BANNER_HEIGHT)
            .crop(AppConstansts.EVENT_BANNER_CROP))
        .generate(publicId);
    }

}
