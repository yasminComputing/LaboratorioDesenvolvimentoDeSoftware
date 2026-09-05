## Resumo 

## O que é o Java Swing

- Biblioteca gráfica do Java para criar **GUIs** (Graphical User Interfaces).
- Faz parte da **Java Foundation Classes (JFC)**.
- Oferece componentes prontos: botões, campos de texto, painéis, janelas, tabelas etc.

### Vantagens
- **Multiplataforma**: roda em qualquer sistema sem reescrever código.
- **Componentes personalizáveis**.
- **Ampla variedade de componentes**.
- **Interface responsiva**.
- **Look and Feel** configurável (aparência pode mudar conforme o SO).

### Desvantagens
- Aparência não é totalmente nativa em todas as plataformas.
- Pode ser mais pesado/lento que bibliotecas modernas.
- Poucos recursos de design "moderno" comparado a frameworks atuais.

---

## Fluxo básico para criar uma interface

### No NetBeans
1. `File → New Project → Java with Ant → Java Application` (desmarcar "Create Main Class" se for usar JFrame Form separado).
2. Botão direito no pacote → `New → JFrame Form...` → dar nome à classe.
3. Arrastar componentes da paleta para o formulário (aba **Design**).
4. Alterar propriedades no painel **Properties** (ex: `text` do botão).
5. Aba **Events**: definir o que acontece ao interagir com o componente (ex: `actionPerformed`).
6. Aba **Code**: renomear a variável do componente seguindo a convenção de nomes (abaixo) e ajustar visibilidade/modificadores.
7. Botão de "Preview Design" para testar visualmente sem rodar o projeto completo.

---

##  Principais componentes do Swing

| Componente | Prefixo (convenção) | Função |
|---|---|---|
| `JFrame` | — | Janela principal da aplicação |
| `JPanel` | `pnl` | Contêiner leve para organizar/agrupar outros componentes |
| `JButton` | `btn` | Botão clicável que executa uma ação |
| `JLabel` | `lbl` | Exibe texto ou imagem (não editável pelo usuário) |
| `JTextField` | `txt` | Campo de texto de uma linha |
| `JTextArea` | `txta` | Área de texto multilinha |
| `JCheckBox` | `chk` | Caixa de seleção (marcada/desmarcada) |
| `JRadioButton` | `rad` | Botão de opção — escolha única dentro de um grupo |
| `JComboBox` | `cmb` | Caixa de seleção (lista suspensa) |
| `JTable` | `tbl` | Exibe/edita dados em formato de tabela |

### Convenção de nomes (padrão de mercado)
`prefixo + NomeDescritivo`, exemplos:
- `btnSalvar`, `btnOK`, `btnCE`
- `lblMensagem`, `lblValor1`
- `txtNome`, `txtResultado`
- `cmbCidades`


---

## Layouts (gerenciadores de layout)

O layout define **como os componentes são posicionados** dentro do contêiner.

| Layout | Como funciona | Quando usar |
|---|---|---|
| **FlowLayout** | Posiciona componentes em linha, na ordem de inserção; quebra linha se não couber | Barras de ferramentas, diálogos simples |
| **BorderLayout** | Divide em 5 regiões: Norte, Sul, Leste, Oeste, Centro (1 componente por região) | Layouts com áreas fixas (menu no topo, conteúdo no centro etc.) |
| **GridLayout** | Organiza em grade retangular (linhas x colunas), 1 componente por célula | Calculadoras, tabuleiros de jogo |
| **BoxLayout** | Alinha componentes em uma linha (horizontal ou vertical), com controle de alinhamento | Quando se precisa de alinhamento preciso |
| **GridBagLayout** | Muito flexível, mas mais complexo de configurar | Layouts personalizados e detalhados |
| **CardLayout** | Alterna entre painéis, mostrando um por vez | Telas de navegação/wizard, múltiplas "telas" |
| **Absolute Layout** (WindowBuilder) | Posicionamento livre (x, y) — não é um layout padrão do Java, é um recurso do WindowBuilder | Protótipos rápidos, mas menos flexível para redimensionar |

> **Observação da aula:** sem definir um layout, botões "ficam presos" e não se redimensionam corretamente — por isso é essencial entender e escolher o layout certo.

---

## Eventos

- Todo componente pode ter **eventos** associados (ex: `actionPerformed` para cliques de botão).
- No **NetBeans**: aba **Events** do componente → escolher o evento → o editor gera o método automaticamente.
- No **Eclipse/WindowBuilder**: dois cliques no componente gera o método de evento.
- O método `actionPerformed(ActionEvent evt)` é executado **toda vez que o botão é pressionado**.

Exemplo básico (mostrar mensagem ao clicar):
```java
private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(frame, "Oi mundo!");
}
```

---

## Manipulação de texto e conversão de tipos

Padrão para ler valor de um `JTextField`, converter e mostrar resultado em `JLabel`:

```java
double valor, resultado;
valor = Double.parseDouble(txtCampo.getText());
resultado = /* cálculo */;
lblResultado.setText("Resultado: " + resultado);
```

### Exemplo — Conversor Fahrenheit → Celsius
```java
private void btnConverterActionPerformed(java.awt.event.ActionEvent evt) {
    double temFar, tempCelsius;
    temFar = Double.parseDouble(txtFare.getText());
    tempCelsius = (temFar - 32) * 5/9;
    lblCelsius.setText("CELSIUS: " + tempCelsius);
}
```

### Exemplo — Conversor Real → Dólar
```java
private void btnConverteActionPerformed(java.awt.event.ActionEvent evt) {
    double dolares, reais;
    reais = Double.parseDouble(txtReais.getText());
    dolares = reais / 5.44;
    lblDolares.setText("Dolares: " + dolares);
}
```

---

## Estudo de caso: Calculadora (passo a passo)

### Estrutura geral
1. Criar um novo projeto/JFrame Form.
2. Adicionar um `JTextField` (ex: `txtResultado`) para mostrar o valor digitado/resultado.
   - Propriedade `horizontalAlignment = RIGHT` (padrão de calculadora).
   - Aumentar a fonte (ex: `Segoe UI 48 Plain`) para melhor visualização.
3. Adicionar os botões numéricos (0-9) e de operações (+, -, *, /, =, C, CE, backspace), seguindo a convenção `btnNOME`.
4. Usar um `JPanel` para agrupar os botões — facilita a organização e o posicionamento.
5. Usar **"Same Size"** (clique direito, selecionar vários com Ctrl, último = referência) para igualar tamanhos dos botões.
6. Usar **"Align"** para alinhar os componentes entre si (esquerda/direita/centro em relação à coluna/linha).

### Lógica dos botões numéricos
Cada botão numérico **concatena** o dígito ao texto já existente (não sobrescreve):
```java
private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {
    txtResultado.setText(txtResultado.getText() + "0");
}
```
(repetir a lógica trocando o número para cada botão 0-9)

### Guardar o primeiro valor e a operação
- Criar um `JLabel` (ex: `lblValor1`) para guardar visualmente o primeiro número digitado.
- Criar variáveis **globais**:
```java
double valor1, valor2;
String operacao;
```
- No clique de um botão de operação (ex: soma):
```java
private void btnsomaActionPerformed(java.awt.event.ActionEvent evt) {
    lblValor1.setText(txtResultado.getText()); // guarda o valor mostrado
    txtResultado.setText("");                  // limpa o campo para o 2º número
    valor1 = Double.parseDouble(lblValor1.getText());
    operacao = "soma";
}
```
(mesma lógica para `sub`, `multi`, `div`, trocando o texto da operação)

