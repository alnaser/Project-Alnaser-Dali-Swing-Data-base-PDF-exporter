/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alnaser.view;

import com.alnaser.entity.Produit;
import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;

import javax.swing.JPanel;
import static org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.*;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import static org.jdesktop.beansbinding.Bindings.createAutoBinding;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.JTableBinding.ColumnBinding;
import static org.jdesktop.swingbinding.SwingBindings.createJTableBinding;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 *
 * @author User
 */
public class GestionProduit extends JPanel {

    private javax.swing.JTextField codeProduitField;
    private javax.swing.JLabel codeProduitLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField deseignationField;
    private javax.swing.JLabel deseignationLabel;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField fournisseurField;
    private javax.swing.JLabel fournisseurLabel;
    private java.util.List<com.alnaser.entity.Produit> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField prixField;
    private javax.swing.JLabel prixLabel;
    private javax.persistence.Query query;
    private javax.swing.JTextField referenceField;
    private javax.swing.JLabel referenceLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField remiseField;
    private javax.swing.JLabel remiseLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JTextField stockField;
    private javax.swing.JLabel stockLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;

    public GestionProduit() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("gestion_produit?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Produit p");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        codeProduitLabel = new javax.swing.JLabel();
        referenceLabel = new javax.swing.JLabel();
        deseignationLabel = new javax.swing.JLabel();
        fournisseurLabel = new javax.swing.JLabel();
        remiseLabel = new javax.swing.JLabel();
        prixLabel = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();
        codeProduitField = new javax.swing.JTextField();
        referenceField = new javax.swing.JTextField();
        deseignationField = new javax.swing.JTextField();
        fournisseurField = new javax.swing.JTextField();
        remiseField = new javax.swing.JTextField();
        prixField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        JTableBinding jTableBinding = createJTableBinding(READ_WRITE, list, masterTable);
        ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${codeProduit}"));
        columnBinding.setColumnName("Code Produit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${reference}"));
        columnBinding.setColumnName("Reference");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${deseignation}"));
        columnBinding.setColumnName("Deseignation");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${fournisseur}"));
        columnBinding.setColumnName("Fournisseur");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${remise}"));
        columnBinding.setColumnName("Remise");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${prix}"));
        columnBinding.setColumnName("Prix");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${stock}"));
        columnBinding.setColumnName("Stock");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);

        masterScrollPane.setViewportView(masterTable);

        codeProduitLabel.setText("Code Produit:");

        referenceLabel.setText("Reference:");

        deseignationLabel.setText("Deseignation:");

        fournisseurLabel.setText("Fournisseur:");

        remiseLabel.setText("Remise:");

        prixLabel.setText("Prix:");

        stockLabel.setText("Stock:");

        Binding binding = createAutoBinding(READ_WRITE, masterTable, ELProperty.create("${selectedElement.codeProduit}"), codeProduitField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = createAutoBinding(READ, masterTable, ELProperty.create("${selectedElement != null}"), codeProduitField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = createAutoBinding(READ_WRITE, masterTable, ELProperty.create("${selectedElement.reference}"), referenceField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = createAutoBinding(READ, masterTable, ELProperty.create("${selectedElement != null}"), referenceField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = createAutoBinding(READ_WRITE, masterTable, ELProperty.create("${selectedElement.deseignation}"), deseignationField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = createAutoBinding(READ, masterTable, ELProperty.create("${selectedElement != null}"), deseignationField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = createAutoBinding(READ_WRITE, masterTable, ELProperty.create("${selectedElement.fournisseur}"), fournisseurField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = createAutoBinding(READ, masterTable, ELProperty.create("${selectedElement != null}"), fournisseurField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = createAutoBinding(READ_WRITE, masterTable, ELProperty.create("${selectedElement.remise}"), remiseField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = createAutoBinding(READ, masterTable, ELProperty.create("${selectedElement != null}"), remiseField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = createAutoBinding(READ_WRITE, masterTable, ELProperty.create("${selectedElement.prix}"), prixField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = createAutoBinding(READ, masterTable, ELProperty.create("${selectedElement != null}"), prixField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = createAutoBinding(READ_WRITE, masterTable, ELProperty.create("${selectedElement.stock}"), stockField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = createAutoBinding(READ, masterTable, ELProperty.create("${selectedElement != null}"), stockField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        exportButton.setText("export");
        exportButton.addActionListener(formListener);
        saveButton.setText("Enregistré");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Miseajour");
        refreshButton.addActionListener(formListener);

        newButton.setText("Nouvreau");
        newButton.addActionListener(formListener);

        deleteButton.setText("Supprimé");

        binding = createAutoBinding(READ, masterTable, ELProperty.create("${selectedElement != null}"), deleteButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportButton)
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codeProduitLabel)
                                .addComponent(referenceLabel)
                                .addComponent(deseignationLabel)
                                .addComponent(fournisseurLabel)
                                .addComponent(remiseLabel)
                                .addComponent(prixLabel)
                                .addComponent(stockLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codeProduitField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                .addComponent(referenceField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                .addComponent(deseignationField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                .addComponent(fournisseurField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                .addComponent(remiseField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                .addComponent(prixField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                .addComponent(stockField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{deleteButton, newButton, refreshButton, saveButton, exportButton});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(codeProduitLabel)
                                .addComponent(codeProduitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(referenceLabel)
                                .addComponent(referenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(deseignationLabel)
                                .addComponent(deseignationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fournisseurLabel)
                                .addComponent(fournisseurField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(remiseLabel)
                                .addComponent(remiseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(prixLabel)
                                .addComponent(prixField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(stockLabel)
                                .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(exportButton)
                                .addComponent(saveButton)
                                .addComponent(refreshButton)
                                .addComponent(deleteButton)
                                .addComponent(newButton))
                        .addContainerGap())
        );

        bindingGroup.bind();
    }

    private class FormListener implements java.awt.event.ActionListener {

        FormListener() {
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                GestionProduit.this.saveButtonActionPerformed(evt);
            } else if (evt.getSource() == refreshButton) {
                GestionProduit.this.refreshButtonActionPerformed(evt);
            } else if (evt.getSource() == newButton) {
                GestionProduit.this.newButtonActionPerformed(evt);
            } else if (evt.getSource() == deleteButton) {
                GestionProduit.this.deleteButtonActionPerformed(evt);
            } else if (evt.getSource() == exportButton) {
                GestionProduit.this.exportButtonActionPerformed(evt);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int[] selected = masterTable.getSelectedRows();
        List<com.alnaser.entity.Produit> toRemove = new ArrayList<>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            com.alnaser.entity.Produit p = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(p);
            entityManager.remove(p);
        }
        list.removeAll(toRemove);
    }

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {
        com.alnaser.entity.Produit p = new com.alnaser.entity.Produit();
        entityManager.persist(p);
        list.add(p);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            entityManager.getTransaction().begin();
            List<com.alnaser.entity.Produit> merged = new ArrayList<>(list.size());
            for (com.alnaser.entity.Produit p : list) {
                merged.add(entityManager.merge(p));
            }
            list.clear();
            list.addAll(merged);
        }
    }

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("!!!!!!!");
        try {
            OutputStream file = new FileOutputStream(new File("D:\\Test.pdf"));

            Document document = new Document();
            PdfWriter.getInstance(document, file);

            document.open();
            // a table with three columns
            PdfPTable table = new PdfPTable(7);
            // the cell object
            PdfPCell cell, cel2, cel3, cel4, cel5, cel6, cel7;
            // we add a cell with colspan 3
            cell = new PdfPCell(new Phrase("Code"));
            cel2 = new PdfPCell(new Phrase("Ref"));
            cel3 = new PdfPCell(new Phrase("Desg"));
            cel4 = new PdfPCell(new Phrase("Four"));
            cel5 = new PdfPCell(new Phrase("Remise"));
            cel6 = new PdfPCell(new Phrase("Prix"));
            cel7 = new PdfPCell(new Phrase("Stock"));

            table.addCell(cell);
            table.addCell(cel2);
            table.addCell(cel3);
            table.addCell(cel4);
            table.addCell(cel5);
            table.addCell(cel6);
            table.addCell(cel7);

            for (Produit p : list) {
                table.addCell(p.getCodeProduit());
                table.addCell(p.getReference());
                table.addCell(p.getDeseignation());
                table.addCell(p.getFournisseur());
                table.addCell(p.getRemise() + "");
                table.addCell(p.getPrix() + "");
                table.addCell(p.getStock() + "");
            }
            document.add(table);
            document.add(new Paragraph(new Date().toString()));

            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

   
}
