//classe que representa classe regular, extende a classe desconto e implementa a interface calculavel
public class ClienteRegular extends Desconto implements Calculavel{
    
    //construtor que recebe o valor da compra e identifica o tipoCliente String como "R";
    public ClienteRegular(Double valorCompra) {
        super("R", valorCompra);
    }

    //calcula o desconto de 5% sobre o valorCompra;
    public Double calcularDesconto() {
        this.desconto = valorCompra * 0.05;
        this.valorFinal = valorCompra - this.desconto;
        return this.desconto;
    }

    //metodo que permite atualizar o valor da compra e recalcular desconto
    public void calcularDesconto(Double valor) {
        this.valorCompra = valor;
        calcularDesconto(); 
    }

        // getter para valor final após desconto
    public Double getValorFinal() {
        return valorFinal;
    }
}
