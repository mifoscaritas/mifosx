package org.mifosplatform.portfolio.saving_investment.handler;

import org.mifosplatform.commands.annotation.CommandType;
import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.portfolio.saving_investment.service.SavingInvestmentWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@CommandType(entity = "SAVINGINVESTMENT", action = "DELETE")
public class DeleteSavingInvestmentCommandHandler implements NewCommandSourceHandler{

    private final SavingInvestmentWritePlatformService savingInvestmentWriteService;
  
    
    @Autowired
    public DeleteSavingInvestmentCommandHandler(SavingInvestmentWritePlatformService savingInvestmentWriteService) {
        super();
        // TODO Auto-generated constructor stub
        this.savingInvestmentWriteService = savingInvestmentWriteService;
    }




    @Transactional
    @Override
    public CommandProcessingResult processCommand(JsonCommand command) {
       return this.savingInvestmentWriteService.deleteInvestmentBasedOnMapping(command.getSavingsId(), command.getLoanId());
    }
    

}
