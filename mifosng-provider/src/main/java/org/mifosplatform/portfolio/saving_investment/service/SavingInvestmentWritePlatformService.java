package org.mifosplatform.portfolio.saving_investment.service;

import java.sql.SQLException;

import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;


public interface SavingInvestmentWritePlatformService {

    
    CommandProcessingResult addSavingsInvestment(Long savingsId, JsonCommand command);
    CommandProcessingResult deleteInvestmentBasedOnMapping(Long savingId, Long loanId);
    
}
