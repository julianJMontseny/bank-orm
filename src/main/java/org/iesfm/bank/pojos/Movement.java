package org.iesfm.bank.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Movement {

    @Id
    @GeneratedValue
    private int id;
    private int iban;
    @Column(name = "movement_date")
    private Date movementDate;
    private double amount;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIban() {
        return iban;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public Date getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return id == movement.id && iban == movement.iban && Double.compare(movement.amount, amount) == 0 && Objects.equals(movementDate, movement.movementDate) && Objects.equals(description, movement.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, movementDate, amount, description);
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", iban=" + iban +
                ", movementDate=" + movementDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
