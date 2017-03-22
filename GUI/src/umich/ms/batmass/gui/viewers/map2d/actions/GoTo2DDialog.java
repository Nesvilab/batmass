/* 
 * Copyright 2016 Dmitry Avtonomov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package umich.ms.batmass.gui.viewers.map2d.actions;

import java.util.Locale;
import javax.swing.JTextField;
import umich.ms.batmass.gui.core.components.util.textinput.DocumentFilters;

/**
 *
 * @author Dmitry Avtonomov
 */
public class GoTo2DDialog extends javax.swing.JPanel {

    /**
     * Creates new form GoTo2DDialog
     */
    public GoTo2DDialog() {
        initComponents();
    }

    public JTextField getFieldMzAvailableZpan() {
        return fieldMzAvailableSpan;
    }

    public JTextField getFieldMzEnd() {
        return fieldMzEnd;
    }

    public JTextField getFieldMzStart() {
        return fieldMzStart;
    }

    public JTextField getFieldRtAvailableSpan() {
        return fieldRtAvailableSpan;
    }

    public JTextField getFieldRtEnd() {
        return fieldRtEnd;
    }

    public JTextField getFieldRtStart() {
        return fieldRtStart;
    }
    
    public void setDefaultValues(Double mzMin, Double mzMax, Double rtMin, Double rtMax) {
        if (mzMin != null) {
            fieldMzStart.setText(formatFloatToDecimalPoints(mzMin, 4));
        }
        
        if (mzMax != null) {
            fieldMzEnd.setText(formatFloatToDecimalPoints(mzMax, 4));
        }
        
        if (rtMin != null) {
            fieldRtStart.setText(formatFloatToDecimalPoints(rtMin, 2));
        }
        
        if (rtMin != null) {
            fieldRtEnd.setText(formatFloatToDecimalPoints(rtMax, 2));
        }
    }
    
    public void setAvailableRanges(Double mzMin, Double mzMax, Double rtMin, Double rtMax) {
        if (mzMin != null && mzMax != null) {
            fieldMzAvailableSpan.setText(formatFloatToDecimalPoints(mzMin, 4) + " - " + formatFloatToDecimalPoints(mzMax, 4));
        }
        
        if (rtMin != null && rtMax != null) {
            fieldRtAvailableSpan.setText(formatFloatToDecimalPoints(rtMin, 2) + " - " + formatFloatToDecimalPoints(rtMax, 2));
        }
    }
    
    private String formatFloatToDecimalPoints(Double mz, int decimalDigits) {
        return String.format("%." + decimalDigits + "f", mz);
    }
    
    public Double getMzStart() {
        return getValidatedDouble(getFieldMzStart());
    }
    
    public Double getMzEnd() {
        return getValidatedDouble(getFieldMzEnd());
    }
    
    public Double getRtStart() {
        return getValidatedDouble(getFieldRtStart());
    }
    
    public Double getRtEnd() {
        return getValidatedDouble(getFieldRtEnd());
    }
    
    private Double getValidatedDouble(JTextField field) {
        String text = field.getText();
        text = text.replaceAll("[,\\.]+", ".");
        return org.apache.commons.validator.routines.DoubleValidator.getInstance().validate(text, Locale.ROOT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMz = new javax.swing.JLabel();
        labelRt = new javax.swing.JLabel();
        fieldRtStart = new javax.swing.JTextField();
        fieldMzStart = new javax.swing.JTextField();
        labelMzDash = new javax.swing.JLabel();
        fieldMzEnd = new javax.swing.JTextField();
        labelRtDash = new javax.swing.JLabel();
        fieldRtEnd = new javax.swing.JTextField();
        fieldMzAvailableSpan = new javax.swing.JTextField();
        fieldRtAvailableSpan = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(labelMz, org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.labelMz.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelRt, org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.labelRt.text")); // NOI18N

        fieldRtStart.setColumns(10);
        fieldRtStart.setDocument(DocumentFilters.getDigitsAndDotCommaFilter());
        fieldRtStart.setText(org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.fieldRtStart.text")); // NOI18N
        fieldRtStart.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldRtStartFocusGained(evt);
            }
        });

        fieldMzStart.setColumns(10);
        fieldMzStart.setDocument(DocumentFilters.getDigitsAndDotCommaFilter());
        fieldMzStart.setText(org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.fieldMzStart.text")); // NOI18N
        fieldMzStart.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldMzStartFocusGained(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(labelMzDash, org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.labelMzDash.text")); // NOI18N

        fieldMzEnd.setColumns(10);
        fieldMzEnd.setDocument(DocumentFilters.getDigitsAndDotCommaFilter());
        fieldMzEnd.setText(org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.fieldMzEnd.text")); // NOI18N
        fieldMzEnd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldMzEndFocusGained(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(labelRtDash, org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.labelRtDash.text")); // NOI18N

        fieldRtEnd.setColumns(10);
        fieldRtEnd.setDocument(DocumentFilters.getDigitsAndDotCommaFilter());
        fieldRtEnd.setText(org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.fieldRtEnd.text")); // NOI18N
        fieldRtEnd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldRtEndFocusGained(evt);
            }
        });

        fieldMzAvailableSpan.setEditable(false);
        fieldMzAvailableSpan.setText(org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.fieldMzAvailableSpan.text")); // NOI18N
        fieldMzAvailableSpan.setFocusable(false);

        fieldRtAvailableSpan.setEditable(false);
        fieldRtAvailableSpan.setText(org.openide.util.NbBundle.getMessage(GoTo2DDialog.class, "GoTo2DDialog.fieldRtAvailableSpan.text")); // NOI18N
        fieldRtAvailableSpan.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMz)
                    .addComponent(labelRt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldRtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRtDash)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldRtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldRtAvailableSpan))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldMzStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMzDash)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldMzEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldMzAvailableSpan)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMz)
                    .addComponent(fieldMzStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMzDash)
                    .addComponent(fieldMzEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldMzAvailableSpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRt)
                    .addComponent(fieldRtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRtDash)
                    .addComponent(fieldRtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldRtAvailableSpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldMzStartFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldMzStartFocusGained
        fieldMzStart.selectAll();
    }//GEN-LAST:event_fieldMzStartFocusGained

    private void fieldMzEndFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldMzEndFocusGained
        fieldMzEnd.selectAll();
    }//GEN-LAST:event_fieldMzEndFocusGained

    private void fieldRtStartFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldRtStartFocusGained
        fieldRtStart.selectAll();
    }//GEN-LAST:event_fieldRtStartFocusGained

    private void fieldRtEndFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldRtEndFocusGained
        fieldRtEnd.selectAll();
    }//GEN-LAST:event_fieldRtEndFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldMzAvailableSpan;
    private javax.swing.JTextField fieldMzEnd;
    private javax.swing.JTextField fieldMzStart;
    private javax.swing.JTextField fieldRtAvailableSpan;
    private javax.swing.JTextField fieldRtEnd;
    private javax.swing.JTextField fieldRtStart;
    private javax.swing.JLabel labelMz;
    private javax.swing.JLabel labelMzDash;
    private javax.swing.JLabel labelRt;
    private javax.swing.JLabel labelRtDash;
    // End of variables declaration//GEN-END:variables
}
