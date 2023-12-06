# API PARA SORTEIO DE AMIGO OCULTO

RestAPI simples realizada em Spring Boot para realizar o sorteio de amigo oculto e enviar e-mail, utilizando o serviço do Google, indicando o resultado do sorteio para os participantes indicando o amigo oculto que tirou.

# Requisitos

 - Spring Boot 2.3 ou superior
 - Java 8 ou superior

# Instalação

Clonar o repositório:

    git clone https://github.com/Victy0/secret-friend-prize-draw

Instalar e executar o Spring Boot

    Dependendo da IDE selecionada tem uma configuração diferente


# Configuração de e-mail

necessário colocar informações de usuário e senha do e-mail no arquivo de configurações

    ../src/main/resources/application.properties

 - para enviar e-mail é necessário alterar as configurações no próprio e-mail para possibilitar o acesso de aplicações de terceiros ou aplicações menos seguras. Dependendo do provedor do e-mail as configurações ficam em locais diferenciados.

Para testes pode utilizar as configurações abaixo, porém essa é limitada a 10 envios de e-mail por dia

    smtp.username=sem.barreiras.vagas@gmail.com
    smtp.password=dahsvzxgznmfivmc

Email é enviado com o seguinte Título/Assunto: "AMIGO OCULTO - Sorteio do dia dd/MM/AAAA"
 - dd/MM/AAAA possui o valor referente ao dia em que ocorreu o sorteio
 
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
            "email": "e-mail pessoa 1"
        },
        {
            "name": "Nome pessoa 2",
            "email": "e-mail pessoa 2"
        },
        {
            "name": "Nome pessoa 3",
            "email": "e-mail pessoa 3"
        }
    ]