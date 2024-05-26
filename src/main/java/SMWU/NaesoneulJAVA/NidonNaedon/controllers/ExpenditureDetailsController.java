package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ExpenditureDetailsController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/expenditures/{id}/upload")
    public ResponseEntity<?> uploadPhoto(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        try {
            // 업로드 디렉토리 확인 및 생성
            File uploadDirectory = new File(uploadDir);
            if (!uploadDirectory.exists()) {
                uploadDirectory.mkdirs();
            }

            // 파일 이름 정리
            String originalFileName = file.getOriginalFilename();
            String cleanFileName = originalFileName.replaceAll("[^a-zA-Z0-9.-]", "_");
            File destinationFile = new File(uploadDir, cleanFileName);

            // 파일 저장
            file.transferTo(destinationFile);

            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        }
    }
}
