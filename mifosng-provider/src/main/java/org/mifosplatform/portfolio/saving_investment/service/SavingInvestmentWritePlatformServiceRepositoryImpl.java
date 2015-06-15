package org.mifosplatform.portfolio.saving_investment.service;

import java.util.ArrayList;
import java.util.List;

import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResultBuilder;
import org.mifosplatform.infrastructure.security.service.PlatformSecurityContext;
import org.mifosplatform.portfolio.loanaccount.domain.LoanRepositoryWrapper;
import org.mifosplatform.portfolio.saving_investment.domain.SavingInvestment;
import org.mifosplatform.portfolio.saving_investment.domain.SavingInvestmentRepositoryWrapper;
import org.mifosplatform.portfolio.savings.domain.SavingsAccountRepository;
import org.mifosplatform.portfolio.savings.domain.SavingsAccountRepositoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingInvestmentWritePlatformServiceRepositoryImpl implements SavingInvestmentWritePlatformService {

    private final PlatformSecurityContext context;
    private final SavingInvestmentRepositoryWrapper repositoryWrapper;
    private final SavingsAccountRepositoryWrapper savingsaccount;
    private final SavingsAccountRepository savingAccount;
    private final LoanRepositoryWrapper loanRepository;
    private final SavingInvestmentReadPlatformService savingInvestment;

    @Autowired
    public SavingInvestmentWritePlatformServiceRepositoryImpl(PlatformSecurityContext context,
            SavingInvestmentRepositoryWrapper repositoryWrapper, SavingsAccountRepositoryWrapper savingsaccount,
            LoanRepositoryWrapper loanRepository, SavingsAccountRepository savingAccount,
            SavingInvestmentReadPlatformService savingInvestment) {

        this.context = context;
        this.repositoryWrapper = repositoryWrapper;
        this.loanRepository = loanRepository;
        this.savingsaccount = savingsaccount;
        this.savingAccount = savingAccount;
        this.savingInvestment = savingInvestment;
    }

    @Override
    public CommandProcessingResult addSavingsInvestment(Long savingsId, JsonCommand command) {
        // TODO Auto-generated method stub

        // final AppUser user = this.context.authenticatedUser();

        final Long savingId = command.longValueOfParameterNamed("savingId");
        final String[] loanIds = command.arrayValueOfParameterNamed("loanId");
        final List<Long> loanId = new ArrayList<Long>();
        List<Long> existingLoanIds = new ArrayList<Long>();
        List<Long> newLoanIds = new ArrayList<Long>();

        Long id = null;

        if (loanIds != null) {
            for (String Id : loanIds) {
                id = Long.parseLong(Id);
                loanId.add(id);
            }
        }

        existingLoanIds = this.savingInvestment.retriveLoanIdBySavingId(savingId);

        if (existingLoanIds.isEmpty()) {
            newLoanIds = loanId;

        }

        else {
            for (int i = 0; i < loanId.size(); i++) {
                int count = 0;
                for (int j = 0; j < existingLoanIds.size(); j++) {
                    if (loanId.get(i).equals(existingLoanIds.get(j))) {
                        //
                        count++;
                    }
                }

                if (count == 0) {
                    newLoanIds.add(loanId.get(i));
                }

            }
        }

        for (int i = 0; i < newLoanIds.size(); i++) {

            SavingInvestment savingInvestment = new SavingInvestment(savingId, newLoanIds.get(i));
            this.repositoryWrapper.save(savingInvestment);

        }

        return new CommandProcessingResultBuilder().build();
    }

    @Override
    public CommandProcessingResult deleteInvestmentBasedOnMapping(Long savingId, Long loanId) {
        // TODO Auto-generated method stub
        return null;
    }

}