### Botão "=" (calcular resultado)
```java
private void btnigualActionPerformed(java.awt.event.ActionEvent evt) {
    double resultado;
    valor2 = Double.parseDouble(txtResultado.getText());

    if (operacao == "soma") {
        resultado = valor1 + valor2;
        lblValor1.setText(valor1 + "+" + valor2 + "=");
        txtResultado.setText(String.valueOf(resultado));
    } else if (operacao == "sub") {
        resultado = valor1 - valor2;
        lblValor1.setText(valor1 + "-" + valor2 + "=");
        txtResultado.setText(String.valueOf(resultado));
    } else if (operacao == "multi") {
        resultado = valor1 * valor2;
        lblValor1.setText(valor1 + "x" + valor2 + "=");
        txtResultado.setText(String.valueOf(resultado));
    } else if (operacao == "div") {
        resultado = valor1 / valor2;
        lblValor1.setText(valor1 + "÷" + valor2 + "=");
        txtResultado.setText(String.valueOf(resultado));
    }
}
```

> ⚠️ Nota técnica (boa prática, não estava no PDF): comparar Strings em Java com `==` funciona por coincidência de *string pool*, mas o correto é usar `.equals()` (ex: `operacao.equals("soma")`). Vale mencionar isso na prova se quiser mostrar domínio da linguagem, mesmo que o material do professor use `==`.


--- 

## Java Swing: Outros Componentes (Aula 06)
Componentes abordados: **Text Area, Radio Button, CheckBox, ComboBox e Table (JTable)**.

## 1. Text Area (`JTextArea`)

**O que é:** parecido com o `JTextField`, mas permite múltiplas linhas e colunas, e permite ir *adicionando* texto (não só substituir).

**Propriedades importantes:**
- `rows` e `columns` → definem tamanho da área de texto.
- `lineWrap` → quebra de linha automática.
- Geralmente colocado dentro de um `JScrollPane` (scroll).

**Métodos principais:**
```java
txaTexto.setText("texto");     // substitui todo o conteúdo
txaTexto.append(texto);        // adiciona texto ao final (sem apagar o que já tem)
txaTexto.append(texto + "\n"); // adiciona quebrando linha
txtMensagem.setText("");       // limpa um campo de texto após usar
```

**Padrão de uso visto em aula:**
1. Criar um `JLabel` + `JTextArea` (dentro de scroll).
2. Criar um `JTextField` (mensagem) + botão "Adiciona mensagem".
3. No evento do botão, usar `append()` para acrescentar o texto do campo na área de texto, e depois limpar o campo com `setText("")`.

> "Para que serve o método `append`?" → Ele adiciona texto ao conteúdo já existente da `JTextArea`, sem apagar o que já estava escrito (diferente de `setText`, que substitui tudo).

---

## 2. Radio Button (`JRadioButton`)

**O que é:** permite ao usuário escolher **apenas uma opção** dentro de um conjunto de opções mutuamente exclusivas (como os botões físicos de rádio antigo).

**Problema comum:** se você adicionar dois ou mais `JRadioButton` soltos, é possível marcar **os dois ao mesmo tempo** — isso é um erro que deve ser corrigido.

**Solução: `ButtonGroup`**
- É um componente que **não aparece visualmente** no formulário.
- Serve para agrupar os radio buttons e garantir que **apenas um** seja selecionado por vez.
- Passos:
  1. Adicionar um `Button Group` (ex.: `btnGrp_Sexo`).
  2. Selecionar cada `JRadioButton` e, na propriedade **`buttonGroup`**, escolher o grupo criado.

**Verificando qual opção está selecionada:**
```java
if (rdo_Masculino.isSelected()) {
    sexo = 'M';
} else if (rdo_Feminino.isSelected()) {
    sexo = 'F';
} else {
    JOptionPane.showMessageDialog(null, "Selecione um sexo", "Erro!", JOptionPane.ERROR_MESSAGE);
}
```

> **Pontos-chave:**
> - `ButtonGroup` = garante exclusividade (mutuamente exclusivo).
> - `isSelected()` = verifica se está marcado.
> - Sempre tratar o caso "nenhum selecionado" (validação).

---

## 3. CheckBox (`JCheckBox`)

**O que é:** permite ao usuário marcar/desmarcar **uma ou mais opções independentes** (diferente do radio button, aqui pode marcar vários ao mesmo tempo).

**Padrão de nomenclatura:** `chk_NomeDaOpcao` (ex.: `chk_Tecnologia`, `chk_Astronomia`, `chk_Esportes`).

**Uso típico:**
```java
boolean tecnologia, astronomia, esportes;

tecnologia = chk_Tecnologia.isSelected();
astronomia = chk_Astronomia.isSelected();
esportes   = chk_Esportes.isSelected();
```

> **Ponto-chave:** `isSelected()` retorna `true`/`false` — não precisa de `if/else` como no radio button, pois cada checkbox é independente.

---

## 4. Combo Box (`JComboBox`)

**O que é:** combina uma lista suspensa (dropdown) de opções pré-definidas com (opcionalmente) edição de texto livre. Usado quando se quer oferecer opções fixas ao usuário (ex.: idioma, estado, curso).

**Como configurar os itens (design time):**
1. Selecionar o `JComboBox` → botão direito → **Properties**.
2. Na propriedade **`model`**, abrir o editor e digitar um item por linha:
   ```
   Espanhol
   Inglês
   Português
   ```

**Pegando o valor selecionado:**
```java
String idioma = (String) cmb_Idioma.getSelectedItem();

JOptionPane.showMessageDialog(null,
    "Idioma selecionado:" + cmb_Idioma.getSelectedItem(),
    "Alerta", JOptionPane.INFORMATION_MESSAGE);
```

> **Ponto-chave:** `getSelectedItem()` retorna um `Object`, geralmente precisa de **cast para `String`** quando os itens são texto.

---

## 5. Criando uma Classe para Representar os Dados (POJO)

Depois de capturar os dados dos componentes, é comum criar uma **classe modelo** para organizar as informações (ex.: classe `Pessoa`):

```java
public class Pessoa {
    public String nome;
    public char sexo;
    public String idioma;

    public Pessoa(String nome, char sexo, String idioma) {
        this.nome = nome;
        this.sexo = sexo;
        this.idioma = idioma;
    }

    // Método usado para alimentar a JTable
    public Object[] obterDados() {
        return new Object[] {nome, sexo, idioma};
    }
}
```

**Uso no botão Salvar:**
```java
Pessoa p = new Pessoa(txt_Nome.getText(), sexo, (String) cmb_Idioma.getSelectedItem());
```

> **Ponto-chave de prova:** entender o padrão **construtor + atributos públicos** e o método auxiliar (`obterDados()`) que devolve um `Object[]` — muito usado para popular tabelas.

---

## 6. Table (`JTable`)

**O que é:** componente para exibir dados em formato de tabela (linhas e colunas), como uma planilha. Suporta ordenação, seleção e edição de células.

