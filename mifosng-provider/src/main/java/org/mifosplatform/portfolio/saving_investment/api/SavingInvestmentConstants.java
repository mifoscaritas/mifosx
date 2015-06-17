package org.mifosplatform.portfolio.saving_investment.api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class SavingInvestmentConstants {
    
    public static final String savingIdParamName = "savingId";
    public static final String loanIdParamName = "loanId";
    public static final String SAVINGINVESTMENT_RESOURCE_NAME = "saving_investment";
    
    public static final Set<String> SAVINGINVESTMENT_CREATE_REQUEST_DATA_PARAMETERS = new HashSet<>(Arrays.asList(savingIdParamName,
            loanIdParamName));

}