/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milogin;

import java.awt.Color;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Usuario
 */
public class MiLogin {

    public static void main(String[] args) {
        panel miPanel = new panel();
        miPanel.desactivafecha(true);
        miPanel.desactivaCaptcha(true);
        //miPanel.desactivaLimpiar(true);
       
    }

}
