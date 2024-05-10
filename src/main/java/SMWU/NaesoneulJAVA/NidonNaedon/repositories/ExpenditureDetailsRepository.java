package SMWU.NaesoneulJAVA.NidonNaedon.repositories;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenditureDetailsRepository extends JpaRepository<ExpenditureDetails, Long> {
    List<ExpenditureDetails> findByAccountId(String accountId);
}
