package org.mifosplatform.portfolio.saving_investment.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mifosplatform.infrastructure.core.service.RoutingDataSource;
import org.mifosplatform.portfolio.saving_investment.data.SavingInvestmentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


@Service
public class SavingInvestmentReadPlatformServiceImpl implements SavingInvestmentReadPlatformService {

    private final JdbcTemplate jdbcTemplate;
    public static RoutingDataSource dataSource;

    @Autowired
    public SavingInvestmentReadPlatformServiceImpl(RoutingDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

   
    @Override
    public List<SavingInvestmentData> retriveAccountsById(Long savingId) throws SQLException {
        
       
            final SavingInvestmentDataMapper mapper = new SavingInvestmentDataMapper();
            final String schema = " select " + mapper.savingAccountsSchema() + " where ms.saving_id =" + savingId ;
            
            List<SavingInvestmentData> data = this.jdbcTemplate.query(schema, mapper);
            
            return data;
        
       }
       
    @Override
    public List<Long> retriveLoanIdBySavingId(Long savingId){

      final SavingInvestmentDataMapper mapp = new SavingInvestmentDataMapper();
      final String schema = "select ms.loan_id from m_saving_investment ms" + " where ms.saving_id = " + savingId;
      
      List<Long> data = this.jdbcTemplate.queryForList(schema, null, Long.class);
       return data;
    }

    
    private static final class SavingInvestmentDataMapper implements RowMapper<SavingInvestmentData>{

        public String savingAccountsSchema(){
            return "ml.id as loan_id, ml.account_no as accountno, cl.display_name as name, ml.principal_amount as loanammount, mpl.name as productname"
                    +" from m_saving_investment ms " 
                    + " left join m_loan ml on ms.loan_id = ml.id left join m_client cl on ml.client_id = cl.id left join m_product_loan mpl on ml.product_id = mpl.id ";            
        }
     
        public String loanAccountSchema(){
            return "ms.loan_id from m_saving_investment ms";
        }

        @Override
        public SavingInvestmentData mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            final Long loan_id = rs.getLong("loan_id");
            final String accountno = rs.getString("accountno");
            final String name = rs.getString("name");
            final Long loanammount = rs.getLong("loanammount");
            final String productname = rs.getString("productname");
            
            List<SavingInvestmentData> savingInvestmentData = null;
            final SavingInvestmentData data = SavingInvestmentData.instance(loan_id, accountno, name, loanammount, productname, null, null);
            // TODO Auto-generated method stub
            return data;
        }
        
    }

   
}
