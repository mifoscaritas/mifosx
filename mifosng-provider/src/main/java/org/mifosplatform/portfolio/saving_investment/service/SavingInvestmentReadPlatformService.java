package org.mifosplatform.portfolio.saving_investment.service;

import java.sql.SQLException;
import java.util.List;

import org.mifosplatform.portfolio.saving_investment.data.SavingInvestmentData;


public interface SavingInvestmentReadPlatformService {

    List<SavingInvestmentData> retriveAccountsById(final Long savingId) throws SQLException;
    List<Long> retriveLoanIdBySavingId(final Long savingId);
    Long retriveInvestmentId(final Long savingId, Long loanId);
}
