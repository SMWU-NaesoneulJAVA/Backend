package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.services.ProportionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/proportion")
@Tag(name = "Proportion", description = "사용 비율 관련 API")
public class ProportionController {

    @Autowired
    private ProportionService proportionService;

    @GetMapping("/account/{accountId}")
    @Operation(summary = "사용 비율 조회", description = "주어진 계정 ID로 사용 비율을 조회합니다.")
    public ResponseEntity<Map<String, Double>> getProportionByAccountId(@PathVariable("accountId") String accountId) {
        try {
            Map<String, Double> proportions = proportionService.calculateProportion(accountId);
            return new ResponseEntity<>(proportions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
