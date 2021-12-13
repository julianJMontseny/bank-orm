package org.iesfm.bank.pojos;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    private String iban;
    @Column(name = "owner_id")
    private int ownerId;
    private double balance;
    @Column(name = "open_date")
    private Date openDate;

    //El OneToMany es para traer cosas desde otra tabla (en este caso, movimientos). Y es ahí cuando tenemos que enlazarlas a través del JoinColumn
    @OneToMany
    @JoinColumn(name = "iban" , referencedColumnName = "iban")
    private List<Movement> accountMovements;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return ownerId == account.ownerId && Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(openDate, account.openDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, ownerId, balance, openDate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", ownerId=" + ownerId +
                ", balance=" + balance +
                ", openDate=" + openDate +
                '}';
    }
}
