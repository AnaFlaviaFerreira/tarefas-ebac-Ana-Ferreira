import dao.HondaDAO;
import dao.IHondaDAO;
import dao.IOtherBrandDAO;
import dao.OtherBrandDAO;
import domain.Honda;
import domain.OtherBrand;
import domain.Persistent;
import generic.IGenericDAO;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static IHondaDAO iHondaDAO;
    private static IOtherBrandDAO iOtherBrandDAO;
    private static Honda honda;
    private static OtherBrand otherBrand;

    public static void main(String[] args) {
        iHondaDAO = new HondaDAO();
        iOtherBrandDAO = new OtherBrandDAO();

        String opType = JOptionPane.showInputDialog(null,
                "Digite 1 para Honda ou 2 para Outra marca", "Cadastro de carros", JOptionPane.INFORMATION_MESSAGE);

        while (!("1".equals(opType) || "2".equals(opType))) {
            if ("".equals(opType)) {
                exit();
            }
            opType = JOptionPane.showInputDialog(null,
                    "Opção inválida digite 1 para Honda ou 2 para Outra marca", "Cadastro de carros", JOptionPane.INFORMATION_MESSAGE);
        }

        while ("1".equals(opType) || "2".equals(opType)
                || "3".equals(opType) || "4".equals(opType) || "5".equals(opType)) {

            String titulo = opType.equals("1") ? "Cadastro do carro Honda" : "Cadastro do carro de Outra marca";

            String op = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    titulo, JOptionPane.INFORMATION_MESSAGE);

            if ("5".equals(op)) {
                exit();
            } else if ("1".equals(op)) {
                runRegister(opType);
            } else if("2".equals(op)) {
                runSearch(opType);
            } else if("3".equals(op)) {
                runDelete(opType);
            } else if("4".equals(op))  {
                runUpdate(opType);
            }

            opType = JOptionPane.showInputDialog(null,
                    "Opção inválida Digite 1 para Honda ou 2 para Outra marca", "Cadastro de carros", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static IGenericDAO getDAO(String opType) {
        if ("1".equals(opType)) {
            return iHondaDAO;
        } else {
            return iOtherBrandDAO;
        }
    }

    public static Persistent getTypeClass(String opType) {
        if ("1".equals(opType)) {
            return honda;
        } else {
            return otherBrand;
        }
    }

    /* Metódos dos menus */
    private static void exit() {
        JOptionPane.showMessageDialog(null, "Até logo!! ", "Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static void runRegister(String opType) {
        String data = "";
        if ("1".equals(opType)) {
            data = JOptionPane.showInputDialog(null,
                    "Digite os dados do Honda separados por vígula, conforme exemplo: código, cor, tipo e modelo",
                    "Cadastro de carro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            data = JOptionPane.showInputDialog(null,
                    "Digite os dados do outra marca separados por vígula, conforme exemplo:  código, cor, tipo, modelo, marca, origem",
                    "Cadastro de carro", JOptionPane.INFORMATION_MESSAGE);
        }

        String[] newData = data.split(",");
        IGenericDAO type = getDAO(opType);

        if (type.insert(type.createObjets(newData))) {
            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Carro já se encontra cadastrado", "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void runSearch(String opType) {
        String msg = opType.equals("1") ? "Digite o código do carro honda:" : "Digite o código do carro de outra marca:";

        String data = JOptionPane.showInputDialog(null,
                msg,
                "Consultar carro", JOptionPane.INFORMATION_MESSAGE);

        IGenericDAO type = getDAO(opType);
        Persistent persistent = type.search(Long.parseLong(data.trim()));


        if (persistent != null) {
            JOptionPane.showMessageDialog(null, "Dado encontrado: " + type.toString(persistent), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Dado não encontrado. ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void runDelete(String opType) {
        String msg = opType.equals("1") ? "Digite o código do carro honda:" : "Digite o código do carro de outra marca:";
        String data = JOptionPane.showInputDialog(null,
                msg,
                "Exclusão do carro", JOptionPane.INFORMATION_MESSAGE);
        getDAO(opType).delete(Long.parseLong(data));
        JOptionPane.showMessageDialog(null, "Carro excluídos com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    private static void runUpdate(String opType) {
        String data = "";
        if ("1".equals(opType)) {
            data = JOptionPane.showInputDialog(null,
                    "Digite os dados do Honda separados por vígula, conforme exemplo: código, cor, tipo e modelo",
                    "Atualizar de carro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            data = JOptionPane.showInputDialog(null,
                    "Digite os dados do outra marca separados por vígula, conforme exemplo:  código, cor, tipo, modelo, marca, origem",
                    "Atualizar de carro", JOptionPane.INFORMATION_MESSAGE);
        }

        String[] newData = data.split(",");
        IGenericDAO type = getDAO(opType);
        type.update(type.createObjets(newData));
        JOptionPane.showMessageDialog(null, "Carro atualizado com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }
}