# ms-course 
Os microsserviços são registrados em um "Discovery Server" (Eureka), de modo que a comunicação entre eles é feita pelo nome do microsserviço. 
Além disso, as requisições são feitas em um API Gateway (Zuul), responsável por rotear e autorizar as requisições.
Autenticação e autorização, usando OAuth e tokens JWT.

Feign para requisições de API entre microsserviços

Ribbon para balanceamento de carga

Servidor Eureka para registro dos microsserviços

API Gateway Zuul para roteamento e autorização

Hystrix para tolerância a falhas

OAuth e JWT para autenticação e autorização

Servidor de configuração centralizada com dados em repositório Git

Geração de containers Docker para os microsserviços e bases de dados

Teste no navegador:

fetch("http://localhost:8765/hr-worker/workers", {
  "headers": {
    "accept": "*/*",
    "accept-language": "en-US,en;q=0.9,pt-BR;q=0.8,pt;q=0.7",
    "sec-fetch-dest": "empty",
    "sec-fetch-mode": "cors",
    "sec-fetch-site": "cross-site"
  },
  "referrer": "http://localhost:3000",
  "referrerPolicy": "no-referrer-when-downgrade",
  "body": null,
  "method": "GET",
  "mode": "cors",
  "credentials": "omit"
});

