# Aula 01 - 29.07.2026
Nas aulas vai ser utilizado **Apache NetBeans**.

# Unidades
- Unidade 1: Planejamento de projeto de software
- Unidade 2: Interface Gráfica
- Unidade 3: Integração com banco de dados
- Unidade 4: Desenvolvimento de Software

# Revisão sobre conceitos de POO
* **Classe:** Modelo ou molde a partir do qual os objetos são criados. Define atributos e métodos.
* **Objeto:** Instância concreta de uma classe.
* **Métodos:** Ações ou comportamentos associados a uma classe/objeto.

---

### Encapsulamento
O encapsulamento protege os dados internos de uma classe, permitindo o acesso e modificação de forma controlada através de métodos públicos.

#### Modificadores de Acesso:
* `public`: Acesso permitido a qualquer classe.
* `private`: Acesso permitido **apenas** dentro da própria classe.
* `protected`: Acesso permitido à própria classe, subclasses e classes do mesmo pacote.
* `default` *(package-private)*: Padrão quando não especificado. Permite acesso a classes do mesmo pacote.

#### Getters e Setters:
* **Getters:** Obtêm o valor de um atributo privado (ex: `getNome()`).
* **Setters:** Alteram o valor de um atributo privado (ex: `setNome(String nome)`).

#### Representação em Diagrama de Classes (UML):
A estrutura do diagrama é dividida em 3 partes (Nome da Classe, Atributos, Métodos):
* `+` (público)
* `-` (privado)
* `#` (protegido)
* `~` (default / pacote)
---

### 3. Herança
Mecanismo que permite a reutilização de código e a facilitação da manutenção em cascata.

* Em Java, é declarada usando a palavra-chave **`extends`**.
* **Herança Múltipla:** Java **não suporta** herança múltipla direta de classes. O reuso hierárquico é feito via herança em cascata (`ClasseC extends ClasseB`, `ClasseB extends ClasseA`).
* **A palavra-chave `super`:** Utilizada para chamar o construtor ou métodos da superclasse (deve ser a primeira instrução no construtor da subclasse).

**Exemplo:**
```java
public class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class PessoaJuridica extends Pessoa {
    protected String CNPJ;
    protected String socio;
    protected String dtAbertura;

    public PessoaJuridica(String nome, int idade, String CNPJ, String socio, String dtAbertura) {
        super(nome, idade); // Chamada ao construtor da superclasse
        this.CNPJ = CNPJ;
        this.socio = socio;
        this.dtAbertura = dtAbertura;
    }
}
```

---

### Polimorfismo
Permite que objetos de diferentes classes respondam à mesma mensagem de formas distintas ("muitas formas").

#### Sobrescrita de Métodos (*Override*):
* Ocorre quando uma subclasse reinterpreta a implementação de um método herdado da superclasse.
* Mantém a **mesma assinatura** (nome, parâmetros e retorno).
* Utiliza a anotação `@Override`.

#### Sobrecarga de Métodos (*Overload*):
* Ocorre quando uma classe possui vários métodos com o **mesmo nome**, mas **assinaturas diferentes** (diferentes tipos ou quantidade de parâmetros).
* A escolha do método a ser executado é resolvida em tempo de compilação com base nos argumentos passados.

---

##Revisão de Classes Abstratas e Interfaces

### Classes Abstratas
* Declaradas com a palavra-chave **`abstract`**.
* **Não podem ser instanciadas** diretamente (`new ClasseAbstrata()` gera erro de compilação).
* Podem conter atributos comuns (com qualquer visibilidade), construtores, métodos concretos (com implementação) e métodos abstratos (sem corpo).
* **Métodos Abstratos:** Forçam as subclasses concretas a fornecerem uma implementação específica.

---

### Interfaces
* Declaradas com a palavra-chave **`interface`**.
* Funcionam como um contrato: definem o que a classe deve fazer, mas não como fazer.
* Uma classe implementa uma interface usando a palavra-chave **`implements`**.
* **Propriedades:**
  * Métodos são implicitamente `public` e `abstract`.
  * Não possuem construtores.
  * Atributos em interfaces são implicitamente `public static final` (constantes).
  * Uma classe pode **implementar múltiplas interfaces** (solucionando a limitação de herança múltipla de classes).

---
### Resolvidos
Os exercícios passados foi colocado no repositório: ([Exercícios)](https://github.com/yasminComputing/LaboratorioDesenvolvimentoDeSoftware/tree/main/Aula_01-ExerciciosRevisao_29.07)

