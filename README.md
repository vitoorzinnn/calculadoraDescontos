# calculadoraDescontos
Projeto ETB 2° Semestre - Linguagem Técnica de Programação [Java]

Funcionalidades
Estrutura de Classes:

Classe abstrata Desconto com atributos e métodos comuns (valorCompra, desconto, tipoCliente)
Subclasses para diferentes tipos de cliente (Regular, VIP), cada uma com regras de desconto específicas
Interface Calculavel com métodos para calcular desconto
Sobrecarga de métodos para cálculo do desconto
Uso de ArrayList<Desconto> para armazenar o histórico
Utilização dos principais métodos do ArrayList: add, remove, get, size, clear, contains, etc.
Exceções personalizadas para validação de valores (ex: DescontoInvalidoException)
Tratamento de exceções com try-catch e lançamento de exceções personalizadas
Entrada de Dados:

Valor da compra
Tipo de cliente (Regular/VIP)
Validar os dados lançando exceções personalizadas em caso de valores inválidos
Criar objeto correspondente e adicionar ao ArrayList de histórico
Processamento:

Calcular valor do desconto e valor final usando métodos das classes
Armazenar no histórico
Exibição:

Mostrar resultado atual
Exibir histórico de descontos (objetos)
Apresentar estatísticas
Permitir remoção de descontos do histórico
Permitir limpar todo o histórico usando clear()
Tratamento de Exceções:

Utilizar blocos try-catch para capturar exceções de entrada e de lógica
Lançar exceções personalizadas para valores inválidos
Exibir mensagens de erro amigáveis ao usuário
