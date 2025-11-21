# Parte 2 — Threads e Semáforos

## Objetivo
Demonstrar uma condição de corrida ao incrementar um contador compartilhado com múltiplas threads e corrigir o problema usando um semáforo binário (`Semaphore(1, true)`).

---

## 1. Condição de Corrida — Sem Sincronização
Arquivo: `CorridaSemControle.java`

- `count++` não é atômico.
- Threads concorrem para escrever no mesmo valor.
- O resultado final é **menor que o esperado**.
- Demonstra comportamento inseguro em sistemas concorrentes.

---

## 2. Solução — Semáforo Binário
Arquivo: `CorridaComSemaphore.java`

- Usa `Semaphore(1, true)` para garantir exclusão mútua.
- Cada thread só incrementa quando possui a permissão.
- O resultado final é sempre **exatamente T×M**.
- O modo `fair=true` evita starvation.

---

## Execução e Compilação

### Compilar
```bash
javac CorridaSemControle.java
javac CorridaComSemaphore.java
