# 🎓 SistWeb - Sistema de Gestão Escolar

![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-success?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen?style=for-the-badge&logo=springboot)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

> Sistema completo de gestão escolar desenvolvido com Spring Boot, PostgreSQL e Thymeleaf

## 📋 Sobre o Projeto

SistWeb é um sistema web completo para gerenciamento escolar, desenvolvido como projeto acadêmico na disciplina de Sistemas Web da ETEC Fernandópolis. O projeto implementa operações CRUD completas para alunos e cursos, com interface web responsiva e relacionamentos entre entidades.

Este foi meu primeiro projeto fullstack com Spring Boot, onde explorei conceitos fundamentais de desenvolvimento web, arquitetura MVC, persistência de dados com JPA/Hibernate, e criação de interfaces dinâmicas com Thymeleaf.

## ✨ Funcionalidades

### Gerenciamento de Cursos
- ✅ Cadastro de novos cursos
- ✅ Listagem de todos os cursos
- ✅ Edição de cursos existentes
- ✅ Exclusão de cursos
- ✅ Campos: Nome, Sigla, Carga Horária, Período

### Gerenciamento de Alunos
- ✅ Cadastro de novos alunos
- ✅ Listagem de todos os alunos
- ✅ Edição de alunos existentes
- ✅ Exclusão de alunos
- ✅ Campos: Nome, Telefone, Endereço, RM, CPF
- ✅ Associação de aluno a curso (relacionamento ManyToOne)

### Interface
- ✅ Interface web completa e responsiva
- ✅ Design moderno com gradientes e animações CSS
- ✅ Navegação intuitiva entre funcionalidades
- ✅ Formulários validados
- ✅ Tabelas estilizadas para visualização de dados

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17** - Linguagem de programação
- **Spring Boot 3.5.5** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST e Controllers
- **Lombok** - Redução de código boilerplate
- **PostgreSQL** - Banco de dados relacional

### Frontend
- **Thymeleaf** - Template engine para views dinâmicas
- **HTML5** - Estrutura das páginas
- **CSS3** - Estilização moderna com gradientes e animações

### Ferramentas
- **Maven** - Gerenciamento de dependências
- **Hibernate** - ORM para mapeamento objeto-relacional

## 📁 Estrutura do Projeto

```
escola/
├── src/
│   ├── main/
│   │   ├── java/br/com/projetoescola/escola/
│   │   │   ├── controller/         # Controllers MVC
│   │   │   │   ├── AlunoController.java
│   │   │   │   ├── CursoController.java
│   │   │   │   └── EscolaController.java
│   │   │   ├── entity/              # Entidades JPA
│   │   │   │   ├── Aluno.java
│   │   │   │   ├── Curso.java
│   │   │   │   └── Cidade.java
│   │   │   ├── repository/          # Repositórios JPA
│   │   │   │   ├── AlunoRepository.java
│   │   │   │   ├── CursoRepository.java
│   │   │   │   └── CidadeRepository.java
│   │   │   ├── service/             # Camada de serviço
│   │   │   │   ├── AlunoService.java
│   │   │   │   ├── CursoService.java
│   │   │   │   └── CidadeService.java
│   │   │   └── EscolaApplication.java
│   │   └── resources/
│   │       ├── static/css/
│   │       │   └── estilo.css       # Estilos customizados
│   │       ├── templates/
│   │       │   ├── aluno/           # Views de alunos
│   │       │   ├── curso/           # Views de cursos
│   │       │   └── index.html       # Página inicial
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior instalado
- PostgreSQL 12+ instalado e rodando
- Maven 3.6+ (ou use o Maven Wrapper incluído)
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Passo a Passo

1. **Clone o repositório**
```bash
git clone https://github.com/LuAllencar/SistWeb.git
cd SistWeb/escola
```

2. **Configure o banco de dados**

Crie um banco de dados PostgreSQL:
```sql
CREATE DATABASE bdescola;
```

3. **Configure as credenciais**

Edite o arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bdescola?useTimezone=true&serverTimezone=America/Fortaleza&user=postgres&password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

4. **Execute o projeto**

Usando Maven:
```bash
mvn spring-boot:run
```

Ou usando o Maven Wrapper:
```bash
./mvnw spring-boot:run    # Linux/Mac
mvnw.cmd spring-boot:run  # Windows
```

5. **Acesse a aplicação**

Abra seu navegador em:
```
http://localhost:8080/escola
```

## 📡 Estrutura de Rotas

### Página Inicial
- `GET /escola` - Tela principal com menu de navegação

### Cursos
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/cursos/listar` | Lista todos os cursos |
| GET | `/cursos/criar` | Exibe formulário de cadastro |
| POST | `/cursos/salvar` | Salva curso (novo ou editado) |
| GET | `/cursos/editar/{id}` | Exibe formulário de edição |
| GET | `/cursos/excluir/{id}` | Exclui curso |

