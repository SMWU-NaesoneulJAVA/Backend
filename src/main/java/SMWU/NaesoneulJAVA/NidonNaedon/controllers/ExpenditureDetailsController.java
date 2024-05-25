package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.services.ExpenditureDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/expenditures")
public class ExpenditureDetailsController {
    private final ExpenditureDetailsService expenditureDetailsService;

    @Autowired
    public ExpenditureDetailsController(ExpenditureDetailsService expenditureDetailsService) {
        this.expenditureDetailsService = expenditureDetailsService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<List<ExpenditureDetails>> getAllExpendituresByAccountId(@PathVariable("accountId") String accountId) {
        List<ExpenditureDetails> expenditureDetailsList = expenditureDetailsService.getAllExpenditureDetailsByAccountId(accountId);
        return new ResponseEntity<>(expenditureDetailsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExpenditureDetails> createExpenditure(@RequestBody ExpenditureDetails expenditureDetails) {
        ExpenditureDetails newExpenditureDetails = expenditureDetailsService.createExpenditure(expenditureDetails);
        return new ResponseEntity<>(newExpenditureDetails, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenditureDetails> updateExpenditure(@PathVariable("id") Long id, @RequestBody ExpenditureDetails expenditureDetails) {
        ExpenditureDetails updatedExpenditureDetails = expenditureDetailsService.updateExpenditure(id, expenditureDetails);
        if (updatedExpenditureDetails != null) {
            return new ResponseEntity<>(updatedExpenditureDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenditure(@PathVariable("id") Long id) {
        boolean isDeleted = expenditureDetailsService.deleteExpenditure(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadPhoto(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = "uploads/" + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);

            ExpenditureDetails expenditureDetails = expenditureDetailsService.getExpenditureById(id);
            if (expenditureDetails == null) {
                return new ResponseEntity<>("Expenditure not found", HttpStatus.NOT_FOUND);
            }
            expenditureDetails.setExpenditurePhoto(filePath);
            expenditureDetailsService.updateExpenditure(id, expenditureDetails);

            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("File upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
