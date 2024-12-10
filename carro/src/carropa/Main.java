package carropa;


import java.util.ArrayList;
import java.util.List;

class Carro implements Comparable<Carro> {
    private String nome;
    private int ano;

    public Carro(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Carro{" + "nome='" + nome + '\'' + ", ano=" + ano + '}';
    }

    @Override
    public int compareTo(Carro outro) {
        return this.nome.compareTo(outro.nome);
    }

    public static void insertionSort(List<Carro> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Carro chave = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j).compareTo(chave) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, chave);
        }
    }

    public static int buscaBinaria(List<Carro> lista, String nome) {
        int inicio = 0;
        int fim = lista.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Carro carroMeio = lista.get(meio);

            int comparacao = carroMeio.getNome().compareTo(nome);
            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("Fusca", 1972));
        carros.add(new Carro("Civic", 2020));
        carros.add(new Carro("Gol", 2005));
        carros.add(new Carro("Palio", 2010));

        System.out.println("Lista original:");
        for (Carro carro : carros) {
            System.out.println(carro);
        }

        insertionSort(carros);

        System.out.println("\nLista ordenada:");
        for (Carro carro : carros) {
            System.out.println(carro);
        }

        String nomeParaBuscar = "Gol";
        int indice = buscaBinaria(carros, nomeParaBuscar);

        if (indice != -1) {
            System.out.println("\nCarro encontrado: " + carros.get(indice));
        } else {
            System.out.println("\nCarro '" + nomeParaBuscar + "' não encontrado.");
        }
    }
}