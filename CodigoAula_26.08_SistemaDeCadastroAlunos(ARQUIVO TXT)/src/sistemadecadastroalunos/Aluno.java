package sistemadecadastroalunos;

public class Aluno {

    private String nome;
    private String dataNascimento;
    private String sexo;
    private int matricula;
    private String curso;
    private String cpf;
    private String endereco;
    private String estado;
    private String telefone;

    public Aluno(String nome, String dataNascimento, String sexo, int matricula, String curso, String cpf, String endereco, String estado, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.endereco = endereco;
        this.estado = estado;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    @Override
    public String toString(){
        return nome + ";" + dataNascimento + ";" + sexo + ";" + matricula + ";" + curso + ";" + cpf + ";" + endereco + ";" + estado + ";" + telefone;
    }
    
    public Object[] obterDados(){
        return new Object[] {nome,dataNascimento,sexo,matricula,curso,cpf,endereco,estado,telefone};
    }
    
    

}
