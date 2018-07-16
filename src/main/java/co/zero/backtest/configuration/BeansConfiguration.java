package co.zero.backtest.configuration;

import co.zero.backtest.dto.TransactionDTO;
import co.zero.backtest.model.Transaction;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public MapperFacade getTransactionMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(TransactionDTO.class, Transaction.class)
            .field("thisAccount.id", "accountId")
            .field("otherAccount.number", "counterpartyAccount")
            .field("otherAccount.holder.name", "counterpartyName")
            .field("otherAccount.metadata.imageURL", "counterpartyLogoPath")
            .field("details.value.amount", "instructedAmount")
            .field("details.value.currency", "instructedCurrency")
            .field("details.value.amount", "transactionAmount")
            .field("details.value.currency", "transactionCurrency")
            .field("details.type", "transactionType")
            .field("details.description", "description")
            .byDefault()
            .register();
        return mapperFactory.getMapperFacade();

    }
}
