package com.example.uzrailways.service;

import com.example.uzrailways.entity.Kadr;
import com.example.uzrailways.entity.WordDoc;
import com.example.uzrailways.service.KadrService.KadrService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WordDocService
{
    private final WordDocRepository wordDocRepository;
    private final KadrService kadrService ;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public WordDoc saveWordDocument(MultipartFile file , UUID kadrId) throws IOException {

        Path targetLocation = Paths.get(uploadDir).resolve(file.getOriginalFilename ());

        try (XWPFDocument document = new XWPFDocument(file.getInputStream()))
        {
            try (FileOutputStream fos = new FileOutputStream(targetLocation.toFile()))
            {
                document.write(fos);
            }
        }

        // WordDoc entity ni yaratib dbga saqlab olamiz
        WordDoc wordDoc = new WordDoc() ;
        wordDoc.setFullName(file.getOriginalFilename());
        wordDoc.setFileUrl(targetLocation.toString());
        wordDoc.setHttpUrl("http://localhost:8080/kadr/word/"+wordDoc.getId());
        wordDocRepository.save(wordDoc);

        // WordDoc entity dbga saqlab olindi , endi u documentni Kadr ga set qib qo'yish kerak.
        // Kadrni id'si orqali topib olamiz va wordDoc ni o'sha kadrga set qilamiz va kadrni DB ga qayta save qilish kerak chunki unga wordDoc set qildik
        Kadr kadr  = kadrService.findById(kadrId);
        kadr.setWordDoc(wordDoc);
        kadrService.save(kadr);

        return  wordDoc;
    }
}
