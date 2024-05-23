package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.services.ExpenditureDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
