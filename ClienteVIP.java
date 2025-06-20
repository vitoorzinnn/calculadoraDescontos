//classe que representa o tipo de cliente vip, extende a classe desconto e implementa a interface calculavel
public class ClienteVIP extends Desconto implements Calculavel {

    //construtor que recebe o valor da compra e identifica o tipoCliente String como "V";
    public ClienteVIP(Double valorCompra) {
        super("V", valorCompra);
    }

    //calcula o desconto de 5% sobre o valorCompra;
    
    public Double calcularDesconto() {
        this.desconto = valorCompra * 0.10;
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
