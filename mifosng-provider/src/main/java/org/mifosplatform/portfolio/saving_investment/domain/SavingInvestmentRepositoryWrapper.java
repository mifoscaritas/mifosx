package org.mifosplatform.portfolio.saving_investment.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingInvestmentRepositoryWrapper {

    private final SavingInvestmentRepository repository;

    @Autowired
    public SavingInvestmentRepositoryWrapper(SavingInvestmentRepository repository) {
        super();
        this.repository = repository;
    }
    
    public void save(final SavingInvestment saving) {
        this.repository.save(saving);
    }

    public void saveAndFlush(final SavingInvestment saving) {
        this.repository.saveAndFlush(saving);
    }

    public void delete(final SavingInvestment saving) {
        this.repository.delete(saving);
    }

   public SavingInvestment findWithNotFoundDetection(final Long id){
       final SavingInvestment savingInvestment = this.repository.findOne(id);
       return savingInvestment;
       
   }
}
