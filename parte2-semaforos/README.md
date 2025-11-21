# Parte 2 — Threads e Semáforos

## Objetivo
Demonstrar uma condição de corrida ao incrementar um contador compartilhado com múltiplas threads e corrigir o problema usando um semáforo binário (`Semaphore(1, true)`).

---

## 1. Condição de Corrida — Sem Sincronização
- `count++` não é atômico.
- Threads concorrem para escrever no mesmo valor.
- O resultado final é **menor que o esperado**.
- Demonstra comportamento inseguro em sistemas concorrentes.

Código: `CorridaSemControle.java`

---

## 2. Solução — Semáforo Binário
- Usa `Semaphore(1, true)` para garantir exclusão mútua.
- Cada thread só incrementa quando possui a permissão.
- O resultado final é sempre **exatamente T×M**.
- O modo `fair=true` evita starvation.

Código: `CorridaComSemaphore.java`

---

## Saídas / prints

As saídas da Parte 2 foram registradas diretamente como comentários nos arquivos Java:

- `CorridaSemControle.java` → saída da execução sem sincronização, mostrando perda de incrementos.
- `CorridaComSemaphore.java` → saída da execução com semáforo binário, mostrando valor correto.

Os comentários incluem: valor esperado, valor obtido e tempo total de execução.


## Execução e Compilação

### Compilar
```bash
javac CorridaSemControle.java
javac CorridaComSemaphore.java
