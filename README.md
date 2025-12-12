# PlayerDeM-sica

Este é um projeto simples de um reprodutor de música desenvolvido em Java.

## ⚠️ Aviso Importante: Arquivos de Música

Devido a questões de tamanho de repositório e direitos autorais, os arquivos de música utilizados no projeto **não estão incluídos** neste repositório do GitHub.

Para que o projeto funcione corretamente, você precisará adicionar seus próprios arquivos de música e configurar a *playlist* no código-fonte.

## ⚙️ Configuração e Execução

Siga os passos abaixo para configurar e executar o projeto em sua máquina:

### 1. Clonar o Repositório

```bash
git clone https://github.com/GilvanPedro/PlayerDeM-sica.git
cd PlayerDeM-sica/MusicPlayer
```

### 2. Adicionar os Arquivos de Música

O projeto foi configurado para ler arquivos de áudio no formato **`.wav`**.

Você deve criar uma pasta chamada `musicas` dentro do diretório `src` do módulo `MusicPlayer` e colocar seus arquivos `.wav` lá.

```bash
# Estando no diretório PlayerDeM-sica/MusicPlayer/
mkdir src/musicas
# Coloque seus arquivos .wav dentro de src/musicas/
```

O caminho final para seus arquivos deve ser, por exemplo: `PlayerDeM-sica/MusicPlayer/src/musicas/minha_musica.wav`.

### 3. Configurar a Playlist

O arquivo que contém a lista de músicas é o `Main.java`. Você precisará editá-lo para que a *playlist* aponte para os nomes dos arquivos que você adicionou.

**Arquivo:** `MusicPlayer/src/main/java/br/com/Main.java`

Localize a seção `// LISTA DE MÚSICAS` e substitua as entradas existentes pelos nomes dos seus arquivos, mantendo o caminho relativo `"src/musicas/"`:

```java
// Exemplo de como deve ficar no arquivo Main.java
List<String> playlist = new ArrayList<>();
playlist.add("src/musicas/nome_do_seu_arquivo_1.wav");
playlist.add("src/musicas/nome_do_seu_arquivo_2.wav");
// adicione quantas quiser
```

### 4. Compilar e Executar (Projeto Maven)

Este é um projeto Maven. Você pode compilá-lo e executá-lo usando seu IDE (como IntelliJ IDEA ou Eclipse) ou via linha de comando.

**Via Linha de Comando (no diretório `PlayerDeM-sica/MusicPlayer/`):**

1.  **Compilar:**
    ```bash
    mvn clean install
    ```
2.  **Executar:**
    ```bash
    mvn exec:java -Dexec.mainClass="br.com.Main"
    ```

### 5. Comandos do Player

Após a execução, o programa irá apresentar um menu de comandos:

| Comando | Ação |
| :---: | :--- |
| **P** | Play (Iniciar/Continuar a música) |
| **S** | Stop (Pausar a música) |
| **R** | Reset (Voltar a música para o início) |
| **N** | Next (Próxima música na playlist) |
| **B** | Back (Música anterior na playlist) |
| **Q** | Quit (Sair do programa) |

---
**Desenvolvido por:** Gilvan Pedro
**Licença:** MIT License
