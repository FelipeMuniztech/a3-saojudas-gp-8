package view;

import dao.UsuarioDAO;
import model.Usuario;
import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField tfUsuario;
    private JPasswordField pfSenha;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(10, 10, 80, 25);
        add(lblUsuario);

        tfUsuario = new JTextField();
        tfUsuario.setBounds(100, 10, 160, 25);
        add(tfUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(10, 40, 80, 25);
        add(lblSenha);

        pfSenha = new JPasswordField();
        pfSenha.setBounds(100, 40, 160, 25);
        add(pfSenha);

        btnLogin = new JButton("Entrar");
        btnLogin.setBounds(100, 80, 80, 25);
        add(btnLogin);

        btnLogin.addActionListener(e -> autenticar());
    }
  }

private void autenticar () {
    String usuario = tfUsuario.getText();
    String senha = new String ( pfSenha.getPassword());


}



