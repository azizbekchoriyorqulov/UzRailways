package com.example.uzrailways.service;

import com.example.uzrailways.entity.Photo;
import com.example.uzrailways.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoService
{
    @Value("${uploadDir}")
    private String uploadDir;
    private final PhotoRepository photoRepository ;

    public Photo savePhotoToServer(MultipartFile multipartFilePhoto)
    {
        try
            {
                if (multipartFilePhoto != null)
                {
                    if ( !multipartFilePhoto.getContentType().equalsIgnoreCase("image/png")||
                         !multipartFilePhoto.getContentType().equalsIgnoreCase("image/jpeg") ) // Rasm neto formatda bo'lsa tekshrb olish kere
                    {
                        System.err.println("File type not png or jpeg");
                    }

                Photo photo = new Photo();
                photo.setFullName(multipartFilePhoto.getOriginalFilename());
                photo.setSize(multipartFilePhoto.getSize());
                photo.setPhotoType(multipartFilePhoto.getContentType());
                photo.setFileUrl(uploadDir + multipartFilePhoto.getOriginalFilename() );

                Photo savedPhoto = photoRepository.saveAndFlush(photo);// DB ga faqat rasm ma'lumotlari yozildi , rasmni o'zi emas
                savedPhoto.setHttpUrl("http://localhost:8080/kadr/image/"+savedPhoto.getId());
                photoRepository.saveAndFlush(savedPhoto);

                    // mana endi Serverga saqlash boshlandi....
                File directory = new File(uploadDir);
                if (!directory.exists())
                    directory.mkdirs();

                String originalFileName = multipartFilePhoto.getOriginalFilename();
                File destFile = new File(uploadDir + originalFileName);
                multipartFilePhoto.transferTo(destFile);
                return photo ;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String findFileUrlById(UUID uuid)
    {
         return  photoRepository.findFileUrlById(uuid).orElse(null);
    }

    public ResponseEntity<?> viewKadrPhoto(UUID photoId)
    {
        String fileUrlById = findFileUrlById(photoId);
        if (fileUrlById==null)
            throw new NullPointerException(photoId+" id'lik rasm topilmadi");
        try
        {
            Resource resource = new UrlResource(new File(fileUrlById).toURI());

            if (resource.exists() && resource.isReadable())
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
