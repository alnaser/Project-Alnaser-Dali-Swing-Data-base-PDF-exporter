/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.product.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "produit", catalog = "gestion_produit", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p WHERE p.id = :id"),
    @NamedQuery(name = "Produit.findByCodeProduit", query = "SELECT p FROM Produit p WHERE p.codeProduit = :codeProduit"),
    @NamedQuery(name = "Produit.findByReference", query = "SELECT p FROM Produit p WHERE p.reference = :reference"),
    @NamedQuery(name = "Produit.findByDeseignation", query = "SELECT p FROM Produit p WHERE p.deseignation = :deseignation"),
    @NamedQuery(name = "Produit.findByRangement", query = "SELECT p FROM Produit p WHERE p.rangement = :rangement"),
    @NamedQuery(name = "Produit.findByFournisseur", query = "SELECT p FROM Produit p WHERE p.fournisseur = :fournisseur"),
    @NamedQuery(name = "Produit.findByRemise", query = "SELECT p FROM Produit p WHERE p.remise = :remise"),
    @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix"),
    @NamedQuery(name = "Produit.findByStock", query = "SELECT p FROM Produit p WHERE p.stock = :stock")})
public class Produit implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code_produit")
    private String codeProduit;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "deseignation")
    private String deseignation;
    @Column(name = "rangement")
    private String rangement;
    @Column(name = "fournisseur")
    private String fournisseur;
    @Basic(optional = false)
    @Column(name = "remise")
    private int remise;
    @Basic(optional = false)
    @Column(name = "prix")
    private int prix;
    @Column(name = "stock")
    private Integer stock;

    public Produit() {
    }

    public Produit(Integer id) {
        this.id = id;
    }

    public Produit(Integer id, String codeProduit, String reference, String deseignation, int remise, int prix) {
        this.id = id;
        this.codeProduit = codeProduit;
        this.reference = reference;
        this.deseignation = deseignation;
        this.remise = remise;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        String oldCodeProduit = this.codeProduit;
        this.codeProduit = codeProduit;
        changeSupport.firePropertyChange("codeProduit", oldCodeProduit, codeProduit);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        String oldReference = this.reference;
        this.reference = reference;
        changeSupport.firePropertyChange("reference", oldReference, reference);
    }

    public String getDeseignation() {
        return deseignation;
    }

    public void setDeseignation(String deseignation) {
        String oldDeseignation = this.deseignation;
        this.deseignation = deseignation;
        changeSupport.firePropertyChange("deseignation", oldDeseignation, deseignation);
    }

    public String getRangement() {
        return rangement;
    }

    public void setRangement(String rangement) {
        String oldRangement = this.rangement;
        this.rangement = rangement;
        changeSupport.firePropertyChange("rangement", oldRangement, rangement);
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        String oldFournisseur = this.fournisseur;
        this.fournisseur = fournisseur;
        changeSupport.firePropertyChange("fournisseur", oldFournisseur, fournisseur);
    }

    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) {
        int oldRemise = this.remise;
        this.remise = remise;
        changeSupport.firePropertyChange("remise", oldRemise, remise);
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        int oldPrix = this.prix;
        this.prix = prix;
        changeSupport.firePropertyChange("prix", oldPrix, prix);
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        Integer oldStock = this.stock;
        this.stock = stock;
        changeSupport.firePropertyChange("stock", oldStock, stock);
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.product.view.Produit[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
