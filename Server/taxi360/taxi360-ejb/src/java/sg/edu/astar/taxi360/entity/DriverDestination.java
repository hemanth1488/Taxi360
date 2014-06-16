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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hemanth 
 */
@Entity
@Table(name = "driver_Destination")
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "DriverDestinations.findAll", query = "SELECT d FROM DriverDestination d"),
//    @NamedQuery(name = "DriverDestinations.findById", query = "SELECT d FROM DriverDestination d WHERE d.id = :id"),
//    @NamedQuery(name = "DriverDestinations.findByCreatetime", query = "SELECT d FROM DriverDestination d WHERE d.createtime = :createtime"),
//    @NamedQuery(name = "DriverDestinations.findByLatitude", query = "SELECT d FROM DriverDestination d WHERE d.location.latitude = :latitude"),
//    @NamedQuery(name = "DriverDestinations.findByLongitude", query = "SELECT d FROM DriverDestination d WHERE d.location.longitude = :longitude"),
//    @NamedQuery(name = "DriverDestinations.findByLocationAddress", query = "SELECT d FROM DriverDestination d WHERE d.locationAddress = :locationAddress"),
    @NamedQuery(name = "DriverDestination.findByDriverId", query = "SELECT d FROM DriverDestination d WHERE d.driverid = :driverid")})
public class DriverDestination implements Serializable {
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
    @JoinColumn(name = "driverid", referencedColumnName = "driverid")
    //@ManyToOne(optional = false,fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driverid;
    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name="latitude", column=@Column(name="latitude")),
    @AttributeOverride(name="longitude", column=@Column(name="longitude"))})
    private Location location;

    public DriverDestination() {
    }

    public DriverDestination(Long id) {
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

    public Driver getDriverid() {
        return driverid;
    }

    public void setDriverid(Driver driverid) {
        this.driverid = driverid;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
        if (!(object instanceof DriverDestination)) {
            return false;
        }
        DriverDestination other = (DriverDestination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmp.entity.DriverDestinations[ id=" + id + " ]";
    }
    
}