**Configurando o modelo da tabela (design time):**
1. Adicionar `JTable` na tela.
2. Ir em Properties → propriedade **`model`** → **Table model customizer**.
3. Definir colunas (Title) e tipos, ex.: `Nome`, `Sexo`, `Idioma` (tipo `Object`).
4. Pode-se começar com **0 linhas** (`Rows: 0`), já que os dados virão do código.

**Adicionando uma linha na tabela (via código):**
```java
DefaultTableModel tabela = (DefaultTableModel) tbl_Pessoas.getModel();
tabela.addRow(p.obterDados());
```

**Limpando os campos do formulário após salvar:**
```java
txtNome.setText("");
btnGrpSexo.clearSelection();
chk_Tecnologia.setSelected(false);
chk_Astronomia.setSelected(false);
chk_Esportes.setSelected(false);
cmb_Idioma.setSelectedIndex(0);
```

**Evoluindo: usar uma `List<Pessoa>` como fonte de verdade**

Em vez de só adicionar direto na tabela, o ideal é manter uma lista em memória e sempre **recarregar a tabela a partir da lista** — isso evita inconsistências:

```java
List<Pessoa> listaPessoas = new ArrayList<>();
listaPessoas.add(p);

DefaultTableModel tabela = (DefaultTableModel) tbl_Pessoas.getModel();
tabela.setRowCount(0); // limpa a tabela

for (Pessoa pessoa : listaPessoas) {
    tabela.addRow(pessoa.obterDados());
}
```

> **Ponto-chave :**
> - `DefaultTableModel` é o modelo padrão usado para manipular linhas de uma `JTable`.
> - `setRowCount(0)` → limpa todas as linhas da tabela.
> - `addRow(Object[])` → adiciona uma linha.
> - Sempre reconstruir a tabela a partir da **lista** (fonte única de dados), não só ir empilhando linhas direto.

---

## 7. Persistência em Arquivo (Leitura/Escrita)

Para que os dados **não se percam** ao fechar o programa, é usada uma classe `Arquivo` que lê e grava um `.txt`.

**Estrutura básica da classe `Arquivo`:**
```java
public class Arquivo {
    private FileWriter arqW;
    private BufferedWriter escritor;
    private FileReader arqR;
    private BufferedReader leitor;
    private List<Pessoa> listaPessoas;
    public String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaPessoas = new ArrayList<>();
    }
```

**Ler o arquivo (`leArquivo`):**
```java
public List<Pessoa> leArquivo() {
    listaPessoas.clear();
    try {
        arqR = new FileReader(nomeArquivo + ".txt");
        leitor = new BufferedReader(arqR);
        String linha;
        while ((linha = leitor.readLine()) != null) {
            String[] campos = linha.split(";");
            String nome = campos[0];
            char sexo = campos[1].charAt(0);
            String idioma = campos[2];
            Pessoa p = new Pessoa(nome, sexo, idioma);
            listaPessoas.add(p);
        }
        leitor.close();
        arqR.close();
    } catch (FileNotFoundException e) {
        System.out.println("Arquivo ainda não existe.");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return listaPessoas;
}
```

**Gravar o arquivo (`gravaArquivo`) — grava TODA a lista, sobrescrevendo:**
```java
public void gravaArquivo() {
    try {
        arqW = new FileWriter(nomeArquivo + ".txt", false); // false = sobrescreve
        escritor = new BufferedWriter(arqW);
        for (Pessoa p : listaPessoas) {
            escritor.write(p.nome + ";" + p.sexo + ";" + p.idioma);
            escritor.newLine();
        }
        escritor.close();
        arqW.close();
        System.out.println("Lista salva no arquivo!");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

**Como usar no formulário (construtor da tela):**
```java
public Formulario2() {
    initComponents();
    arquivo = new Arquivo("pessoas");
    listaPessoas = arquivo.leArquivo();
    carregarTabela();  // já popula a tabela com os dados salvos
}

private void carregarTabela() {
    DefaultTableModel tabela = (DefaultTableModel) tbl_Pessoas.getModel();
    tabela.setRowCount(0);
    for (Pessoa p : listaPessoas) {
        tabela.addRow(p.obterDados());
    }
}
```

**Fluxo completo ao clicar em "Salvar":**
1. Validar seleção (radio, etc.).
2. Ler valores dos componentes (checkbox, combo, texto).
3. Criar objeto (`new Pessoa(...)`).
4. Adicionar na lista (`listaPessoas.add(p)`).
5. Gravar no arquivo (`arquivo.gravaArquivo()`).
6. Atualizar a tabela (limpar e repopular a partir da lista).
7. Limpar os campos do formulário.

> **Ponto-chave de prova:** entender o **ciclo completo** — Formulário → Objeto → Lista → Arquivo → Tabela. Isso é o "padrão" mais cobrado: dados sempre passam pela lista, e a lista é a única fonte usada tanto para gravar no arquivo quanto para exibir na tabela.

---

## 8. Checklist rápido 

| Componente | Classe | Método principal | Observação |
|---|---|---|---|
| Text Area | `JTextArea` | `append()`, `setText()` | Usar dentro de `JScrollPane` |
| Radio Button | `JRadioButton` | `isSelected()` | Precisa de `ButtonGroup` para exclusividade |
| Check Box | `JCheckBox` | `isSelected()` | Independentes entre si |
| Combo Box | `JComboBox` | `getSelectedItem()` | Retorna `Object`, fazer cast |
| Table | `JTable` + `DefaultTableModel` | `addRow()`, `setRowCount(0)` | Sempre popular a partir de uma `List` |
| Persistência | `FileWriter`/`FileReader` + `BufferedWriter`/`BufferedReader` | `readLine()`, `write()` | Separar campos por `;` e usar `split(";")` para ler |

**Padrão de arquitetura esperado (MVC simplificado):**
```
Formulário (JFrame)  →  Classe modelo (ex.: Pessoa)  →  List<Pessoa>  →  Classe Arquivo (leitura/gravação .txt)
                                                      ↘  JTable (exibição)
```
---

Conversa com o Gemini
resume isso # Complemento do Resumo — Aula 06



## 9. Edição e Exclusão de Elementos na `JTable`



A atividade da Aula 06 solicita que, além do cadastro, leitura e escrita em arquivos, o sistema permita a **exclusão e edição dos elementos já cadastrados**.



---



## 9.1 Exclusão de um elemento



Para excluir uma pessoa, primeiro é necessário identificar qual linha da `JTable` foi selecionada.



O método utilizado para isso é:



```java

int linha = tbl_Pessoas.getSelectedRow();

```



A variável `linha` recebe a posição da linha selecionada.



Se nenhuma linha estiver selecionada, o valor retornado é `-1`.



```java

if (linha == -1) {

JOptionPane.showMessageDialog(

null,

"Selecione uma pessoa para excluir."

);

return;

}

```



Depois de verificar a seleção, o elemento pode ser removido da lista:



```java

listaPessoas.remove(linha);

```



Após remover da lista, é necessário salvar novamente os dados no arquivo:



```java

arquivo.gravaArquivo();

```



E atualizar a tabela.



### Fluxo da exclusão



```text

Selecionar uma linha da JTable

↓

getSelectedRow()

↓

Verificar se existe seleção

↓

Remover da lista

↓

listaPessoas.remove(linha)

↓

Gravar no arquivo

↓

