package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.CadastroIes;
import util.DbUtil;

public class CadastroIesDao {

    private final Connection connection;

    public CadastroIesDao() {
        connection = DbUtil.getConnection();
    }

    public void addIes(CadastroIes ies) {  // adiciona no banco de dados
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into instituicoes (cod_ies, razao_social, cnpj, endereco, email, senha) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, ies.getCod_ies());
            preparedStatement.setString(2, ies.getRazao_social());
            preparedStatement.setString(3, ies.getCnpj());
            preparedStatement.setString(4, ies.getEndereco());
            preparedStatement.setString(5, ies.getEmail());
            preparedStatement.setString(6, ies.getSenha());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("guardado com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateIes(CadastroIes ies) {  // atualiza qualquer alterção nos dados direto no banco de acordo com o id
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update instituicoes  set  razao_social=?, cnpj=?, endereco=?, email=?, senha=?" + "where userid=?");
            preparedStatement.setString(1, ies.getRazao_social());
            preparedStatement.setString(2, ies.getCnpj());
            preparedStatement.setString(3, ies.getEndereco());
            preparedStatement.setString(4, ies.getEmail());
            preparedStatement.setString(5, ies.getSenha());
            preparedStatement.setInt(6, ies.getUserid());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("Alterado com sucesso");
        } catch (SQLException e) {
        }
    }

    public void deleteIes(int userId) {  // deleleta no banco utilizando o id 
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from instituicoes where userid=?");
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("Deletado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CadastroIes> getAllIes() {  // lista tudo que foi cadastrado no banco
        List<CadastroIes> listaDeIes = new ArrayList<CadastroIes>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from instituicoes");
            while (rs.next()) {
                CadastroIes ies = new CadastroIes();

                ies.setUserid(rs.getInt("userid"));
                ies.setCod_ies(rs.getInt("cod_ies"));
                ies.setRazao_social(rs.getString("razao_social"));
                ies.setCnpj(rs.getString("cnpj"));
                ies.setEndereco(rs.getString("endereco"));
                ies.setEmail(rs.getString("email"));
                listaDeIes.add(ies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDeIes;
    }

    public CadastroIes getIesById(int userId) {  // pesquisa os dados utilizando o id
        CadastroIes ies = new CadastroIes();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from instituicoes where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                ies.setUserid(rs.getInt("userid"));
                ies.setCod_ies(rs.getInt("cod_ies"));
                ies.setRazao_social(rs.getString("razao_social"));
                ies.setEndereco(rs.getString("endereco"));
                ies.setEmail(rs.getString("email"));
                ies.setSenha(rs.getString("senha"));
                ies.setCnpj(rs.getString("cnpj"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ies;
    }

}
