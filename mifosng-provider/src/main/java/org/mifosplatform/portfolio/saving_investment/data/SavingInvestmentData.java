package org.mifosplatform.portfolio.saving_investment.data;

import java.util.List;

public class SavingInvestmentData implements Comparable<SavingInvestmentData> {

    final Long loan_id;
    final String name;
    final String accountno;
    final Long loanammount;
    final String productname;
    private final List<SavingInvestmentData> savingInvestmentData;

    public SavingInvestmentData(Long loan_id, String name, String accountno, Long loanammount, String productname,
            List<SavingInvestmentData> savingInvestmentData) {

        this.loan_id = loan_id;
        this.name = name;
        this.accountno = accountno;
        this.loanammount = loanammount;
        this.productname = productname;
        this.savingInvestmentData = savingInvestmentData;
    }

    
    public String getAccountno() {
        return this.accountno;
    }

    public Long getLoan_id() {
        return this.loan_id;
    }
    
    
    public String getProductname() {
        return this.productname;
    }

    public String getName() {
        return this.name;
    }

    public Long getLoanammount() {
        return this.loanammount;
    }

    
 

    @Override
    public int compareTo(SavingInvestmentData o) {
       
        return 0;
    }

    public List<SavingInvestmentData> getSavingInvestmentData() {
        return savingInvestmentData;
    }

    public static SavingInvestmentData instance(Long loan_id, String name, String accountno, Long loanammount, String productname, List<SavingInvestmentData> savingInvestmentData) {
       
        return new SavingInvestmentData(loan_id, accountno, name, loanammount, productname, savingInvestmentData);
    }

}
