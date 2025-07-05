# amq-broker-dev-local

# Configurando Address

```xml
<address name="address.foo">
   <anycast>
      <queue name="queue_1" />
   </anycast>
</address>
<address name="address.bar">
   <multicast>
      <queue name="queue_1" />
      <queue name="queue_2" />
   </multicast>
</address>
```

# Configuração de Persistência JDBC

## 1. Configurando Persistência JDBC

Para configurar o Apache ActiveMQ Artemis para usar um banco de dados na persistência de mensagens e dados de vinculação (bindings), você precisa realizar duas ações:

1. **Adicionar dependências de runtime**: Consulte a documentação sobre como adicionar dependências de runtime para entender como disponibilizar o driver JDBC para o broker.

2. **Configurar o arquivo `broker.xml`**: Crie um elemento `<store>` no arquivo de configuração `broker.xml`, dentro do elemento `<core>`. 

### Exemplo de Configuração:

```xml
<store>
    <database-store>
        <jdbc-driver-class>com.mysql.cj.jdbc.Driver</jdbc-driver-class>
        <jdbc-connection-url>jdbc:mysql://mysql:3306/artemis_db</jdbc-connection-url>
        <jdbc-user>artemis</jdbc-user>
        <jdbc-password>artemis</jdbc-password>
        <bindings-table-name>BINDINGS_TABLE</bindings-table-name>
        <message-table-name>MESSAGE_TABLE</message-table-name>
        <page-store-table-name>PAGE_TABLE</page-store-table-name>
        <large-message-table-name>LARGE_MESSAGES_TABLE</large-message-table-name>
        <node-manager-store-table-name>NODE_MANAGER_TABLE</node-manager-store-table-name>
    </database-store>
</store>
```

### Elementos de Configuração:

| Elemento                           | Descrição                                                                 |
|------------------------------------|---------------------------------------------------------------------------|
| `jdbc-driver-class-name`           | Classe do driver JDBC que será utilizado                                  |
| `jdbc-connection-url`              | URL de conexão com o banco de dados                                       |
| `bindings-table-name`              | Nome da tabela que armazenará as vinculações (bindings)                   |
| `message-table-name`               | Nome da tabela que armazenará as mensagens                                |
| `page-store-table-name`            | Nome da tabela para armazenamento de páginas                              |
| `large-message-table-name`         | Nome da tabela para mensagens grandes                                     |
| `node-manager-store-table-name`    | Nome da tabela para armazenamento do gerenciador de nó                    |

