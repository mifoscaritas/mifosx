package org.mifosplatform.portfolio.investment.data;


public class LoanInvestmentData {
    
    final Long saving_id;
    final String name;
    final String accountno;
    final Long savingamount;
    final String productname;
    public LoanInvestmentData(Long saving_id, String name, String accountno, Long savingamount, String productname) {
        super();
        this.saving_id = saving_id;
        this.name = name;
        this.accountno = accountno;
        this.savingamount = savingamount;
        this.productname = productname;
    }
    
    public Long getSaving_id() {
        return this.saving_id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAccountno() {
        return this.accountno;
    }
    
    public Long getSavingamount() {
        return this.savingamount;
    }
    
    public String getProductname() {
        return this.productname;
    }
   
    public static LoanInvestmentData intance (Long saving_id, String name, String accountno, Long savingamount,
            String productname){
        return new LoanInvestmentData(saving_id, name, accountno, savingamount, productname);
    }
}
