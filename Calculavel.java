// interface que define os métodos para calcular desconto;
public interface Calculavel {
    
    public Double calcularDesconto();  // método para calcular desconto sem parâmetros, retorna valor do desconto;
    public void calcularDesconto(Double valor); // método para calcular desconto recebendo um valor, não retorna nada;
}
