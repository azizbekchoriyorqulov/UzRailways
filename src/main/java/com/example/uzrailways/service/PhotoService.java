package com.example.uzrailways.service;

import com.example.uzrailways.entity.Photo;
import com.example.uzrailways.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoService
{
    private final PhotoRepository photoRepository ;
    public Photo savePhotoToServer(MultipartFile multipartFilePhoto)
    {
        try
        {
            if (multipartFilePhoto != null)
            {
                String uploadDir = "C:\\Users\\SuperHuma\\IdeaProjects\\UzRailways\\src\\main\\resources\\photos\\"; // Rasm qaysi path da turishi

                    if ( !multipartFilePhoto.getContentType().equalsIgnoreCase("image/png")||
                         !multipartFilePhoto.getContentType().equalsIgnoreCase("image/jpeg") ) // Rasm neto formatda bo'lsa tekshrb olish kere
                    {
                        System.err.println("FILE RASM EMAS CHOTA ....");
                    }

                Photo photo = new Photo();
                photo.setFullName(multipartFilePhoto.getOriginalFilename());
                photo.setSize(multipartFilePhoto.getSize());
                photo.setPhotoType(multipartFilePhoto.getContentType());
                photo.setFileUrl(uploadDir + multipartFilePhoto.getOriginalFilename() );
                photoRepository.saveAndFlush(photo);  // DB ga faqat rasm ma'lumotlari yozildi , rasmni o'zi emas

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
            e.printStackTrace();
        }
        return null;
    }

    public String findFileUrlById(UUID uuid)
    {
         return  photoRepository.findFileUrlById(uuid).orElse(null);
    }

}
