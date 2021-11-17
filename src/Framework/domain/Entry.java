package Framework.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Entry {
    private BigDecimal amount;
    private String name;
    private Date date;

    public Entry(BigDecimal amount, String name, Date date) {
        this.amount = amount;
        this.name = name;
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
