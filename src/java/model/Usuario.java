package model;

import database.UsuarioDAO;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String nascimento;
    private String senha;
    private String celular;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    // Construtores
    public Usuario(String nome, String email, String nascimento, String senha, String celular, String cep, String rua, String numero, String bairro, String cidade) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.senha = senha;
        this.celular = celular;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    // Métodos Getters e Setters
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Demais getters e setters para os outros campos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", nascimento=" + nascimento + ", senha=" + senha + '}';
    }
}
