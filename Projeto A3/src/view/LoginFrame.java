package view;

import dao.UsuarioDAO;
import model.Usuario;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
   private Connection conn;

public class LoginFrame extends JFrame {
    private JTextField tfUsuario;
    private JPasswordField pfSenha;
    private JButton btnLogin;

    // Aqui a gente vai conectar com as tabelas do banco quando tiver o url
    
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
    
 try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
            Usuario user = usuarioDAO.buscarPorNome(usuario);

   if (user != null && user.getSenha().equals(senha) && user.getAtivo()) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                // Aqui pode abrir a tela principal e fechar a tela de login
                // new MainFrame(conn).setVisible(true);
                // this.dispose();
 } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);}
     
 } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);}
    }

}