### Alunos
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/alunos/listar` | Lista todos os alunos |
| GET | `/alunos/criar` | Exibe formulário de cadastro |
| POST | `/alunos/salvar` | Salva aluno (novo ou editado) |
| GET | `/alunos/editar/{id}` | Exibe formulário de edição |
| GET | `/alunos/excluir/{id}` | Exclui aluno |

## 💾 Modelo de Dados

### Entidade Curso
```java
- idCurso: Integer (PK, Auto)
- nomeCurso: String(30)
- siglaCurso: String(10)
- chCurso: Integer
- periodoCurso: String(20)
```

### Entidade Aluno
```java
- idAluno: Integer (PK, Auto)
- nomeAluno: String(40)
- telefoneAluno: String(11)
- enderecoAluno: String(40)
- rmAluno: Integer
- cpfAluno: String(11)
- curso: Curso (ManyToOne)
```

### Relacionamentos
- Um **Curso** pode ter vários **Alunos** (One to Many)
- Um **Aluno** pertence a um **Curso** (Many to One)

## 🎨 Características da Interface

- **Design Responsivo**: Adaptável a diferentes tamanhos de tela
- **Gradientes Modernos**: Interface visualmente atraente
- **Animações CSS**: Efeitos hover e transições suaves
- **Validação de Formulários**: Campos obrigatórios configurados
- **Feedback Visual**: Cores e ícones intuitivos para ações

## 📚 Aprendizados

Durante o desenvolvimento deste projeto, tive a oportunidade de aprender e aplicar:

- Arquitetura MVC em aplicações Spring Boot
- Mapeamento objeto-relacional com JPA/Hibernate
- Relacionamentos entre entidades (@ManyToOne, @OneToMany)
- Injeção de dependências com @Autowired
- Template engine Thymeleaf para views dinâmicas
- Design responsivo com CSS3
- Operações CRUD completas
- Boas práticas de código com Lombok
- Configuração e uso do PostgreSQL

## 🔄 Melhorias Futuras

- [ ] Implementar autenticação e autorização (Spring Security)
- [ ] Adicionar paginação nas listagens
- [ ] Criar dashboard com estatísticas
- [ ] Implementar sistema de notas e avaliações
- [ ] Adicionar gestão de professores e disciplinas
- [ ] Criar relatórios em PDF
- [ ] Implementar busca e filtros avançados
- [ ] Adicionar validações mais robustas
- [ ] Criar testes unitários e de integração
- [ ] Deploy em produção (Railway, Render, ou Heroku)

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:

1. Fazer um fork do projeto
2. Criar uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abrir um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👩‍💻 Autora

**Luana Alencar Menezes**

Estudante de Desenvolvimento de Sistemas na ETEC Fernandópolis, apaixonada por tecnologia e desenvolvimento web.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/luana-alencar-menezes-2a6045364)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/LuAllencar)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:luana.amenezes06@gmail.com)

## 🙏 Agradecimentos

- ETEC Fernandópolis e professores da disciplina de Sistemas Web
- Comunidade Spring Boot pela excelente documentação
- Colegas de turma pelo apoio e colaboração
- Professor Silvio Lopes, pela excelente didática, compreensão e paciência para resolução de imprevistos

---

<div align="center">
  
**⭐ Se este projeto foi útil para você, considere dar uma estrela!**

Desenvolvido com 💜 e ☕ por Luana Alencar

</div>
