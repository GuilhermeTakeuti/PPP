# Trabalho Final — Princípios e Padrões de Projeto

Framework orientado a objetos para aplicações de Quiz (pacote `quiz.framework`)
e duas aplicações construídas sobre ele: um Quiz de Programação com interface
gráfica Swing (`quiz.aplicacao.programacao`) e um Quiz de Conhecimentos Gerais
com interface de console (`quiz.aplicacao.geral`).

Relatório técnico em `RELATORIO_TECNICO.pdf`.

## Integrantes

- Marcel Teixeira Chiarelo
- Guilherme de Oliveira Takeuti

## Estrutura

```
src/
└── quiz/
    ├── framework/
    │   ├── model/        Pergunta, RespostaRegistrada, Resultado
    │   ├── pontuacao/     estratégias de pontuação (Strategy)
    │   ├── core/          Quiz.java (Template Method)
    │   ├── factory/       QuizFactory.java (Factory Method)
    │   ├── ui/            QuizView.java (abstração da interface)
    │   └── observer/      SessaoMultiplayer (Observer - extra)
    └── aplicacao/
        ├── programacao/   Quiz de Programação (Swing)
        └── geral/         Quiz de Conhecimentos Gerais (console)
```

## Como compilar e rodar

Compilar tudo:

```
./build.sh
```

Rodar o quiz de Programação (Swing):

```
./run-programacao.sh
```

Rodar o quiz de Conhecimentos Gerais (console):

```
./run-geral.sh
```

Rodar a demo extra do Observer (múltiplos jogadores):

```
./run-multiplayer.sh
```

Também dá pra importar a pasta `src` como projeto no IntelliJ/Eclipse e
rodar as classes `MainProgramacao`, `MainGeral` e `MultiplayerDemo`
diretamente pela IDE.

## Padrões de projeto usados

- **Template Method** — `Quiz.iniciar()` define o fluxo fixo do quiz;
  `QuizProgramacao` e `QuizConhecimentosGerais` só sobrescrevem hooks.
- **Strategy** — `PontuacaoStrategy` e suas implementações (`PontuacaoPadrao`,
  `PontuacaoReduzida`, `PontuacaoComPenalidade`, `PontuacaoPorTempo`).
- **Factory Method** — `QuizFactory`, implementada por `ProgramacaoQuizFactory`
  e `GeralQuizFactory`.
- **Observer** (extra) — `SessaoMultiplayer` + `QuizObserver`, usado na demo
  de múltiplos jogadores.
