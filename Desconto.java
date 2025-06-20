public abstract class Desconto implements Calculavel {
    protected Double valorCompra; // valor da compra inserido pelo usuário;
    protected Double valorFinal; // valor final da compra com o desconto aplicado;
    protected Double desconto; // valor do desconto aplicado;
    protected String tipoCliente; // tipo de cliente VIP ou REGULAR;
    
    //construtor que identifica e inicializa o tipo de cliente e o valor da compra
    public Desconto(String tipoCliente, Double valorCompra){ 
        this.tipoCliente = tipoCliente;
        this.valorCompra = valorCompra;
    }
    
    //Getters e Setters para modificar os atributos;
    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    //metodo que calcula o desconto a partir do valor passado;
    public Double valorDesconto(Double valor){
        this.valorCompra = valor;
        return calcularDesconto();  // retorna o metodo abstrato pra calcular o desconto;
    }
}