Atualizar a JTable

```



---



## 9.2 Edição de um elemento



Para editar um cadastro, primeiro o usuário seleciona uma pessoa na tabela e clica no botão `Editar`.



Primeiro, é obtida a linha selecionada:



```java

int linha = tbl_Pessoas.getSelectedRow();

```



Se nenhuma pessoa estiver selecionada:



```java

if (linha == -1) {

JOptionPane.showMessageDialog(

null,

"Selecione uma pessoa para editar."

);

return;

}

```



Depois, a linha selecionada é armazenada em uma variável chamada `linhaEdicao`:



```java

linhaEdicao = linha;

```



A variável `linhaEdicao` serve para guardar **qual posição da lista está sendo editada**.



No exemplo da aula, ela é inicializada com `-1`:



```java

private int linhaEdicao = -1;

```



O valor `-1` indica que **não existe nenhuma edição em andamento**.



---



## 9.3 Carregando os dados para edição



Depois de identificar a linha, o objeto correspondente é recuperado da lista:



```java

Pessoa p = listaPessoas.get(linha);

```



Os dados do objeto são então colocados novamente nos componentes do formulário.



Para o nome:



```java

txtNome.setText(p.nome);

```



Para o sexo:



```java

if (p.sexo == 'M') {

rdoMasculino.setSelected(true);

} else {

rdoFeminino.setSelected(true);

}

```



Para o idioma:



```java

cmb_Idioma.setSelectedItem(p.idioma);

```



Assim, ao clicar em `Editar`, os dados da pessoa selecionada são carregados no formulário para que o usuário possa modificá-los.



### Implementação da edição



```java

int linha = tbl_Pessoas.getSelectedRow();



if (linha == -1) {

JOptionPane.showMessageDialog(

null,

"Selecione uma pessoa para editar."

);

return;

}



linhaEdicao = linha;



Pessoa p = listaPessoas.get(linha);



txtNome.setText(p.nome);



if (p.sexo == 'M') {

rdoMasculino.setSelected(true);

} else {

rdoFeminino.setSelected(true);

}



cmb_Idioma.setSelectedItem(p.idioma);

```



---



## 9.4 Salvar uma edição



O botão `Salvar` precisa verificar se o usuário está:



- cadastrando uma nova pessoa; ou

- editando uma pessoa existente.



Para isso, é utilizada a variável `linhaEdicao`.



### Novo cadastro



Quando:



```java

linhaEdicao == -1

```



significa que não existe uma edição em andamento.



Nesse caso, o objeto é adicionado normalmente à lista:



```java

if (linhaEdicao == -1) {

listaPessoas.add(p);

}

```



### Editar cadastro existente



Quando:



```java

linhaEdicao != -1

```



significa que existe um cadastro sendo editado.



Nesse caso, o objeto antigo é substituído pelo novo:



```java

else {

listaPessoas.set(linhaEdicao, p);

linhaEdicao = -1;

}

```



O método `set()` substitui o elemento que está naquela posição da lista.



---



## 9.5 Código da lógica de Salvar



A lógica de salvar segue esta estrutura:



```java

String nome = txtNome.getText();



String idioma =

cmb_Idioma.getSelectedItem().toString();



Pessoa p = new Pessoa(nome, sexo, idioma);



if (linhaEdicao == -1) {

listaPessoas.add(p);

} else {

listaPessoas.set(linhaEdicao, p);

linhaEdicao = -1;

}



arquivo.gravaArquivo();

carregarTabela();

```



Depois de salvar:



```java

arquivo.gravaArquivo();

```



grava novamente os dados no arquivo.



E:



```java

carregarTabela();

```



atualiza os dados apresentados na tabela.



---



## 9.6 Diferença entre `add`, `set` e `remove`



Esses três métodos são importantes para a prática.



### `add()`



Adiciona um novo elemento à lista:



```java

listaPessoas.add(p);

```



Usado para **novo cadastro**.



### `set()`



Substitui um elemento existente:



```java

listaPessoas.set(linhaEdicao, p);

```



Usado para **edição**.



### `remove()`



Remove um elemento:



```java

listaPessoas.remove(linha);

```



Usado para **exclusão**.



### Resumindo



| Operação | Método | Função |

|---|---|---|

| Novo cadastro | `add()` | Adiciona um elemento |

| Edição | `set()` | Substitui um elemento |

| Exclusão | `remove()` | Remove um elemento |



---



## 9.7 Atualização da `JTable`



Depois de alterar a lista, a tabela precisa ser atualizada para apresentar os dados atuais.



A `JTable` é utilizada para exibir os dados em formato de tabela e permite recursos como:



- ordenação;

- seleção de células;

- edição de células.



Para atualizar a tabela:



```java

private void carregarTabela() {



DefaultTableModel tabela =

(DefaultTableModel) tbl_Pessoas.getModel();



tabela.setRowCount(0);



for (Pessoa p : listaPessoas) {

tabela.addRow(p.obterDados());

}

}

```



O método:



```java

tabela.setRowCount(0);

```



limpa as linhas existentes.



Depois:



```java

for (Pessoa p : listaPessoas) {

tabela.addRow(p.obterDados());

}

```



adiciona novamente os elementos da lista na tabela.



---



## 9.8 Fluxo completo do cadastro



```text

Preencher formulário

↓

Clicar em Salvar

↓

Criar objeto Pessoa

↓

Adicionar na lista

↓

Gravar no arquivo

↓

Atualizar JTable

```



---



## 9.9 Fluxo completo da edição



```text

Selecionar pessoa na JTable

↓

Clicar em Editar

↓

getSelectedRow()

↓

Guardar posição em linhaEdicao

↓

Buscar Pessoa na lista

↓

Carregar dados no formulário

↓

Alterar dados

↓

Clicar em Salvar

↓

listaPessoas.set(linhaEdicao, p)

↓

linhaEdicao = -1

↓

gravaArquivo()

↓

carregarTabela()

```



---



## 9.10 Fluxo completo da exclusão



```text

Selecionar pessoa na JTable

↓

Clicar em Excluir

↓

getSelectedRow()

↓

Verificar se existe seleção

↓

listaPessoas.remove(linha)

↓

gravaArquivo()

↓

Atualizar JTable

```



---



## 9.11 Métodos importantes para a avaliação prática



| Método | O que faz |

|---|---|

| `getSelectedRow()` | Obtém a linha selecionada da `JTable` |

| `get(linha)` | Obtém um objeto da lista pela posição |

| `add(objeto)` | Adiciona um novo objeto na lista |

| `set(posição, objeto)` | Substitui um objeto existente |

| `remove(posição)` | Remove um objeto da lista |

| `removeRow(linha)` | Remove uma linha da `JTable` |

| `setRowCount(0)` | Remove as linhas da tabela |

| `addRow()` | Adiciona uma linha na tabela |

| `gravaArquivo()` | Salva os dados no arquivo |

| `carregarTabela()` | Recarrega os dados da lista na tabela |

| `setText()` | Define o texto de um componente |

| `setSelected()` | Seleciona um `RadioButton` |

| `setSelectedItem()` | Seleciona um item do `ComboBox` |



---



## 9.12 O que a atividade da Aula 06 exige



A atividade final do PDF solicita criar um sistema de **cadastro de alunos**.



Cada aluno deve possuir:



- Nome completo;

- Data de nascimento no formato `DD/MM/AAAA`;

- Sexo;

- Matrícula, sendo um número único;

- Curso;

- CPF;

- Endereço completo:

- rua;

- número;

- bairro;

- cidade;

- CEP;

- Estado utilizando `ComboBox`;

- Telefone de contato.



Além disso, o sistema deve:



1. Utilizar classes;

2. Adicionar os dados em uma lista;

3. Apresentar os dados na tabela;

4. Implementar leitura e escrita em arquivos;

5. Salvar a lista em um arquivo texto;

6. Ao abrir o sistema, carregar a lista e apresentá-la na tabela;

7. Permitir a **exclusão e edição dos elementos já cadastrados**.



---



## 9.13 Resumo para memorizar



```text

