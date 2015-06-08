package org.mifosplatform.portfolio.saving_investment.api;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.mifosplatform.infrastructure.core.api.ApiRequestParameterHelper;
import org.mifosplatform.infrastructure.core.serialization.ApiRequestJsonSerializationSettings;
import org.mifosplatform.infrastructure.core.serialization.DefaultToApiJsonSerializer;
import org.mifosplatform.infrastructure.security.service.PlatformSecurityContext;
import org.mifosplatform.portfolio.saving_investment.data.SavingInvestmentData;
import org.mifosplatform.portfolio.saving_investment.service.SavingInvestmentReadPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("/savingInvestment")
@Component
@Scope("singleton")
public class SavingInvestmentApiResource {
    private static final Set<String> RESPONSE_DATA_PARAMETERS = new HashSet<>(Arrays.asList("savingInvestment"));
    
    private final SavingInvestmentReadPlatformService savingInvestmentReadPlatformService;
    private final PlatformSecurityContext context;
    private final DefaultToApiJsonSerializer<SavingInvestmentData> apiJsonSerializerService;
    private final ApiRequestParameterHelper apiRequestParameterHelper;
    
    @Autowired
    public SavingInvestmentApiResource(SavingInvestmentReadPlatformService savingInvestmentReadPlatformService,
            PlatformSecurityContext context, DefaultToApiJsonSerializer<SavingInvestmentData> apiJsonSerializerService, 
            ApiRequestParameterHelper apiRequestParameterHelper) {
        this.savingInvestmentReadPlatformService = savingInvestmentReadPlatformService;
        this.context = context;
        this.apiJsonSerializerService = apiJsonSerializerService;
        this.apiRequestParameterHelper = apiRequestParameterHelper;
    }

    @GET
    @Path("{savingId}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public String retriveAccounts(@PathParam("savingId") final Long savingId, @Context final UriInfo uriInfo) throws SQLException{
      
     //   this.context.authenticatedUser().validateHasReadPermission(this.resourceNameForPermission);
        final ApiRequestJsonSerializationSettings settings = this.apiRequestParameterHelper.process(uriInfo.getQueryParameters());
        
       List<SavingInvestmentData> data = this.savingInvestmentReadPlatformService.retriveAccountsById(savingId);
        
        return this.apiJsonSerializerService.serialize(settings, data, RESPONSE_DATA_PARAMETERS);
    }

}
