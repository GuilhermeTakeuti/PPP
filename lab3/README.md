# Laboratório 3 — Padrões de Projeto (Wrapper/Adapter e Proxy)

Solução em Java para as 4 questões do laboratório. Cada questão está em
seu próprio pacote/pasta, com uma classe `Main` para demonstração.

```
lab3/
├── questao1/   Adapter — aves (Pato/Pavão -> interface Ave)
├── questao2/   Adapter — calculadora binária -> calculadora decimal
├── questao3/   Adapter (proposta livre) — gateway de pagamento externo
└── questao4/   Proxy (proposta livre) — cache de consulta a produtos
```

## Como compilar e executar

Cada questão é independente. A partir da pasta `lab3`, para cada questão:

```bash
javac questao1/*.java
java questao1.Main

javac questao2/*.java
java questao2.Main

javac questao3/*.java
java questao3.Main

javac questao4/*.java
java questao4.Main
```

## Questão 1 — Adapter das Aves

- **Target**: `Ave` (`voar()`, `emitirSom()`).
- **Adaptees**: `Pato`/`PatoDomestico` (métodos `voarPato()` e `grasnar()`) e
  `Pavao`/`PavaoAzul` (método `cantar()`, sem capacidade de voar).
- **Adapters**: `PatoAdapter` e `PavaoAdapter`, que implementam `Ave` e
  delegam para os métodos correspondentes das classes adaptadas.

## Questão 2 — Adapter da Calculadora

- **Adaptee**: `CalculadoraBinaria`, que só soma e subtrai Strings binárias.
- **Target**: `CalculadoraDecimal`, que soma, subtrai e multiplica `int`.
- **Adapter**: `CalculadoraAdapter` converte `int` <-> `String` binária para
  reaproveitar `somar`/`subtrair` da calculadora binária, e implementa
  `multiplicar` por soma sucessiva, já que essa operação não existe no
  Adaptee.

## Questão 3 — Adapter (problema proposto)

Uma loja virtual (`LojaVirtual`, cliente) usa a interface
`ProcessadorPagamento.pagar(double, String)` para cobrar seus clientes.
Um gateway de pagamento de terceiros já existente
(`GatewayPagamentoExterno`, Adaptee) tem uma interface incompatível
(`processarTransacao(long centavos, String moeda, String cartao)`,
retornando texto de status). O `GatewayPagamentoAdapter` faz a tradução
entre as duas interfaces.

## Questão 4 — Proxy (problema proposto)

Um repositório de produtos (`RepositorioProdutosReal`, **objeto base**)
simula uma consulta lenta a um banco de dados. O `ProxyCacheProdutos`
(**proxy**) implementa a mesma interface (`RepositorioProdutos`) e fica
entre o cliente (`Main`) e o objeto base: se o produto já foi buscado
antes, o proxy devolve o valor em cache, sem acessar o repositório real
novamente. A saída do programa mostra a diferença de tempo entre a
primeira busca (lenta) e a segunda busca do mesmo produto (cache,
instantânea).
