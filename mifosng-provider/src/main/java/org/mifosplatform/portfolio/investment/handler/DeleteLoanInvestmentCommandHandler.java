package org.mifosplatform.portfolio.investment.handler;

import org.mifosplatform.commands.annotation.CommandType;
import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.portfolio.investment.service.InvestmentWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 @Service
 @CommandType(entity = "LOANINVESTMENT", action= "DELETE")
public class DeleteLoanInvestmentCommandHandler implements NewCommandSourceHandler  {
     
     private final InvestmentWritePlatformService loanInvestment;
    
     @Autowired
     public DeleteLoanInvestmentCommandHandler(InvestmentWritePlatformService loanInvestment) {
         super();
         this.loanInvestment = loanInvestment;
     }

    @Override
    public CommandProcessingResult processCommand(JsonCommand command) {
       
        return this.loanInvestment.deleteLoanInvestment(command.getLoanId(), command.getSavingsId());
    }

   

}
