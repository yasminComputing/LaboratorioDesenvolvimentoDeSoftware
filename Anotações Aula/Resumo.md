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

