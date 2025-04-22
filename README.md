# Conversor de Moedas Java

![GitHub repo size](https://img.shields.io/github/repo-size/calixtollucas/conversor-moedas?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/calixtollucas/conversor-moedas?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/calixtollucas/conversor-moedas?style=for-the-badge)


> Este projeto se trata de um programa que realiza cálculos de câmbio de moedas em tempo real utilizando uma API externa

## ⚛️ Tecnologias usadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você tem o git instalado
- Você instalou no mínimo a versão `Java 17+`
- Você tem uma máquina `Windows / Linux / Mac`. Indique qual sistema operacional é compatível / não compatível.
- Você leu `todo este readme, inclusive o guia de como usar`.

### 📁 Estrutura Importante do Projeto

```
.
├── br.devruka.conversor-moedas
│   └── src
│       ├── application
│       │   ├── Main.java
│       │   └── ...
│       └── domain
├── gson-2.11.0.jar
```

## 🚀 Instalando Conversor de Moedas Java

Para instalar o Conversor de Moedas Java, siga estas etapas:

Clone o repositório
```
git clone https://github.com/calixtollucas/conversor-moedas.git
```

## ☕ Usando Conversor de Moedas Java

Para usar Conversor de Moedas Java, siga estas etapas:

Após cloná-lo, abra o terminal na pasta ou navegue até ela e execute o seguinte comando:

### 🛠️ Compilando o Projeto

1. Gere a lista de todos os arquivos `.java` do projeto:

  Linux/Mac:
   ```bash
   find br.devruka.conversor-moedas/src -name "*.java" > sources.txt
   ```
   
   Windows:
  ```bash
    dir /s /b br.devruka.conversor-moedas\src\*.java > sources.txt
  ```

2. Compile todos os arquivos e gere as classes em um diretório `out/`:

  Linux/Mac:
   ```bash
   javac -d out -cp gson-2.11.0.jar @sources.txt && cp moedas_suportadas.txt out/
   ```

   Windows:
   ```bash
   javac -d out -cp gson-2.11.0.jar @sources.txt && copy moedas_suportadas.txt out\
   ```
---

### ▶️ Executando o Projeto

3. Acesse a pasta `out/`:
   
   ```bash
   cd out
   ```

4. Execute a aplicação (Linux/macOS):
   ```bash
   java -cp ".:../gson-2.11.0.jar" Main
   ```

   Ou no Windows:
   ```cmd
   java -cp ".;../gson-2.11.0.jar" Main
   ```

---

### 💡 Observações

- Certifique-se de que o arquivo `Main.java` está com o seguinte pacote no topo do arquivo:

  ```java
  package application;
  ```

- A pasta `out/` conterá a estrutura de pacotes com os `.class` gerados.
- A dependência `gson-2.11.0.jar` é usada para lidar com JSON.