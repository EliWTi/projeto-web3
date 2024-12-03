package model;

public class Produto {
    private int idproduto;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private String imagem;
    private String categoria;

    // Construtores
    public Produto() {}

    public Produto(String nome, String descricao, double preco, int estoque, String imagem, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.imagem = imagem;
        this.categoria = categoria;
    }

    public Produto(int idproduto, String nome, String descricao, double preco, int estoque, String imagem, String categoria) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.imagem = imagem;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" + "idproduto=" + idproduto + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", estoque=" + estoque + ", imagem=" + imagem + ", categoria=" + categoria + '}';
    }
}