ADD

→ Novo cadastro

→ listaPessoas.add(p)



SET

→ Editar cadastro

→ listaPessoas.set(linhaEdicao, p)



REMOVE

→ Excluir cadastro

→ listaPessoas.remove(linha)



GETSELECTEDROW

→ Descobrir qual linha foi selecionada

→ tbl_Pessoas.getSelectedRow()



LINHAEDICAO

→ Guardar qual cadastro está sendo editado

→ -1 = nenhum cadastro em edição



GRAVAARQUIVO

→ Salvar alterações no arquivo



CARREGARTABELA

→ Atualizar a JTable com os dados da lista

```



## O principal para a prova prática



```text

NOVO:

listaPessoas.add(p);



EDITAR:

listaPessoas.set(linhaEdicao, p);



EXCLUIR:

listaPessoas.remove(linha);



SELECIONAR LINHA:

tbl_Pessoas.getSelectedRow();



SALVAR:

arquivo.gravaArquivo();



ATUALIZAR TABELA:

carregarTabela();

```



## 9.14 Outros componentes da Aula 06



### `JTextArea`



A `JTextArea` permite trabalhar com várias linhas e colunas e adicionar textos dentro dela.



A diferença para o `JTextField` é que a `JTextArea` permite trabalhar com uma quantidade maior de linhas e colunas.



Para adicionar texto ao conteúdo existente, utiliza-se o método:



```java

append()

```



O método `append()` adiciona um novo conteúdo ao texto que já existe.



Também pode ser utilizada uma quebra de linha após cada mensagem adicionada.



---



### `JRadioButton`



O `JRadioButton` é utilizado para permitir que o usuário escolha **uma única opção** entre opções mutuamente exclusivas.



Sem agrupamento, dois `RadioButton` podem ser selecionados simultaneamente.



Para impedir isso, deve-se utilizar um:



```text

Button Group

```



O `Button Group` não aparece visualmente no formulário.



Para verificar qual opção está selecionada, utiliza-se:



```java

isSelected()

```



Na aula, é utilizada uma variável global do tipo `char` chamada:



```java

char sexo;

```



Exemplo:



```java

if (rdo_Masculino.isSelected()) {

sexo = 'M';

} else if (rdo_Feminino.isSelected()) {

sexo = 'F';

}

```



---



### `JCheckBox`



O `JCheckBox` permite que o usuário selecione ou desmarque **uma ou mais opções independentes**.



Diferentemente do `JRadioButton`, vários `CheckBox` podem ser selecionados ao mesmo tempo.



Na aula, são utilizados nomes como:



```text

chk_Tecnologia

chk_Astronomia

chk_Esportes

```



São declarados três atributos do tipo `boolean`.



Para verificar se um `CheckBox` está selecionado:



```java

isSelected()

```



Exemplo:



```java

tecnologia = chk_Tecnologia.isSelected();

astronomia = chk_Astronomia.isSelected();

esportes = chk_Esportes.isSelected();

```



---



### `JComboBox`



O `JComboBox` combina uma caixa de texto editável com uma lista suspensa de opções selecionáveis.



Ele pode ser utilizado para permitir que o usuário:



- escolha uma opção entre várias disponíveis;

- selecione uma opção predefinida;

- insira um valor personalizado por meio da caixa de texto.



Na aula, o `ComboBox` é utilizado para selecionar um idioma.



Exemplo:



```text

Espanhol

Inglês

Português

```



Para obter o item selecionado:



```java

String idioma =

(String) cmb_Idioma.getSelectedItem();

```



O método:



```java

getSelectedItem()

```



retorna o item selecionado.



---



### `JTable`



O `JTable` é um componente do Java utilizado para exibir dados em forma de tabela.



Ele permite a criação e exibição de tabelas de dados semelhantes às encontradas em:



- planilhas;

- aplicativos de banco de dados.



A `JTable` possui recursos como:



- ordenação;

- seleção de células;

- edição de células.



Para adicionar os dados na tabela, é criado um método na classe `Pessoa` que retorna um objeto com os atributos que serão adicionados à tabela.



Exemplo:



```java

public Object[] obterDados() {

return new Object[] {

nome,

sexo,

idioma

};

}

```



Depois, os dados podem ser adicionados à tabela:



```java

DefaultTableModel tabela =

(DefaultTableModel) tbl_Pessoas.getModel();



tabela.addRow(p.obterDados());

```



---



## 9.15 Lista de objetos e `JTable`



Os dados são armazenados em uma lista de objetos.



Exemplo:



```java

List<Pessoa> listaPessoas =

new ArrayList<>();

```



Ao cadastrar uma pessoa:



```java

listaPessoas.add(p);

```



Os elementos da lista podem ser apresentados na tabela:



```java

for (Pessoa pessoa : listaPessoas) {

tabela.addRow(pessoa.obterDados());

}

```



Para evitar que os dados antigos sejam duplicados na tabela, primeiro podem ser removidas as linhas:



```java

tabela.setRowCount(0);

```



Depois os elementos da lista são adicionados novamente:



```java

for (Pessoa pessoa : listaPessoas) {

tabela.addRow(pessoa.obterDados());

}

```



---



## 9.16 Limpeza dos dados



Depois de salvar os dados, os campos do formulário podem ser limpos.



Exemplo:



```java

txtNome.setText("");

```



Para limpar a seleção dos `RadioButton`:



```java

btnGrpSexo.clearSelection();

```



Para desmarcar os `CheckBox`:



```java

chk_Tecnologia.setSelected(false);

chk_Astronomia.setSelected(false);

chk_Esportes.setSelected(false);

```



Para voltar o `ComboBox` para o primeiro item:



```java

cmb_Idioma.setSelectedIndex(0);

```



Para limpar as linhas da tabela:



```java

tabela.setRowCount(0);

```



---



## 9.17 Leitura e escrita em arquivos



A atividade da Aula 06 solicita a implementação de **leitura e escrita em arquivos**.



A lista deve ser salva em um **arquivo texto**.



Ao abrir o sistema, os dados salvos devem ser carregados e apresentados na tabela.



Na atividade são trabalhados:



```java

FileWriter

BufferedWriter

FileReader

BufferedReader

```



O objetivo é:



```text

Lista

↓

Salvar no arquivo texto

↓

Fechar o sistema

↓

Abrir o sistema novamente

↓

Ler o arquivo

↓

Carregar a lista

↓

Apresentar os dados na JTable

