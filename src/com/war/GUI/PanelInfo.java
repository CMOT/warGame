/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.GUI;

import com.war.model.Build;
import com.war.model.Unit;
import com.war.utils.CommonUtils;

/**
 *
 * @author ASUS
 */
public class PanelInfo extends javax.swing.JPanel {

    /**
     * Creates new form PanelInfo
     */
    public PanelInfo(int width, int height) {
        this.setBounds(0,0, width, height);
        initComponents();
        imageLabel.setIcon(null);
        unitLabel.setText("Unit :");
        forceLabel.setText("Force :");
        piLabel.setText("HP : ");
  
    }

    
    public void updateInfoUnit(Unit selected){
        if(selected!=null){
            int hp=(int)((selected.getHealtPoints()*100)/selected.getLifePoints());
            imageLabel.setIcon(selected.getImage());
            unitLabel.setText("Unit :"+selected.getName());
            forceLabel.setText("Force :"+selected.getForce());
            piLabel.setText("HP : "+selected.getHealtPoints() +"/" +selected.getLifePoints());
            lifeBar.setValue( hp);
            
        }else{
            imageLabel.setIcon(null);
            unitLabel.setText("");
            forceLabel.setText("");
            piLabel.setText("");
            lifeBar.setValue(0 );
        }

        
    }
    public void updateInfoBuild(Build selected){
        if(selected!=null){
            int hp=(int)((selected.getHealtPoints()*100)/selected.getLifePoints());
            imageLabel.setIcon(selected.getImage());
            unitLabel.setText("Build :"+selected.getName());
            forceLabel.setText("Capacity :"+selected.getCapacity());
            piLabel.setText("HP : "+selected.getHealtPoints() +"/" +selected.getLifePoints());
            lifeBar.setValue(hp);
            
            
        }else{
            imageLabel.setIcon(null);
            unitLabel.setText("");
            forceLabel.setText("");
            piLabel.setText("");
            lifeBar.setValue(0 );
 
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInfo = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        forceLabel = new javax.swing.JLabel();
        piLabel = new javax.swing.JLabel();
        unitLabel = new javax.swing.JLabel();
        lifeBar = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblUnit1 = new javax.swing.JLabel();
        lblUnit2 = new javax.swing.JLabel();
        lblUnit3 = new javax.swing.JLabel();
        unitCharge = new javax.swing.JProgressBar();

        panelInfo.setBackground(new java.awt.Color(0, 153, 102));

        forceLabel.setText("Force :");

        piLabel.setText("HP :");

        unitLabel.setText("Unit :");

        lifeBar.setForeground(new java.awt.Color(51, 255, 51));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lblUnit1.setBackground(new java.awt.Color(204, 204, 204));
        lblUnit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/soldado0.png"))); // NOI18N
        lblUnit1.setText("Cost: 60 Points");
        lblUnit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUnit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUnit1MouseClicked(evt);
            }
        });

        lblUnit2.setBackground(new java.awt.Color(204, 204, 204));
        lblUnit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/s20.png"))); // NOI18N
        lblUnit2.setText("Cost: 120 Points");
        lblUnit2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUnit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUnit2MouseClicked(evt);
            }
        });

        lblUnit3.setBackground(new java.awt.Color(204, 204, 204));
        lblUnit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/units/ametrallador0.png"))); // NOI18N
        lblUnit3.setText("Cost: 180 Points");
        lblUnit3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUnit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUnit3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblUnit1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblUnit3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUnit2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUnit1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblUnit3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUnit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        unitCharge.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unitCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unitCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                        .addComponent(piLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lifeBar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(forceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addComponent(unitLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(forceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lifeBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(piLabel))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblUnit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnit1MouseClicked
        if(CommonUtils.points>59){
            if(unitCharge.getValue()!=100){
                if(!CommonUtils.createUnit){
                    CommonUtils.createUnit=true;
                    unitCharge.setValue(CommonUtils.timeUnit);
                    CommonUtils.typeUnit=1;
                    CommonUtils.points-=60;
                }
            }
        }
    }//GEN-LAST:event_lblUnit1MouseClicked

    private void lblUnit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnit2MouseClicked
        if(CommonUtils.points>119){
            if(unitCharge.getValue()!=100){
                if(!CommonUtils.createUnit){
                    CommonUtils.createUnit=true;
                    unitCharge.setValue(CommonUtils.timeUnit);
                    CommonUtils.typeUnit=2;
                    CommonUtils.points-=120;
                 }
            }
        }
    }//GEN-LAST:event_lblUnit2MouseClicked

    private void lblUnit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnit3MouseClicked
        if(CommonUtils.points>179){
            if(unitCharge.getValue()!=100){
                if(!CommonUtils.createUnit){
                    CommonUtils.createUnit=true;
                    unitCharge.setValue(CommonUtils.timeUnit);
                    CommonUtils.typeUnit=3;
                    CommonUtils.points-=180;
                 }
            }
        }
    }//GEN-LAST:event_lblUnit3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel forceLabel;
    public static javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblUnit1;
    private javax.swing.JLabel lblUnit2;
    private javax.swing.JLabel lblUnit3;
    private javax.swing.JProgressBar lifeBar;
    private javax.swing.JPanel panelInfo;
    public static javax.swing.JLabel piLabel;
    public static javax.swing.JProgressBar unitCharge;
    public static javax.swing.JLabel unitLabel;
    // End of variables declaration//GEN-END:variables
}
