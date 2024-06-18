package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.ExpenditureDetailsDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.services.ExpenditureDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/expenditures")
@Tag(name = "ExpenditureDetails", description = "지출 내역 관련 API")
public class ExpenditureDetailsController {

    private final ExpenditureDetailsService expenditureDetailsService;
    private static final Logger logger = Logger.getLogger(ExpenditureDetailsController.class.getName());

    @Autowired
    public ExpenditureDetailsController(ExpenditureDetailsService expenditureDetailsService) {
        this.expenditureDetailsService = expenditureDetailsService;
    }

    @GetMapping("/account/{accountId}")
    @Operation(summary = "지출 내역 조회", description = "주어진 계정 ID로 모든 지출 내역을 조회합니다.")
    public ResponseEntity<List<ExpenditureDetailsDTO>> getAllExpenditureDetailsByAccountId(@PathVariable("accountId") Long accountId) {  // String에서 Long으로 변경
        List<ExpenditureDetailsDTO> expenditureDetails = expenditureDetailsService.getAllExpenditureDetailsByAccountId(accountId);
        return new ResponseEntity<>(expenditureDetails, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "지출 내역 생성", description = "새로운 지출 내역을 생성합니다.")
    public ResponseEntity<ExpenditureDetailsDTO> createExpenditure(@RequestBody ExpenditureDetailsDTO expenditureDetailsDTO) {
        logger.info("createExpenditure 호출: " + expenditureDetailsDTO);
        ExpenditureDetailsDTO newExpenditureDetailsDTO = expenditureDetailsService.createExpenditure(expenditureDetailsDTO);
        return new ResponseEntity<>(newExpenditureDetailsDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "지출 내역 수정", description = "주어진 ID로 지출 내역을 수정합니다.")
    public ResponseEntity<ExpenditureDetailsDTO> updateExpenditure(@PathVariable("id") Long id, @RequestBody ExpenditureDetailsDTO expenditureDetailsDTO) {
        ExpenditureDetailsDTO updatedExpenditureDetailsDTO = expenditureDetailsService.updateExpenditure(id, expenditureDetailsDTO);
        if (updatedExpenditureDetailsDTO != null) {
            return new ResponseEntity<>(updatedExpenditureDetailsDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "지출 내역 삭제", description = "주어진 ID로 지출 내역을 삭제합니다.")
    public ResponseEntity<Void> deleteExpenditure(@PathVariable("id") Long id) {
        boolean isDeleted = expenditureDetailsService.deleteExpenditure(id);
        return new ResponseEntity<>(isDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
