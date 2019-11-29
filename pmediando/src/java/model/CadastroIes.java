
package model;

public class CadastroIes {

    private int userid;
    private int cod_ies;
    private String razao_social;
    private String cnpj;
    private String endereco;
    private String email;
    private String senha;

    //Construtores
    public CadastroIes() {
    }

    public CadastroIes(int userid, int cod_ies, String razao_social, String cnpj, String endereco, String email, String senha) {
        this.userid = userid;
        this.cod_ies = cod_ies;
        this.razao_social = razao_social;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    //Gets e sets
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCod_ies() {
        return cod_ies;
    }

    public void setCod_ies(int cod_ies) {
        this.cod_ies = cod_ies;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CadastroIes{" + "userid=" + userid + ", cod_ies=" + cod_ies + ", razao_social=" + razao_social + ", cnpj=" + cnpj + ", endereco=" + endereco + ", email=" + email + ", senha=" + senha + '}';
    }

}
