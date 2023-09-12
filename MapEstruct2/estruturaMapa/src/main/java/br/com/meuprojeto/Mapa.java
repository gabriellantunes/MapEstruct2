package br.com.meuprojeto;

public class Mapa<K, V> {
    private No inicio = null;

    private class No {
        K chave;
        V valor;
        No proximo;
        No anterior;

        No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    public V colocar(K chave, V valor) {
        if (chave == null) {
            throw new IllegalArgumentException("Chave não pode ser nula.");
        }

        No novoNo = new No(chave, valor);

        if (inicio == null) {
            inicio = novoNo;
            return null; // Como é a primeira inserção, o valor antigo é nulo.
        }

        No atual = inicio;
        while (atual.proximo != null) {
            if (atual.chave.equals(chave)) {
                V valorAntigo = atual.valor;
                atual.valor = valor;
                return valorAntigo;
            }
            atual = atual.proximo;
        }

        if (atual.chave.equals(chave)) {
            V valorAntigo = atual.valor;
            atual.valor = valor;
            return valorAntigo;
        }

        atual.proximo = novoNo;
        novoNo.anterior = atual;
        return null; // Chave não estava no mapa anteriormente, então o valor antigo é nulo.
    }

    public V obter(K chave) {
        if (chave == null) {
            throw new IllegalArgumentException("Chave não pode ser nula.");
        }

        No atual = inicio;
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public boolean contemChave(K chave) {
        return obter(chave) != null;
    }

    public V remover(K chave) {
        if (chave == null) {
            throw new IllegalArgumentException("Chave não pode ser nula.");
        }

        No atual = inicio;

        while (atual != null) {
            if (atual.chave.equals(chave)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    inicio = atual.proximo;
                }

                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                }
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }
}
