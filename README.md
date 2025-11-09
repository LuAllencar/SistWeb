# 🎓 SistWeb - Sistema de Gestão Escolar

![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

> API REST para gerenciamento de sistema escolar com operações CRUD completas

## 📋 Sobre o Projeto

SistWeb é minha primeira API REST, desenvolvida como projeto acadêmico na disciplina de Sistemas Web da ETEC Fernandópolis. O objetivo é simular um sistema de gestão escolar com operações CRUD de alunos, cursos e integração com a API do IBGE para seleção de cidades brasileiras.

Este projeto representa minha jornada inicial no desenvolvimento backend, explorando conceitos de APIs RESTful, persistência de dados e consumo de APIs externas.

### ⚠️ Status Atual❗

Projeto em desenvolvimento com foco educacional. Atualmente enfrentando desafios na integração com a API do IBGE para seleção dinâmica de cidades - uma excelente oportunidade de aprendizado sobre consumo de APIs externas!

## ✨ Funcionalidades

- ✅ **CRUD de Alunos** - Cadastro, listagem, atualização e exclusão de alunos
- ✅ **CRUD de Cursos** - Gerenciamento completo de cursos
- 🔄 **Integração API IBGE** - Consumo de API externa para seleção de cidades (em implementação)
- 🔄 **Relacionamentos** - Associação entre alunos, cursos e cidades
- 📊 **Consultas** - Listagem e busca de dados
- 🔧 **API RESTful** - Endpoints organizados seguindo padrões REST

## 🛠️ Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

## 📁 Estrutura do Projeto

```
SistWeb/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/sistweb/
│   │   │       ├── controller/    # Controladores REST
│   │   │       ├── model/         # Entidades do banco
│   │   │       ├── repository/    # Repositórios JPA
│   │   │       └── service/       # Lógica de negócio
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- MySQL 8.0+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Instalação

1. **Clone o repositório**
```bash
git clone https://github.com/LuAllencar/SistWeb.git
cd SistWeb
```

2. **Configure o banco de dados**

Crie um banco de dados PostgreSQL:
```sql
CREATE DATABASE bdescola;
```

3. **Configure as credenciais**

Edite o arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:3306/bdescola
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

4. **Execute o projeto**
```bash
mvn spring-boot:run
```

5. **Acesse a API**
```
http://localhost:8080
```

## 📡 Endpoints da API

### Alunos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/alunos` | Lista todos os alunos |
| GET | `/api/alunos/{id}` | Busca aluno por ID |
| POST | `/api/alunos` | Cadastra novo aluno |
| PUT | `/api/alunos/{id}` | Atualiza aluno |
| DELETE | `/api/alunos/{id}` | Remove aluno |

### Cursos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/cursos` | Lista todos os cursos |
| GET | `/api/cursos/{id}` | Busca curso por ID |
| POST | `/api/cursos` | Cadastra novo curso |
| PUT | `/api/cursos/{id}` | Atualiza curso |
| DELETE | `/api/cursos/{id}` | Remove curso |

## 📝 Exemplo de Requisição

### Cadastrar Aluno (POST)

```json
{
  "nome": "João Silva",
  "telefone": "12901234567",
  "endereço": "Jardim das Flores",
  "rm": "65401",
  "cpf": "12345678901",
}
```

### Cadastrar Curso (POST)

```json
{
  "nome": "Desenvolvimento Web",
  "sigla": "DW",
  "cargaHoraria": 120,
  "periodo": "Noturno"
}
```

## 🔄 Melhorias Futuras

- [ ] **Corrigir integração com API do IBGE** - Resolver consumo de API externa para cidades
- [ ] Implementar autenticação JWT
- [ ] Adicionar validações mais robustas
- [ ] Criar endpoints de relatórios
- [ ] Implementar paginação nas listagens
- [ ] Adicionar testes unitários e de integração
- [ ] Documentação Swagger/OpenAPI
- [ ] Sistema de notas e avaliações
- [ ] Gestão de professores e turmas

## 🐛 Problemas Conhecidos

**Integração API IBGE:** Atualmente com dificuldades na implementação do consumo da API do IBGE para seleção dinâmica de cidades. Este é meu primeiro projeto consumindo APIs externas e estou trabalhando para resolver os problemas de versionamento e integração.

Feedbacks e sugestões são muito bem-vindos para melhorar o aprendizado!

## 🤝 Como Contribuir

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👩‍💻 Autora

**Luana Alencar Menezes**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/luana-alencar-menezes-2a6045364)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/LuAllencar)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:luana.amenezes06@gmail.com)

---

<div align="center">
  Desenvolvido com 💜 por Luana Alencar
</div>
