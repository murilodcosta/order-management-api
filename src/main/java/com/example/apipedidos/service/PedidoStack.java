package com.example.apipedidos.service;

import com.example.apipedidos.dto.PedidoResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de uma Pilha (LIFO) com capacidade fixa
 * para armazenar PedidoResponseDTO.
 * Baseado no exemplo PilhaArray.
 */
public class PedidoStack {

    private PedidoResponseDTO[] elementos;
    private int topo;
    private int capacidade;

    public PedidoStack(int tamanho) {
        capacidade = tamanho;
        elementos = new PedidoResponseDTO[capacidade];
        topo = -1;
    }

    public void push(PedidoResponseDTO elemento) {
        if (isFull()) {
            throw new RuntimeException("Pilha de pedidos cheia! Não é possível adicionar mais elementos.");
        }
        elementos[++topo] = elemento;
    }

    public PedidoResponseDTO pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha de pedidos vazia! Não há elementos para remover.");
        }
        PedidoResponseDTO elementoRemovido = elementos[topo];
        elementos[topo--] = null;
        return elementoRemovido;
    }

    public PedidoResponseDTO peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha de pedidos vazia! Não há elemento no topo.");
        }
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == capacidade - 1;
    }

    public int size() {
        return topo + 1;
    }

    /**
     * Retorna uma lista de todos os elementos da pilha (do topo para a base).
     * Necessário para o método 'obterTodasAsMensagens'.
     */
    public List<PedidoResponseDTO> getTodosElementos() {
        List<PedidoResponseDTO> lista = new ArrayList<>();
        for (int i = topo; i >= 0; i--) {
            lista.add(elementos[i]);
        }
        return lista;
    }
}