/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author hamma
 */
public class ButtonEditor extends DefaultCellEditor {
    private JButton j;
    int rows;
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.rows=row;
        return j;
    }

    @Override
    public boolean stopCellEditing() {
        ispush=false;
        return super.stopCellEditing();
    }

    @Override
    public Object getCellEditorValue() {
        ispush=false;
        return label;
       
    }
    private String label;
    private boolean ispush;
    private String tittle;

    public ButtonEditor(JCheckBox jCheckBox) {
        super(jCheckBox);
        j=new JButton("Read");
        j.setOpaque(true);
        
        j.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                JFrame frame=new JFrame();
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                JTextArea area=new JTextArea();
                String filedata;
                Path p; 
                if(rows==0){
                    try {
                        p=Path.of("Book1.txt");
                        filedata=Files.readString(p);
                        area.setText(filedata);
                        area.setEditable(false);
                        JScrollPane sp=new JScrollPane(area);
                        
                        frame.add(sp);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                        frame.addWindowListener(new WindowAdapter(){
                            @Override
                          public void windowClosing(WindowEvent e){          
                        int result=JOptionPane.showConfirmDialog(frame, "Are you Sure you want to close!","Close Window",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                         if(result==JOptionPane.YES_OPTION){
                             frame.dispose();
                         }
                          
                          }
                        }
                        );
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
                else if(rows==1){
                    try {
                        p=Path.of("Book2.txt");
                        filedata=Files.readString(p);
                        area.setText(filedata);
                        area.setEditable(false);
                        JScrollPane sp=new JScrollPane(area);
                       frame.add(sp);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                        frame.addWindowListener(new WindowAdapter(){
                            @Override
                          public void windowClosing(WindowEvent e){          
                        int result=JOptionPane.showConfirmDialog(frame, "Are you Sure you want to close!","Close Window",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                         if(result==JOptionPane.YES_OPTION){
                             frame.dispose();
                         }
                          
                          }
                        }
                        );
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else if(rows==2){
                    try {
                        p=Path.of("Book3.txt");
                        filedata=Files.readString(p);
                        area.setText(filedata);
                        area.setEditable(false);
                        JScrollPane sp=new JScrollPane(area);
                        frame.add(sp);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                        frame.addWindowListener(new WindowAdapter(){
                            @Override
                          public void windowClosing(WindowEvent e){          
                        int result=JOptionPane.showConfirmDialog(frame, "Are you Sure you want to close!","Close Window",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                         if(result==JOptionPane.YES_OPTION){
                             frame.dispose();
                         }
                          
                          }
                        }
                        );
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else if(rows==3){
                    
                    try {
                        p=Path.of("Book4.txt");
                        filedata=Files.readString(p);
                        area.setText(filedata);
                        area.setEditable(false);
                       JScrollPane sp=new JScrollPane(area);
                        frame.add(sp);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                        
                        frame.addWindowListener(new WindowAdapter(){
                            @Override
                          public void windowClosing(WindowEvent e){          
                        int result=JOptionPane.showConfirmDialog(frame, "Are you Sure you want to close!","Close Window",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                         if(result==JOptionPane.YES_OPTION){
                             frame.dispose();
                         }
                          
                          }
                        }
                        );
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
        
    }
  

    
}
