
# **Documentação da API: Rest IPOG**

## **Visão Geral**
Esta API permite a manipulação de tarefas com operações básicas de CRUD (Criar, Ler, Atualizar, e Deletar).

---

## **Endpoints**

### 1. **Obter Todas as Tarefas**
- **Método**: `GET`
- **URL**: `http://localhost:8080/ctask/task`
- **Descrição**: Retorna a lista completa de tarefas.

**Exemplo de Requisição**:
```bash
curl -X GET "http://localhost:8080/ctask/task" -H "User-Agent: insomnia/10.2.0"
```

---

### 2. **Obter Tarefa por ID**
- **Método**: `GET`
- **URL**: `http://localhost:8080/ctask/task/{id}`
- **Descrição**: Retorna os detalhes de uma tarefa específica.
- **Parâmetros**:
  - `id` (path): ID da tarefa a ser buscada.

**Exemplo de Requisição**:
```bash
curl -X GET "http://localhost:8080/ctask/task/1" -H "User-Agent: insomnia/10.2.0"
```

---

### 3. **Criar Nova Tarefa**
- **Método**: `POST`
- **URL**: `http://localhost:8080/ctask/task`
- **Descrição**: Cria uma nova tarefa.
- **Body** (JSON):
  ```json
  {
    "title": "terceira",
    "description": "tarefas da vida"
  }
  ```
- **Headers**:
  - `Content-Type`: `application/json`

**Exemplo de Requisição**:
```bash
curl -X POST "http://localhost:8080/ctask/task" \
-H "Content-Type: application/json" \
-H "User-Agent: insomnia/10.2.0" \
-d '{"title":"terceira","description":"tarefas da vida"}'
```

---

### 4. **Atualizar Tarefa**
- **Método**: `PUT`
- **URL**: `http://localhost:8080/ctask/task/{id}`
- **Descrição**: Atualiza os detalhes de uma tarefa existente.
- **Parâmetros**:
  - `id` (path): ID da tarefa a ser atualizada.
- **Body** (JSON):
  ```json
  {
    "title": "piscina",
    "description": "Limpar a piscina"
  }
  ```
- **Headers**:
  - `Content-Type`: `application/json`

**Exemplo de Requisição**:
```bash
curl -X PUT "http://localhost:8080/ctask/task/2" \
-H "Content-Type: application/json" \
-H "User-Agent: insomnia/10.2.0" \
-d '{"title":"piscina","description":"Limpar a piscina"}'
```

---

### 5. **Deletar Tarefa**
- **Método**: `DELETE`
- **URL**: `http://localhost:8080/ctask/task/{id}`
- **Descrição**: Remove uma tarefa existente.
- **Parâmetros**:
  - `id` (path): ID da tarefa a ser removida.

**Exemplo de Requisição**:
```bash
curl -X DELETE "http://localhost:8080/ctask/task/1" -H "User-Agent: insomnia/10.2.0"
```

---

## **Informações Adicionais**
- Certifique-se de que a aplicação está rodando no host especificado (`localhost:8080`) para testar as rotas.
- Requisições `POST` e `PUT` requerem o cabeçalho `Content-Type: application/json`.
