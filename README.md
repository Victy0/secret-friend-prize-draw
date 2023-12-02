# API PARA SORTEIO DE AMIGO OCULTO

RestAPI simples realizada em SPring Boot para realizar o sorteio de amigo oculto e enviar e-mail indicando o resultado do sorteio para os participantes indicando o amigo oculto que tirou.

# Requisitos

 - Spring Boot 2.3 ou superior
 - Java 8 ou superior

# Instalação

Clonar o repositório:

    git clone https://github.com/Victy0/secret-friend-prize-drawn

Instalar e executar o Spring Boot

    Dependendo da IDE selecionada tem uma configuração diferente

# Exemplo de envio ao endpoint

Endpoint:

    .../sortear
 - localmente o endpoint será http://localhost:8080/sortear

Tipo de requisição:

    POST

Tipo de body da requisição

    JSON

Exemplo de body de requisição

    [
        {
            "name": "Nome pessoa 1",
            "email": "Nome pessoa 1"
        },
        {
            "name": "Nome pessoa 2",
            "email": "Nome pessoa 2"
        },
        {
            "name": "Nome pessoa 3",
            "email": "Nome pessoa 3"
        }
    ]