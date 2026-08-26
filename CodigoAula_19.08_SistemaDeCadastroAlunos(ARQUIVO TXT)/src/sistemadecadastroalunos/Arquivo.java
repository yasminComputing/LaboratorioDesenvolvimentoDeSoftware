package sistemadecadastroalunos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    private FileWriter arqW;
    private BufferedWriter escritor;
    
    private FileReader arqR;
    private BufferedReader leitor;
    
    private List<Aluno> lista;
    
    public String nomeArquivo;
    
    public Arquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
        lista = new ArrayList<>();
    }
    
    public List<Aluno> lerArquivo(){
        try{
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);
            
            String linha;
            
            while((linha = leitor.readLine()) != null){
                
                String[] campo = linha.split(";");
                Aluno a = new Aluno(campo[0],campo[1],campo[2],Integer.parseInt(campo[3]),
                        campo[4],campo[5],campo[6],campo[7],campo[8]);
                
                lista.add(a);
            }
            leitor.close();
            arqR.close();
     
        }catch(IOException e){
            System.out.println("Arquivo Vazio!");
        }
        return lista;
    }
    public List<Aluno> getLista(){
        return lista;
    }
    
    public void gravarArquivo(){
        try{
            arqW = new FileWriter(nomeArquivo + ".txt",false);
            escritor = new BufferedWriter(arqW);
            
            for(Aluno a : lista){
                escritor.write(a.getNome() + ";" + a.getDataNascimento() + ";" + a.getSexo() + ";" + a.getMatricula() + ";" + a.getCurso() + ";" + a.getCpf() + ";" + a.getEndereco() + ";" + a.getEstado() + ";" + a.getTelefone());
                
                escritor.newLine();
            }
            escritor.close();
            arqW.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
