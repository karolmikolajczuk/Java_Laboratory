package devices;

import com.karolmikolajczuk.Human;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Human seller;
    private Human buyer;
    private BigDecimal amount;
    private Date date_of_transaction;

    public Transaction(Human seller, Human buyer, BigDecimal amount, Date date_of_transaction) {
        this.seller = seller;
        this.buyer = buyer;
        this.amount = amount;
        this.date_of_transaction = date_of_transaction;
    }

    public Human getSeller() {
        return seller;
    }

    public Human getBuyer() {
        return buyer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate_of_transaction() {
        return date_of_transaction;
    }
}
