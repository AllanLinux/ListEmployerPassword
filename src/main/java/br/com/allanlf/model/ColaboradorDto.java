package br.com.allanlf.model;

public class ColaboradorDto {

    private String nome;
    private int score;
    private String chefeNome;

    public ColaboradorDto(String nome, int score, String chefeNome) {
        this.nome = nome;
        this.score = score;
        this.chefeNome = chefeNome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getChefeNome() {
        return chefeNome;
    }

    public void setChefeNome(String chefeNome) {
        this.chefeNome = chefeNome;
    }
}

