package org.mifosplatform.portfolio.saving_investment.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.mifosplatform.portfolio.saving_investment.data.SavingInvestmentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table (name = "m_saving_investment")
public class SavingInvestment extends AbstractPersistable<Long> {

    
    @Column(name = "saving_id", nullable =false)
    private Long savingId;
    
    @Column(name =" loan_id ", nullable=false)
    private Long loan_id;
    
  /*  @OneToMany()
    @JoinColumn(name = "loan_id")*/
//    List<SavingInvestmentData> savingInvestmentData;
    
    protected SavingInvestment(){
        //
    }
    
    @Autowired
    public SavingInvestment(Long savingId, Long loan_id) {
       // super();
        this.savingId = savingId;
        this.loan_id = loan_id;
      //  this.savingInvestmentData = savingInvestmentData;
    }

    public Long getSavingId() {
        return this.savingId;
    }

    
    public void setSavingId(Long savingId) {
        this.savingId = savingId;
    }

    
    public Long getLoan_id() {
        return this.loan_id;
    }

    
    public void setLoan_id(Long loan_id) {
        this.loan_id = loan_id;
    }

    
   /* public List<SavingInvestmentData> getSavingInvestmentData() {
        return this.savingInvestmentData;
    }

    
    public void setSavingInvestmentData(List<SavingInvestmentData> savingInvestmentData) {
        this.savingInvestmentData = savingInvestmentData;
    }*/
    

    
}
