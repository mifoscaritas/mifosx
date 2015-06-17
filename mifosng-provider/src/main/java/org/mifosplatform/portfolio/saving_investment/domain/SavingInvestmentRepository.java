package org.mifosplatform.portfolio.saving_investment.domain;

import org.mifosplatform.portfolio.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SavingInvestmentRepository extends JpaRepository<SavingInvestment, Long>, JpaSpecificationExecutor<SavingInvestment> {

    //
}
