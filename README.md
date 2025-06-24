
# Javetteria

## ☕ Descrição do Projeto
Javetteria é o nome do sistema da cafeteria desenvolvido como um **projeto da materia de desenvolvimento de software para compor a nota da A1**, ele **simula** e otimiza a gestão interna de um estabelecimento real abrangendo o controle de estoque e o registro de pedidos, além de gerenciar o cardápio. O sistema também permite cadastro e gerenciamento de novos clientes/funcionarios/gerentes.
## ✨ Funcionalidades Principais
* **Autenticação e Gerenciamento de Acesso:** Login de usuários, diferenciação de perfis (cliente, funcionário, gerente).

* **Gerenciamento de Cardápio:** Visualização de produtos, busca por categoria.

* **Controle de Estoque:** Listagem, adição, remoção, atualização de itens de estoque.

* **Gerenciamento de Pedidos:** Criação, modificação, registro de pedidos.

* **Processamento de Pagamentos:** Lida com diferentes formas de pagamento.

* **Gestão de Usuários:** Cadastro de novos clientes, funcionários e gerentes, e gestão de seus dados.

* **Estrutura de Menus Interativos:** Estrutura de menus para navegação e interação do usuário.

* **Dados Persistidos:** Armazenamento de dados em arquivos de texto para clientes, funcionários, gerentes e pedidos.

## 🚀 Como Executar o Projeto


1.  **Pré-requisitos:**

    * Uma IDE como IntelliJ IDEA, Eclipse ou VS Code com extensões Java.
2.  **Passos:**
    * Clone o repositório para sua máquina local
    * Abra o projeto na sua IDE.
    * Configure o Java Development Kit (JDK)
    * Compile o projeto
    * Execute a classe `Main.java` .
    * Certifique-se (PORFAVOR) de que a pasta `data` (usada para persistência) existe na raiz do projeto.

## 📐 Diagrama de Classes

