package SMWU.NaesoneulJAVA.NidonNaedon.repositories;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureDetailsRepository extends JpaRepository<ExpenditureDetails, Long> {
    List<ExpenditureDetails> findByAccountId(Long accountId);  // String에서 Long으로 변경
}