```



---



# Resumo geral da Aula 06 para a avaliação



## Componentes



| Componente | Função principal |

|---|---|

| `JTextArea` | Trabalhar com várias linhas e colunas de texto |

| `JRadioButton` | Escolher uma opção entre opções mutuamente exclusivas |

| `Button Group` | Agrupar `RadioButton` para permitir apenas uma seleção |

| `JCheckBox` | Selecionar uma ou mais opções independentes |

| `JComboBox` | Selecionar opções em uma lista suspensa |

| `JTable` | Exibir dados em formato de tabela |



## Métodos principais



```text

append()

→ Adiciona texto ao conteúdo existente.



isSelected()

→ Verifica se um componente está selecionado.



getSelectedItem()

→ Obtém o item selecionado do ComboBox.



getSelectedRow()

→ Obtém a linha selecionada da JTable.



add()

→ Adiciona um elemento na lista.



get()

→ Obtém um elemento da lista.



set()

→ Substitui um elemento da lista.



remove()

→ Remove um elemento da lista.



addRow()

→ Adiciona uma linha na JTable.



removeRow()

→ Remove uma linha da JTable.



setRowCount(0)

→ Limpa as linhas da JTable.



setText()

→ Define o texto de um componente.



setSelected()

→ Seleciona ou desmarca um componente.



setSelectedItem()

→ Define o item selecionado no ComboBox.



gravaArquivo()

→ Salva os dados no arquivo.



carregarTabela()

→ Carrega os dados da lista para a JTable.

```



## Operações da lista



```text

CADASTRAR:

listaPessoas.add(p);



EDITAR:

listaPessoas.set(linhaEdicao, p);



EXCLUIR:

listaPessoas.remove(linha);

```



## Operações da `JTable`



```text

OBTER LINHA SELECIONADA:

tbl_Pessoas.getSelectedRow();



ADICIONAR LINHA:

tabela.addRow(...);



REMOVER LINHA:

tabela.removeRow(linha);



LIMPAR TABELA:

tabela.setRowCount(0);

```



## Edição



```text

Selecionar linha

↓

getSelectedRow()

↓

linhaEdicao = linha

↓

Buscar objeto na lista

↓

Carregar dados no formulário

↓

Alterar dados

↓

Salvar

↓

listaPessoas.set(linhaEdicao, p)

```



## Exclusão



```text

Selecionar linha

↓

getSelectedRow()

↓

Verificar seleção

↓

listaPessoas.remove(linha)

↓

gravaArquivo()

↓

Atualizar JTable

```



## Cadastro de alunos da atividade



```text

Nome completo

Data de nascimento — DD/MM/AAAA

Sexo

Matrícula — número único

Curso

CPF

Endereço completo

Rua

Número

Bairro

Cidade

CEP

Estado — ComboBox

Telefone de contato

