/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.astar.taxi360.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hemanth 
 */
@Entity
@Table(name = "passenger_Destination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PassengerDestination.findByPassengerId", query = "SELECT p FROM PassengerDestination p WHERE p.passengerid = :passengerid")})
//@NamedQueries({
//    @NamedQuery(name = "PassengerDestinations.findAll", query = "SELECT p FROM PassengerDestination p"),
//    @NamedQuery(name = "PassengerDestinations.findById", query = "SELECT p FROM PassengerDestination p WHERE p.id = :id"),
//    @NamedQuery(name = "PassengerDestinations.findByCreatetime", query = "SELECT p FROM PassengerDestination p WHERE p.createtime = :createtime"),
//    @NamedQuery(name = "PassengerDestinations.findByLatitude", query = "SELECT p FROM PassengerDestination p WHERE p.location.latitude = :latitude"),
//    @NamedQuery(name = "PassengerDestinations.findByLongitude", query = "SELECT p FROM PassengerDestination p WHERE p.location.longitude = :longitude"),
//    @NamedQuery(name = "PassengerDestinations.findByLocationAddress", query = "SELECT p FROM PassengerDestination p WHERE p.locationAddress = :locationAddress")})
public class PassengerDestination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "createtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @Column(name = "location_address")
    private String locationAddress;

    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name="latitude", column=@Column(name="latitude")),
    @AttributeOverride(name="longitude", column=@Column(name="longitude"))})
    private Location location;
    @JoinColumn(name = "passengerid", referencedColumnName = "passengerid")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Passenger passengerid;

    public PassengerDestination() {
    }

    public PassengerDestination(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }


    public Passenger getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(Passenger passengerid) {
        this.passengerid = passengerid;
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
        if (!(object instanceof PassengerDestination)) {
            return false;
        }
        PassengerDestination other = (PassengerDestination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmp.entity.PassengerDestinations[ id=" + id + " ]";
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
}
