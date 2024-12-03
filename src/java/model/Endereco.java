package model;

public class Endereco {
    
    private String rua;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;

    // Construtor
    public Endereco(String rua, String cep, String numero, String bairro, String cidade) {
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    // Getters e Setters
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    @Override
    public String toString() {
        return "Endereco{" + 
               "rua='" + rua + '\'' + 
               ", cep='" + cep + '\'' + 
               ", numero='" + numero + '\'' + 
               ", bairro='" + bairro + '\'' + 
               ", cidade='" + cidade + '\'' + 
               '}';
    }
}