```



O sistema deve utilizar **classes**, armazenar os dados em uma **lista**, apresentar os dados em uma **tabela**, implementar **leitura e escrita em arquivos**, salvar a lista em um **arquivo texto**, carregar os dados ao abrir o sistema e permitir a **edição e exclusão dos elementos já cadastrados**.

Este documento aborda a manipulação de interfaces Java Swing, detalhando a integração entre formulários visuais, a tabela JTable, coleções em memória (ArrayList) e arquivos texto para realizar operações completas de CRUD (Cadastro, Leitura, Edição e Exclusão).

Lógica das Operações CRUD

Obter Seleção: int linha = tbl_Pessoas.getSelectedRow(); (retorna -1 se nada estiver selecionado).

Novo Cadastro (add): Se a variável de controle linhaEdicao == -1, o novo objeto é inserido na lista via listaPessoas.add(p).

Edição (set): Guarda o índice em linhaEdicao = linha, extrai o objeto da lista e preenche os campos do formulário. Ao clicar em salvar, executa listaPessoas.set(linhaEdicao, p) e restaura linhaEdicao = -1.

Exclusão (remove): Remove o registro selecionado da lista com listaPessoas.remove(linha).

Sincronização: Toda alteração (cadastro, edição ou exclusão) deve ser seguida do salvamento no disco (arquivo.gravaArquivo()) e da atualização da tabela visual (carregarTabela()).

Métodos Principais

Categoria	Método	Função
Lista (ArrayList)	add(p)	Adiciona um novo objeto à lista.
set(posicao, p)	Substitui o objeto na posição indicada (edição).
remove(posicao)	Remove o objeto da lista (exclusão).
get(posicao)	Busca o objeto no índice especificado.
Tabela (JTable)	getSelectedRow()	Retorna o índice da linha selecionada (ou -1).
setRowCount(0)	Limpa todas as linhas do modelo da tabela.
addRow(Object[])	Insere uma nova linha de dados na tabela.
Componentes de Tela	setText() / append()	Define texto em campos ou concatena no JTextArea.
isSelected()	Retorna true se JRadioButton ou JCheckBox estiver marcado.
getSelectedItem()	Recupera o valor selecionado no JComboBox.
clearSelection()	Desmarca seleções ativas em um ButtonGroup.
Componentes de Interface (Swing)

JTable: Exibe dados organizados via DefaultTableModel. Requer um método no modelo de dados (ex: obterDados()) retornando Object[] com os atributos do objeto.

JRadioButton: Escolha única entre opções exclusivas. Exige agrupamento em um ButtonGroup.

JCheckBox: Opções independentes de múltipla escolha.

JComboBox: Lista suspensa de seleção única.

JTextArea: Campo para múltiplas linhas de texto. Usa append() para adicionar novos conteúdos.

Requisitos da Atividade (Cadastro de Alunos)

Dados do Aluno: Nome completo, Data de Nascimento (DD/MM/AAAA), Sexo, Matrícula (única), Curso, CPF, Endereço completo (Rua, Nº, Bairro, Cidade, CEP, Estado via JComboBox) e Telefone.

Regras do Sistema: Estrutura orientada a objetos (POO), persistência de dados em arquivo texto via BufferedReader/BufferedWriter (carregamento automático ao abrir o sistema e salvamento ao alterar), exibição em JTable e suporte a edição/exclusão de registros.

em arquivo .md

Nota: O método getSelectedRow() retorna -1 caso o usuário não tenha selecionado nenhuma linha.

2.2 Exclusão de Registro (remove)
A exclusão remove o item da lista em memória, atualiza o arquivo no disco e recarrega a tabela visual.

Java
listaPessoas.remove(linha); // Remove da lista
arquivo.gravaArquivo();     // Grava a lista atualizada no arquivo
carregarTabela();           // Recarrega a JTable
2.3 Edição de Registro (set e linhaEdicao)
Para editar um registro sem duplicá-lo, utiliza-se uma variável de controle no formulário:

Java
private int linhaEdicao = -1; // -1 indica que NÃO há edição em andamento
Passo 1: Carregar os dados no formulário
Java
int linha = tbl_Pessoas.getSelectedRow();
if (linha == -1) {
    JOptionPane.showMessageDialog(null, "Selecione uma pessoa para editar.");
    return;
}

linhaEdicao = linha; // Armazena a posição que está sendo editada
Pessoa p = listaPessoas.get(linha);

// Preenche os componentes da tela com os dados obtidos
txtNome.setText(p.nome);

if (p.sexo == 'M') {
    rdoMasculino.setSelected(true);
} else {
    rdoFeminino.setSelected(true);
}

cmb_Idioma.setSelectedItem(p.idioma);
Passo 2: Salvar (Diferenciando Novo Cadastro de Edição)
Java
String nome = txtNome.getText();
String idioma = cmb_Idioma.getSelectedItem().toString();
Pessoa p = new Pessoa(nome, sexo, idioma);

if (linhaEdicao == -1) {
    // Modo Cadastro
    listaPessoas.add(p);
} else {
    // Modo Edição
    listaPessoas.set(linhaEdicao, p);
    linhaEdicao = -1; // Reseta o estado de edição
}

arquivo.gravaArquivo();
carregarTabela();
limparCampos();
3. Comparativo das Operações de Lista (List)
Operação	Método da Lista	Descrição
Novo Cadastro	add(p)	Adiciona um novo objeto ao final da lista.
Edição	set(posicao, p)	Substitui o objeto existente na posição especificada.
Exclusão	remove(posicao)	Remove o objeto da posição especificada da lista.
Consulta	get(posicao)	Recupera a referência do objeto localizado no índice.
4. Atualização e Limpeza da JTable e Formulário
Recarregando a JTable
Para evitar a duplicação de dados na interface, a tabela deve ter suas linhas zeradas antes de recarregar a lista:

Java
private void carregarTabela() {
    DefaultTableModel tabela = (DefaultTableModel) tbl_Pessoas.getModel();
    tabela.setRowCount(0); // Limpa as linhas atuais da tabela

    for (Pessoa p : listaPessoas) {
        tabela.addRow(p.obterDados()); // Adiciona cada pessoa novamente
    }
}
Reset dos Componentes do Formulário
Java
private void limparCampos() {
    txtNome.setText("");
    btnGrpSexo.clearSelection();
    chk_Tecnologia.setSelected(false);
    cmb_Idioma.setSelectedIndex(0);
}
5. Componentes de Interface Grafica (Java Swing)
JTextArea: Permite entrada/exibição de múltiplas linhas de texto. Utiliza o método append("texto\\n") para concatenar mensagens sem apagar o conteúdo existente.

JRadioButton e ButtonGroup: Utilizados para escolhas mutuamente exclusivas (ex: Sexo Masculino/Feminino). Devem ser vinculados a um ButtonGroup no Swing para garantir que apenas um fique ativo. A verificação é feita com isSelected().

JCheckBox: Utilizado para seleções independentes e múltiplas. Cada caixa é avaliada individualmente com isSelected().

JComboBox: Caixa de seleção suspensa (dropdown).

getSelectedItem(): Retorna o objeto/item selecionado.

setSelectedItem(valor): Define o item visível por valor.

setSelectedIndex(0): Volta para o primeiro item padrão.

JTable: Exibe coleções de dados estruturados em linhas e colunas através do DefaultTableModel.

6. Persistência em Arquivos Texto (I/O)
A leitura e escrita em disco garantem que os dados não sejam perdidos após o encerramento do sistema.

Escrita: FileWriter e BufferedWriter para salvar os dados da List no arquivo texto.

Leitura: FileReader e BufferedReader para ler o arquivo linha por linha ao iniciar o sistema e reconstruir a List.

Fluxo da Persistência:
Ao abrir o sistema: Ler arquivo → Preencher List<Pessoa> → Executar carregarTabela().

Ao salvar/editar/excluir: Alterar List<Pessoa> → Executar gravaArquivo() → Executar carregarTabela().

7. Métodos Essenciais para Prática e Prova
Plaintext
+---------------------+---------------------------------------------------------+
| Método              | Descrição / Finalidade                                  |
+---------------------+---------------------------------------------------------+
| getSelectedRow()    | Obtém a linha selecionada na JTable (-1 se nenhuma).   |
| setRowCount(0)      | Limpa todas as linhas visíveis do DefaultTableModel.   |
| addRow()            | Adiciona um array de objetos Object[] como nova linha.  |
| add(objeto)         | Insere um elemento na coleção ArrayList.                |
| set(pos, objeto)    | Substitui um elemento na coleção no índice especificado.|
| remove(pos)         | Remove o elemento da coleção no índice indicado.        |
| append()            | Adiciona texto ao final do JTextArea.                  |
| isSelected()        | Retorna true/false indicando seleção de Radio/CheckBox. |
| getSelectedItem()   | Retorna o item selecionado em um JComboBox.             |
| gravaArquivo()      | Grava o estado atual da lista no disco rígido.          |
| carregarTabela()    | Sincroniza os dados da List com o modelo da JTable.     |
+---------------------+---------------------------------------------------------+
8. Requisitos da Atividade de Cadastro de Alunos (Aula 06)
A atividade prática exige a criação de um sistema de Cadastro de Alunos contendo:

Atributos do Aluno: Nome Completo, Data de Nascimento (DD/MM/AAAA), Sexo, Matrícula (única), Curso, CPF, Endereço Completo (Rua, Nº, Bairro, Cidade, CEP, Estado via JComboBox) e Telefone de Contato.

Requisitos do Sistema:

Utilização de Classes e Orientação a Objetos.

Uso de ArrayList para gerenciar a coleção em memória.

Apresentação dos dados na JTable.

Leitura e escrita em arquivos texto.

Carga automática dos dados gravados ao iniciar a aplicação.

Funcionalidades completas de Inserção, Edição e Exclusão.
"""

file_path = "Resumo_Aula_06_JTable_Swing.md"
with open(file_path, "w", encoding="utf-8") as f:
f.write(md_content)

print(f"File created successfully: {file_path}")


```text?code_stdout&code_event_index=1
File created successfully: Resumo_Aula_06_JTable_Swing.md

Seu arquivo Markdown foi gerado com sucesso!

Ícone do app MD
Resumo_Aula_06_JTable_Swing
 MD 
Conteúdo do Resumo Organizado no Arquivo:
Visão Geral e Arquitetura: Integração entre a classe modelo, a lista em memória (ArrayList) e o componente visual (JTable).

Operações de CRUD (Inserção, Leitura, Edição e Exclusão):

Verificação de seleção com getSelectedRow().

Lógica do ponteiro de controle linhaEdicao (-1 para novo cadastro vs. índice para edição).

Uso dos métodos de lista: add(), set(), remove() e get().

Componentes do Java Swing:

JTable e DefaultTableModel: setRowCount(0) e addRow().

JTextArea: Utilização de append().

JRadioButton + ButtonGroup: Seleção única com isSelected().

JCheckBox e JComboBox: Múltiplas escolhas e listas suspensas (getSelectedItem(), setSelectedIndex()).

Persistência de Dados (I/O):

Leitura (BufferedReader / FileReader) e Escrita (BufferedWriter / FileWriter).

Ciclo de vida da gravação e carregamento automático ao iniciar o sistema.

Tabelas de Referência Prática: Métodos indispensáveis para a avaliação e requisitos completos da atividade de Cadastro de Alunos.




O Gemini é uma IA e pode cometer erros.

Analisando
# Resumo de Estudo — Aula 06: Java Swing, JTable e Persistência de Dados

Este resumo aborda os conceitos fundamentais da **Aula 06**, com foco na criação de interfaces gráficas em **Java Swing**, manipulação da tabela `JTable`, gerenciamento de coleções com `ArrayList` (CRUD) e persistência de dados em arquivos de texto (`FileReader`/`FileWriter`).

---

