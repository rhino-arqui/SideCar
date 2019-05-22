/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author johan-smc
 */
@Entity
@Table(name = "CLIENT")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password")
    , @NamedQuery(name = "Client.findByUsername", query = "SELECT c FROM Client c WHERE c.username = :username")
    , @NamedQuery(name = "Client.findByGivenName", query = "SELECT c FROM Client c WHERE c.givenName = :givenName")
    , @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email")
    , @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "GIVEN_NAME")
    private String givenName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @JoinTable(name = "VISITING_LIST", joinColumns = {
        @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PROPERTY_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Property> propertyCollection;
    @OneToMany(mappedBy = "clientId")
    private Collection<Property> propertyCollection1;

    public Client() {
    }

    public Client(String id) {
        this.id = id;
    }

    public Client(String id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Property> getPropertyCollection() {
        return propertyCollection;
    }

    public void setPropertyCollection(Collection<Property> propertyCollection) {
        this.propertyCollection = propertyCollection;
    }

    public Collection<Property> getPropertyCollection1() {
        return propertyCollection1;
    }

    public void setPropertyCollection1(Collection<Property> propertyCollection1) {
        this.propertyCollection1 = propertyCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Client[ id=" + id + " ]";
    }
    
}
