# Projeto API Security
Este projeto trata-se de uma API simples para validação de um padrão de senha com as seguintes regras:
* Nove ou mais caracteres
* Ao menos 1 dígito
* Ao menos 1 letra minúscula
* Ao menos 1 letra maiúscula
* Ao menos 1 caractere especial
* São considerados especiais os seguintes caracteres: !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto

## Estrutura do projeto
O projeto foi desenvolvido na linguagem Java versão 11 com Springboot framework.

Os packages separam as responsabilidades na aplicação e estão distribuídos da seguinte forma:
* constant
    * contém as classes de constantes para determinar domínio, versão, collections e basepath dos controllers
* controller
    * contém as classes de controllers da API
* model
    * contém as classes de modelos de entrada e saída da API, tais como: entidades, tabelas e etc.
* service
    * contém as interfaces e classes de implementação que centralizam as regras de negócio e processamento das informações. Neste módulo as classes de implementação estão abstraídas com interfaces facilitando em caso de manutenções e expansão da aplicação.
* test
    * contém todos os cenários de testes unitários implementados (atualmente 10 testes)

## Compilar e executar
O projeto utiliza maven, para gerar o artefato compilado, basta utilizar o maven com o seguinte comando:
* mvn clean install

Este comando produzirá o arquivo com extensão .jar no diretório /target do projeto, executará os testes unitários e validará o artefato de saída.
Para executá-lo basta executar em linha de comando:
* java -jar NOMEDOARQUIVO.jar

A aplicação executará e será exposta pela porta 8080 (padrão).

## Endpoints
Abaixo estão os endereços da API:
* Domínio: /security
* Versão: /v1
* Basepath: /security/v1 (Domínio + versão)
* Collections:
    * /passwords
        * Endpoints:
            * POST | /validate
    
Exemplo de endpoint executando a API em localhost: http://localhost:8080/security/v1/passwords/validate

O projeto está com springfox implementado, bastando acessar o endereço: http://localhost:8080/swagger-ui.html para visualização completa do swagger desta API.

Optei por executar a validação da senha utilizando método POST para evitar o tráfego de informação sigilosa (no caso uma senha) na querystring de maneira aberta, enviando via payload no body o dado estára um pouco mais protegido, porém para isso foi necessário criar um endpoint verboso "/validate".

## Configurações da API
O arquivo application.properties possui 2 patterns de regex para validação da senha:
* password.pattern = armazena o pattern da primeira validação que checa os caracteres
* password.pattern-duplicate = armazena o pattern que verifica caracteres duplicados

Com esta abordagem não é necessário recompilar o projeto se os requisitos de validação de senha mudarem ao longo do tempo.

# Demais informações
Tentei preparar algo simples, focado apenas em cumprir os requisitos apresentados, não implementei a parte de CI/CD, container ou logging, pois, entendo que não seria o foco do exercício.

### Referências

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/)