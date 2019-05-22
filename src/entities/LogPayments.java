/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author johan-smc
 */
@Entity
@Table(name = "LOG_PAYMENTS")
@NamedQueries({
    @NamedQuery(name = "LogPayments.findAll", query = "SELECT l FROM LogPayments l")
    , @NamedQuery(name = "LogPayments.findByTransactionId", query = "SELECT l FROM LogPayments l WHERE l.transactionId = :transactionId")
    , @NamedQuery(name = "LogPayments.findByRentValue", query = "SELECT l FROM LogPayments l WHERE l.rentValue = :rentValue")})
public class LogPayments implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TRANSACTION_ID")
    private BigDecimal transactionId;
    @Basic(optional = false)
    @Column(name = "RENT_VALUE")
    private BigDecimal rentValue;
    @JoinColumn(name = "RENT_RECORD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RentRecord rentRecordId;

    public LogPayments() {
    }

    public LogPayments(BigDecimal transactionId) {
        this.transactionId = transactionId;
    }

    public LogPayments(BigDecimal transactionId, BigDecimal rentValue) {
        this.transactionId = transactionId;
        this.rentValue = rentValue;
    }

    public BigDecimal getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigDecimal transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getRentValue() {
        return rentValue;
    }

    public void setRentValue(BigDecimal rentValue) {
        this.rentValue = rentValue;
    }

    public RentRecord getRentRecordId() {
        return rentRecordId;
    }

    public void setRentRecordId(RentRecord rentRecordId) {
        this.rentRecordId = rentRecordId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogPayments)) {
            return false;
        }
        LogPayments other = (LogPayments) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LogPayments[ transactionId=" + transactionId + " ]";
    }
    
}