## 1. Visão Geral do CRUD em memória e Interface

Para gerenciar dados em uma aplicação Java Swing com `JTable`, utilizamos uma estrutura baseada em três pilares:

1. **Modelo de Dados (Classe / Entidade):** Represeta o objeto (ex: `Pessoa` ou `Aluno`) e possui um método como `obterDados()` que retorna um array de objetos `Object[]` para preencher a tabela.
2. **Coleção em Memória (`ArrayList`):** Armazena os objetos ativos na memória durante a execução do sistema.
3. **Componente Visual (`JTable` + `DefaultTableModel`):** Exibe visualmente os elementos contidos na lista.

---

## 2. Operações Fundamentais na `JTable` e `ArrayList`

### 2.1 Identificação da Linha Selecionada
Para editar ou excluir um registro, o primeiro passo é identificar a linha selecionada na `JTable`:

```java
int linha = tbl_Pessoas.getSelectedRow();

if (linha == -1) {
    JOptionPane.showMessageDialog(null, "Selecione um elemento na tabela.");
    return;
}
```
* **Nota:** O método `getSelectedRow()` retorna `-1` caso o usuário não tenha selecionado nenhuma linha.

---

### 2.2 Exclusão de Registro (`remove`)
A exclusão remove o item da lista em memória, atualiza o arquivo no disco e recarrega a tabela visual.

```java
listaPessoas.remove(linha); // Remove da lista
arquivo.gravaArquivo();     // Grava a lista atualizada no arquivo
carregarTabela();           // Recarrega a JTable
```

---

### 2.3 Edição de Registro (`set` e `linhaEdicao`)
Para editar um registro sem duplicá-lo, utiliza-se uma variável de controle no formulário:

```java
private int linhaEdicao = -1; // -1 indica que NÃO há edição em andamento
```

#### Passo 1: Carregar os dados no formulário
```java
int linha = tbl_Pessoas.getSelectedRow();
if (linha == -1) {
    JOptionPane.showMessageDialog(null, "Selecione uma pessoa para editar.");
    return;
}

linhaEdicao = linha; // Armazena a posição que está sendo editada
Pessoa p = listaPessoas.get(linha);

// Preenche os componentes da tela com os dados obtidos
txtNome.setText(p.nome);

if (p.sexo == 'M') {
    rdoMasculino.setSelected(true);
} else {
    rdoFeminino.setSelected(true);
}

cmb_Idioma.setSelectedItem(p.idioma);
```

#### Passo 2: Salvar (Diferenciando Novo Cadastro de Edição)
```java
String nome = txtNome.getText();
String idioma = cmb_Idioma.getSelectedItem().toString();
Pessoa p = new Pessoa(nome, sexo, idioma);

if (linhaEdicao == -1) {
    // Modo Cadastro
    listaPessoas.add(p);
} else {
    // Modo Edição
    listaPessoas.set(linhaEdicao, p);
    linhaEdicao = -1; // Reseta o estado de edição
}

arquivo.gravaArquivo();
carregarTabela();
limparCampos();
```

---

## 3. Comparativo das Operações de Lista (`List`)

| Operação | Método da Lista | Descrição |
| :--- | :--- | :--- |
| **Novo Cadastro** | `add(p)` | Adiciona um novo objeto ao final da lista. |
| **Edição** | `set(posicao, p)` | Substitui o objeto existente na posição especificada. |
| **Exclusão** | `remove(posicao)` | Remove o objeto da posição especificada da lista. |
| **Consulta** | `get(posicao)` | Recupera a referência do objeto localizado no índice. |

---

## 4. Atualização e Limpeza da `JTable` e Formulário

### Recarregando a `JTable`
Para evitar a duplicação de dados na interface, a tabela deve ter suas linhas zeradas antes de recarregar a lista:

```java
private void carregarTabela() {
    DefaultTableModel tabela = (DefaultTableModel) tbl_Pessoas.getModel();
    tabela.setRowCount(0); // Limpa as linhas atuais da tabela

    for (Pessoa p : listaPessoas) {
        tabela.addRow(p.obterDados()); // Adiciona cada pessoa novamente
    }
}
```

### Reset dos Componentes do Formulário
```java
private void limparCampos() {
    txtNome.setText("");
    btnGrpSexo.clearSelection();
    chk_Tecnologia.setSelected(false);
    cmb_Idioma.setSelectedIndex(0);
}
```

---

## 5. Componentes de Interface Grafica (Java Swing)

* **`JTextArea`:** Permite entrada/exibição de múltiplas linhas de texto. Utiliza o método `append("texto\n")` para concatenar mensagens sem apagar o conteúdo existente.
* **`JRadioButton` e `ButtonGroup`:** Utilizados para escolhas mutuamente exclusivas (ex: Sexo Masculino/Feminino). Devem ser vinculados a um `ButtonGroup` no Swing para garantir que apenas um fique ativo. A verificação é feita com `isSelected()`.
* **`JCheckBox`:** Utilizado para seleções independentes e múltiplas. Cada caixa é avaliada individualmente com `isSelected()`.
* **`JComboBox`:** Caixa de seleção suspensa (dropdown).
  * `getSelectedItem()`: Retorna o objeto/item selecionado.
  * `setSelectedItem(valor)`: Define o item visível por valor.
  * `setSelectedIndex(0)`: Volta para o primeiro item padrão.
* **`JTable`:** Exibe coleções de dados estruturados em linhas e colunas através do `DefaultTableModel`.

---

## 6. Persistência em Arquivos Texto (I/O)

A leitura e escrita em disco garantem que os dados não sejam perdidos após o encerramento do sistema.

* **Escrita:** `FileWriter` e `BufferedWriter` para salvar os dados da `List` no arquivo texto.
* **Leitura:** `FileReader` e `BufferedReader` para ler o arquivo linha por linha ao iniciar o sistema e reconstruir a `List`.

### Fluxo da Persistência:
1. **Ao abrir o sistema:** Ler arquivo → Preencher `List<Pessoa>` → Executar `carregarTabela()`.
2. **Ao salvar/editar/excluir:** Alterar `List<Pessoa>` → Executar `gravaArquivo()` → Executar `carregarTabela()`.

---

## 7. Métodos Essenciais para Prática e Prova

```text
+---------------------+---------------------------------------------------------+
| Método              | Descrição / Finalidade                                  |
+---------------------+---------------------------------------------------------+
| getSelectedRow()    | Obtém a linha selecionada na JTable (-1 se nenhuma).   |
| setRowCount(0)      | Limpa todas as linhas visíveis do DefaultTableModel.   |
| addRow()            | Adiciona um array de objetos Object[] como nova linha.  |
| add(objeto)         | Insere um elemento na coleção ArrayList.                |
| set(pos, objeto)    | Substitui um elemento na coleção no índice especificado.|
| remove(pos)         | Remove o elemento da coleção no índice indicado.        |
| append()            | Adiciona texto ao final do JTextArea.                  |
| isSelected()        | Retorna true/false indicando seleção de Radio/CheckBox. |
| getSelectedItem()   | Retorna o item selecionado em um JComboBox.             |
| gravaArquivo()      | Grava o estado atual da lista no disco rígido.          |
| carregarTabela()    | Sincroniza os dados da List com o modelo da JTable.     |
+---------------------+---------------------------------------------------------+
```

---