![diagrama](https://github.com/user-attachments/assets/ab7da602-86af-4337-b809-1bfdb5ec8b46)


## 👥 Membros da Equipe e Módulos

### Bruna Amaral Chapelin - Módulo: **Administração e Sistema Principal**
* **Responsabilidades:** Desenvolvimento da estrutura principal do sistema, incluindo o ponto de entrada (`Main`), a arquitetura de menus (`MenuInterativo`, `MenuCliente`, `MenuFuncionario`, `MenuGerente`, `Menu`) e o gerenciamento do módulo de Estoque.
* **Principais Contribuições:**
    * Definição e implementação da **estrutura de navegação** e experiência do usuário no sistema.
    * Desenvolvimento completo do módulo de **Controle de Estoque**, abrangendo Model (`Estoque`, `Ingrediente`), Controller (`EstoqueController`) e View (`EstoqueView`), incluindo funcionalidades de listagem, adição, remoção e atualização de itens.
    * Criação da classe utilitária `Cores`, que padroniza a formatação de mensagens com cores no terminal para todo o projeto.
    * Responsável pela implementação de todos os módulos no corpo principal do código.
    * Coordenação da **inicialização e fluxo principal** do sistema através da classe `Main`.

### Rebecca Beccari Fagundes - Módulo: **Cardápio e Produtos**
* **Responsabilidades:** Desenvolvimento na camada Model (classes `Produto`, `Comidas`, `Bebidas`, `CategoriaProduto`, `Cardapio`), Controller (`CardapioController`) e View (`CardapioView`) **específicas para o gerenciamento e exibição do cardápio.**
* **Principais Contribuições:**
    * Implementação da **Hierarquia de Classes de Produto** com herança e polimorfismo, permitindo diferentes tipos de itens no cardápio (`Comidas`, `Bebidas`) e descrições detalhadas personalizadas.
    * Estruturação do **Cardápio principal** como um repositório central de produtos.
    * Desenvolvimento da **CardapioView** (para visualização completa da mesma) e busca por categoria, utilizando a **Stream API** para organização eficiente de dados.
    * Adoção de um design **Orientado a Objetos (não-estático)** para as camadas Controller e View, promovendo encapsulamento, flexibilidade e testabilidade.
    * Utilização das classes utilitárias `InputHelper` (para entrada de dados robusta) e `Cores` (para aprimoramento visual das mensagens).


### Matheus Silva dos Santos - Módulo: **clientes e Funcionários**
* **Responsabilidades:** Desenvolvimento das classes da camada Model (`Pessoa`, `Cliente`, `Funcionario`, `Gerente`,`endereco`) que representam os diferentes tipos de usuários do sistema. Implementação da interface `ContaUsuario`. Desenvolvimento dos Controllers(`UsuarioController`, `LoginController`) e da View (`Acessar`) relacionados à gestão de usuários e processo de autenticação.
* **Principais Contribuições:**
    * Criação da classe **`Pessoa` como superclasse** para a hierarquia de usuários, definindo atributos e comportamentos comuns.
    * Desenvolvimento das classes **`Cliente`, `Funcionario` e `Gerente`** com suas especificidades e a interface `ContaUsuario` para padronização.
    * Implementação da classe `Endereco` para modelar as informações de endereço dos usuários.
    * Implementação do **sistema de autenticação e login** através do `LoginController` e da View `Acessar`.
    * Criação do `UsuarioController` para gerenciar as operações CRUD (Criação, Leitura, Atualização, Exclusão) de usuários no sistema.

### Arthur Soares Padia - Módulo: **Pedidos e Pagamentos**
* **Responsabilidades:** Desenvolvimento completo da lógica de **gerenciamento de pedidos** e **processamento de pagamentos**.
* **Principais Contribuições:**
    * Implementação das classes da camada Model (`Pedido`, `ItemPedido`, `Pagamento`, `PagamentoCartao`, `PagamentoDinheiro`, `PagamentoPix`, `StatusPedido` enum) que modelam o processo de compra e pagamento.
    * Criação dos Controllers (`PedidoController`, `PagamentoController`, `MenuPedidoController`) que **orquestram a criação, modificação e finalização de pedidos, além de processar as diferentes formas de pagamento.**
    * Desenvolvimento da View (`MenuPedido`) para a **interface** de usuário relacionada ao registro e acompanhamento de pedidos.
    * Criação da classe `InputHelper`, fundamental para a padronização e robustez da entrada de dados em **todo o sistema**
    * Colaboração na manutenção e extensão de outras classes utilitárias, como `Utils`.

---
## 🤖 Registro de Uso de IA

Esta seção destina-se a registrar o uso de ferramentas de Inteligência Artificial por cada integrante do grupo, visando transparência sobre o processo de desenvolvimento.

### Bruna Amaral Chapelin
* **Ferramenta(s) Utilizada(s): ChatGPT** 
* **Finalidade do Uso:** Suporte na tomada de decisões de design de código (estático vs. não estático) e no aprimoramento estético da interface de usuário (listagens e menus).

### Rebecca Beccari Fagundes
* **Ferramenta(s) Utilizada(s): Gemini (Google)**
* **Finalidade do Uso:** Apoio no esclarecimento de conceitos de polimorfismo/encapsulamento, na estruturação MVC do módulo, na implementação de lógica complexa (a exibição do cardápio com Stream API) e o metodo de busca.

### Matheus Silva dos Santos
* **Ferramenta(s) Utilizada(s): Gemini (Google) e ChatGPT** 
* **Finalidade do Uso:** Apoio na depuração e correção de erros, na compreensão de lógicas complexas (incluindo persistência de dados) e, crucialmente, no suporte à integração entre os módulos do projeto.

### Arthur Soares Padia
* **Ferramenta(s) Utilizada(s): ChatGPT** 
* **Finalidade do Uso:** Apoio na otimização de fluxos e validações (como normalização de texto e tratamento de erros), além de auxílio na organização e formatação do diagrama UML do projeto.
---

## 🛠️ Tecnologias Utilizadas

* **Linguagem de Programação:** Java **17 ou superior**
* **Padrão de Projeto:** MVC (Model-View-Controller)
* **IDE:** IntelliJ IDEA
* **Controle de Versão:** Git 

## 📜 Licença

Este projeto não possui licença específica e é de uso livre para fins acadêmicos.

---
