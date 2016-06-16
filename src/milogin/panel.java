/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milogin;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Usuario
 */
public class panel extends JFrame implements ActionListener {

    private JFrame frame;
    private JFrame miPopFrame;
    private JPanel panel;
    private JPanel panelPop;

    private JLabel userLabel;
    private JTextField userText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JLabel fechaLabel;
    private JTextField fechaText;
    private JLabel chaptchaLabel;
    private JTextField captchaText;
    private JButton loginButton;
    private JButton limpiarButton;
    private JButton olvidePassButton;

    private Boolean fecha = true;
    private Boolean captcha = true;
    private Boolean limpiar = true;
    private Boolean pass = true;
    
    private String miUser = "Aris";
    private String miPass = "12345";

    public panel() {
        frame = new JFrame("Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        ponerComponentes(panel);

        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " "));
        frame.setVisible(true);
        setLocationRelativeTo(null);
        frame.add(panel);
        this.pack();

        limpiarButton.addActionListener(this);
        loginButton.addActionListener(this);
        olvidePassButton.addActionListener(this);

    }

    private void ponerComponentes(JPanel panel) {

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 100, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(130, 10, 160, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 100, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(130, 40, 160, 25);
        panel.add(passwordText);

        fechaLabel = new JLabel("Fecha nacimiento");
        fechaLabel.setBounds(10, 70, 100, 25);
        panel.add(fechaLabel);

        fechaText = new JTextField(20);
        fechaText.setBounds(130, 70, 160, 25);
        panel.add(fechaText);

        chaptchaLabel = new JLabel("XDEE231DK");
        chaptchaLabel.setBounds(10, 100, 100, 25);
        panel.add(chaptchaLabel);

        captchaText = new JTextField(20);
        captchaText.setBounds(130, 100, 160, 25);
        panel.add(captchaText);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 130, 80, 25);
        panel.add(loginButton);

        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(100, 130, 80, 25);
        panel.add(limpiarButton);

        olvidePassButton = new JButton("Olvidé Pass");
        olvidePassButton.setBounds(190, 130, 130, 25);
        panel.add(olvidePassButton);

    }

    public void desactivafecha(Boolean ocultador) {
        if (ocultador = true) {
            fechaLabel.setVisible(false);
            fechaText.setVisible(false);
            fecha = false;
        } else {
            fechaLabel.setVisible(true);
            fechaText.setVisible(true);
        }
    }

    public void desactivaCaptcha(Boolean ocultador) {
        if (ocultador = true) {
            chaptchaLabel.setVisible(false);
            captchaText.setVisible(false);
            captcha = false;
        } else {
            chaptchaLabel.setVisible(true);
            captchaText.setVisible(true);
        }
    }

    public void desactivaLimpiar(Boolean ocultador) {
        if (ocultador = true) {
            limpiarButton.setVisible(false);
            limpiar = false;
        } else {
            limpiarButton.setVisible(true);
        }
    }

    public void desactivaPass(Boolean ocultador) {
        if (ocultador = true) {
            olvidePassButton.setVisible(false);
            pass = false;
        } else {
            olvidePassButton.setVisible(true);
        }
    }

    public void creaPopUp() {
        JOptionPane.showMessageDialog(frame, "Para cambiar la contraseña contacte con el administrador");
    }

    public boolean todosRellenados() {
        if (fecha == true && captcha == true) {
            if (userText.getText().equals(miUser)
                    && passwordText.getText().equals(miPass)
                    && !fechaText.getText().isEmpty()
                    && captchaText.getText().equals(chaptchaLabel.getText())) {

                return true;
            }
            return false;
        } else if (fecha == true && captcha == false) {
            if (userText.getText().equals(miUser)
                    && passwordText.getText().equals(miPass)
                    && !fechaText.getText().isEmpty()) {

                return true;
            }
            return false;
        } else if (fecha == false && captcha == true) {
            if (userText.getText().equals(miUser)
                    && passwordText.getText().equals(miPass)
                    && captchaText.getText().equals(chaptchaLabel.getText())) {

                return true;
            }
            return false;
        } else if (fecha == false && captcha == false) {
            if (userText.getText().equals(miUser)
                    && passwordText.getText().equals(miPass)) {

                return true;
            }
            return false;
        }
        return false;
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Limpiar")) {
            userText.setText("");
            passwordText.setText("");
            fechaText.setText("");
            captchaText.setText("");

        } else if (action.equals("Login")) {
            compruebaLogin();
        } else if (action.equals("Olvidé Pass")) {
            creaPopUp();
        }
    }

    public void compruebaLogin() {
        if(todosRellenados() == true){
            JOptionPane.showMessageDialog(frame, "Login correcto");
        }else if (todosRellenados() == false){
            JOptionPane.showMessageDialog(frame, "Login incorrecto");
        }
    }
}
