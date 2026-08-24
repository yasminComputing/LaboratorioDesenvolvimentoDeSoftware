# Aula 02 - Dia 05.08.2026

---

## Java Swing

O **Java Swing** é uma biblioteca gráfica do Java utilizada para criar **interfaces gráficas de usuário (GUI - Graphical User Interface)**.

Com o Swing, pode ser criado aplicações com elementos visuais e interativos, como:

* Janelas;
* Botões;
* Campos de texto;
* Labels;
* Caixas de seleção;
* Menus;
* Painéis;
* Caixas de diálogo.

O Swing facilita o desenvolvimento de aplicações desktop e permite trabalhar com diferentes componentes de uma interface gráfica.

---

## JFrame

O `JFrame` representa a **janela principal da aplicação**.

É onde podemos criar o formulário e adicionar os demais componentes da interface, como botões, campos de texto, labels e painéis.

Exemplo:

```java
JFrame janela = new JFrame();
```

No **NetBeans**, quando criamos um formulário, o `JFrame` representa a janela onde será desenvolvido o formulário.

---

## JPanel

O `JPanel` é um **painel utilizado para organizar e agrupar componentes** dentro de uma janela.

Podemos adicionar dentro dele:

* Botões;
* Labels;
* Campos de texto;
* Outros componentes.

Exemplo:

```java
JPanel painel = new JPanel();
```

Para adicionar um componente ao painel:

```java
painel.add(btnSalvar);
```

> O `JPanel` não é utilizado somente para alertas. Sua principal função é organizar os componentes da interface.

---

## JButton

O `JButton` representa um **botão** que pode executar uma determinada ação quando o usuário clicar nele.

Exemplo:

```java
JButton btnSalvar = new JButton("Salvar");
```

Nesse exemplo:

* `JButton` → tipo do componente;
* `btnSalvar` → nome da variável;
* `"Salvar"` → texto que aparece no botão.

---

## JOptionPane

O `JOptionPane` é utilizado para exibir **mensagens e caixas de diálogo** para o usuário.

### Mensagem de aviso

```java
JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso!");
```

Esse comando faz aparecer uma janela com a mensagem:

```text
Pessoa salva com sucesso!
```

Também podemos definir o título e o tipo da mensagem:

```java
JOptionPane.showMessageDialog(
    null,
    "Pessoa salva com sucesso!",
    "Sucesso",
    JOptionPane.INFORMATION_MESSAGE
);
```

Alguns tipos de mensagens:

```java
JOptionPane.INFORMATION_MESSAGE
JOptionPane.WARNING_MESSAGE
JOptionPane.ERROR_MESSAGE
JOptionPane.QUESTION_MESSAGE
```

---

## JTextField

O `JTextField` é utilizado para criar um **campo onde o usuário pode digitar informações**.

Exemplo:

```java
JTextField txtNome = new JTextField();
```

Podemos definir o tamanho do campo:

```java
JTextField txtNome = new JTextField(20);
```

### Pegar o texto digitado

Para obter o conteúdo digitado pelo usuário:

```java
String nome = txtNome.getText();
```

### Limpar o campo

Para apagar o conteúdo:

```java
txtNome.setText("");
```

---

## JLabel

O `JLabel` é utilizado para **exibir textos na interface**.

Normalmente é utilizado para identificar os campos de um formulário.

Exemplo:

```java
JLabel lblNome = new JLabel("Nome:");
```

Podemos ter:

```text
Nome: [________________]
```

Nesse caso:

```java
JLabel lblNome = new JLabel("Nome:");
JTextField txtNome = new JTextField();
```

---

## Eventos

No Swing, podemos criar **eventos** para determinar o que deve acontecer quando o usuário interagir com um componente.

Por exemplo:

* Clicar em um botão;
* Digitar em um campo;
* Selecionar uma opção;
* Fechar uma janela.

Um dos eventos mais utilizados é o evento de **clique em um botão**.

### ActionListener

