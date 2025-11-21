# Parte 3 — Deadlock

## Objetivo
Reproduzir um deadlock envolvendo duas threads e dois locks e, em seguida, implementar uma solução utilizando uma ordem global de aquisição de recursos para prevenir a espera circular.

---

## Arquivos

| Arquivo | Descrição |
|---------|-----------|
| `DeadlockDemo.java` | Demonstra o deadlock causado por espera circular. |
| `DeadlockResolvido.java` | Versão corrigida com hierarquia de recursos. |

---

## Descrição do problema

Duas threads tentam adquirir dois locks (A e B) em ordens opostas.  
Quando cada thread obtém um lock e passa a aguardar pelo segundo, o sistema entra em espera circular, caracterizando deadlock.

As condições de Coffman presentes são:
- exclusão mútua,  
- manter-e-esperar,  
- não preempção,  
- espera circular (responsável crítica pelo impasse).

---

## Solução

Adotar uma **ordem global** de aquisição dos recursos.  
Todas as threads passam a adquirir sempre `LOCK_A` antes de `LOCK_B`, eliminando a possibilidade de espera circular.

---

## Compilação e execução

```bash
javac DeadlockDemo.java
javac DeadlockResolvido.java
