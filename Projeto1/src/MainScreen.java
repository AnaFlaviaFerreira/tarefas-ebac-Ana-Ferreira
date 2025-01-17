import dao.ClientMapDAO;
import dao.IClientDAO;
import domain.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen  extends JFrame{
    private DefaultTableModel model = new DefaultTableModel();
    private IClientDAO clientDAO = new ClientMapDAO();

    private JMenuItem menuItemExit;
    private JPanel rootPanel;
    private JMenu menuOptions;
    private JMenuBar menuBar;
    private JTextField txtName;
    private JTextField txtCpf;
    private JPanel formPanel;
    private JPanel buttonsPanel;
    private JButton btnClean;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnSave;
    private JTextField txtPhone;
    private JTextField txtAdress;
    private JTextField txtNumber;
    private JTextField txtCity;
    private JTextField txtState;
    private JPanel tablePanel;
    private JTable tableClients;

    public MainScreen() {
        createTable();

        add(rootPanel);
        setTitle("Tela Principal");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(menuItemExit, "Deseja sair da aplicação?",
                        "Sair",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        //botões
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isValidFilds(txtName.getText(),txtCpf.getText(),txtPhone.getText(),txtAdress.getText(),txtNumber.getText(),txtCity.getText(),txtState.getText())) {
                    JOptionPane.showMessageDialog(null, "Existem campos a serem preenchidos", "Atenção",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                Client client = new Client(txtName.getText(),Long.parseLong(txtCpf.getText()),Long.parseLong(txtPhone.getText()),
                        txtAdress.getText(),Integer.parseInt(txtNumber.getText()),txtCity.getText(),txtState.getText());

                if (clientDAO.cadastrar(client)) {
                    model.addRow(new Object[]{client.getNome(),client.getCpf(), client.getTel(), client.getEnd()});
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
                    cleanFilds();
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente já cadastrado", "Atenção",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanFilds();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableClients.getSelectedRow();

                if (selectedRow >=0) {
                    int dialog = JOptionPane.showConfirmDialog(btnDelete, "Deseja realmente excluir este cliente?", "Cuidado",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if(dialog == JOptionPane.YES_OPTION) {
                        Long cpf = (Long) tableClients.getValueAt(selectedRow,1);
                        clientDAO.excluir(cpf);
                        model.removeRow(selectedRow);

                        JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
                        cleanFilds();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado", "ERRO",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isValidFilds(txtName.getText(),txtPhone.getText(),txtAdress.getText(),txtNumber.getText(),txtCity.getText(),txtState.getText())) {
                    JOptionPane.showMessageDialog(null, "Existem campos a serem preenchidos", "Atenção",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int selectedRow = tableClients.getSelectedRow();

                if (selectedRow >= 0) {
                    Long cpf = (Long) tableClients.getValueAt(selectedRow,1);
                    Client client = new Client(txtName.getText(),cpf,Long.parseLong(txtPhone.getText()),
                            txtAdress.getText(),Integer.parseInt(txtNumber.getText()),txtCity.getText(),txtState.getText());

                    clientDAO.alterar(client);
                    model.setValueAt(client.getNome(), selectedRow,0);
                    model.setValueAt(client.getTel(), selectedRow,2);
                    model.setValueAt(client.getEnd(), selectedRow,3);

                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
                    cleanFilds();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado", "ERRO",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //pegar a informação e colocar na caixa de texto
        tableClients.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = tableClients.getSelectedRow();
                txtCpf.setEnabled(false);
                Long cpf = (Long) tableClients.getValueAt(selectedRow,1);

                Client client = clientDAO.consultar(cpf);

                txtName.setText(client.getNome());
                txtCpf.setText(client.getCpf().toString());
                txtPhone.setText(client.getTel().toString());
                txtAdress.setText(client.getEnd());
                txtNumber.setText(client.getNumero().toString());
                txtCity.setText(client.getCidade());
                txtState.setText(client.getEstado());
            }
        });
    }

    private void cleanFilds() {
        txtName.setText("");
        txtCpf.setText("");
        txtPhone.setText("");
        txtAdress.setText("");
        txtNumber.setText("");
        txtCity.setText("");
        txtState.setText("");
    }

    private void createTable() {
        //Coloca informação na tabela
        model = new DefaultTableModel(
                null,
                new String[]{"Nome", "CPF", "Telefone", "Endereço"}
        );
        tableClients.setModel(model);
    }

    private boolean isValidFilds(String ...filds) {
        for (String fild: filds) {
            if (fild == null || fild.isEmpty()) {
                return false;
            }
        }
        return  true;
    }
}