Podemos utilizar um `ActionListener` para executar uma ação quando o botão for clicado.

Exemplo:

```java
btnSalvar.addActionListener(e -> {
    JOptionPane.showMessageDialog(
        null,
        "Pessoa salva com sucesso!"
    );
});
```

Nesse caso, quando o usuário clicar no botão `btnSalvar`, será exibida a mensagem.

---

## Padrão para nomear os componentes

É importante utilizar um padrão para nomear os componentes. Isso facilita a organização e a leitura do código.

Alguns exemplos:

| Componente     | Prefixo | Exemplo        |
| -------------- | ------- | -------------- |
| `JButton`      | `btn`   | `btnSalvar`    |
| `JTextField`   | `txt`   | `txtNome`      |
| `JLabel`       | `lbl`   | `lblNome`      |
| `JPanel`       | `pnl`   | `pnlCadastro`  |
| `JFrame`       | `frm`   | `frmPrincipal` |
| `JComboBox`    | `cmb`   | `cmbCidade`    |
| `JCheckBox`    | `chk`   | `chkAceito`    |
| `JRadioButton` | `rdb`   | `rdbMasculino` |

Por exemplo, em um formulário de cadastro:

```text
lblNome       → Label "Nome:"
txtNome       → Campo para inserir o nome

lblIdade      → Label "Idade:"
txtIdade      → Campo para inserir a idade

btnSalvar     → Botão "Salvar"
btnCancelar   → Botão "Cancelar"
```

---

## Design e Properties

No **NetBeans**, podemos criar a interface utilizando a aba **Design**.

Ao selecionar um componente, suas propriedades aparecem na aba **Properties**.

Por exemplo, em um botão podemos alterar:

* `text` → texto que aparece no botão;
* `font` → fonte;
* `foreground` → cor do texto;
* `background` → cor de fundo;
* `enabled` → define se o componente está habilitado;
* `visible` → define se o componente está visível.

Também podemos alterar o **Variable Name**, que define o nome utilizado para identificar o componente no código.

Por exemplo:

```text
Variable Name: btnSalvar
Text: Salvar
```

No código, o botão será identificado como:

```java
btnSalvar
```

---

## Comandos importantes

### Adicionar um componente

```java
painel.add(btnSalvar);
```

Adiciona o botão `btnSalvar` ao painel.

### Pegar o texto de um campo

```java
String nome = txtNome.getText();
```

Obtém o texto digitado no campo `txtNome`.

### Alterar o texto

```java
lblNome.setText("Novo nome");
```

Altera o texto de um componente.

### Limpar um campo

```java
txtNome.setText("");
```

Remove o conteúdo do campo.

### Alterar o texto de um botão

```java
btnSalvar.setText("Cadastrar");
```

Altera o texto exibido no botão.

### Habilitar um componente

```java
btnSalvar.setEnabled(true);
```

### Desabilitar um componente

```java
btnSalvar.setEnabled(false);
```

### Exibir uma mensagem

```java
JOptionPane.showMessageDialog(
    null,
    "Operação realizada com sucesso!"
);
```

---

## Exemplo de formulário

Um formulário simples de cadastro de pessoa poderia ter:

```text
---------------------------------
|       Cadastro de Pessoa      |
|                               |
| Nome:  [__________________]   |
|                               |
| Idade: [__________________]   |
|                               |
|       [ Salvar ] [Cancelar]   |
---------------------------------
```

Os componentes poderiam ser nomeados como:

```text
lblNome       → JLabel
txtNome       → JTextField

lblIdade      → JLabel
txtIdade      → JTextField

btnSalvar     → JButton
btnCancelar   → JButton
```

Ao clicar no botão `btnSalvar`, podemos pegar os dados digitados:

```java
String nome = txtNome.getText();
String idade = txtIdade.getText();
```

E depois apresentar uma mensagem:

```java
JOptionPane.showMessageDialog(
    null,
    "Nome: " + nome + "\nIdade: " + idade
);
```

---
pnlCadastro
```