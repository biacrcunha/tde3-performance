# Parte 3 — Deadlock

## Objetivo
Reproduzir um deadlock envolvendo duas threads e dois locks e, em seguida, implementar uma solução utilizando uma ordem global de aquisição de recursos para prevenir a espera circular.

---

## Descrição do problema

Duas threads tentam adquirir dois locks (A e B) em ordens opostas.  
Quando cada thread obtém um lock e passa a aguardar pelo segundo, o sistema entra em espera circular, caracterizando deadlock.

As condições de Coffman presentes são:
- exclusão mútua,  
- manter-e-esperar,  
- não preempção,  
- espera circular (responsável crítica pelo impasse).
  
Código: `DeadlockDemo.java`

---

## Solução

Adotar uma **ordem global** de aquisição dos recursos.  
Todas as threads passam a adquirir sempre `LOCK_A` antes de `LOCK_B`, eliminando a possibilidade de espera circular.

Código: `DeadlockResolvido.java`

---

## Compilação e execução

## Executar
```bash
javac DeadlockDemo.java
javac DeadlockResolvido.java
