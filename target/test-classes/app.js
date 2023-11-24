// declara um conjunto inicial de Usuarios
var db_Usuarios_inicial = {
    "data": [
        {
            "id": 1,
            "nome": "Joana Dark",
            "cpf": "123.456.789-12",
            "email": "joana@dark.biz",
            "telefone": "(31)91234-5678",
            "cidade": "Belo Horizonte"
        },
        {
            "id": 2,
            "nome": "Amanda Clara",
            "cpf": "123.987.789-12",
            "email": "amanda@clara.biz",
            "telefone": "(31)91234-5999",
            "cidade": "Belo Horizonte"
        },
        {
            "id": 3,
            "nome": "Maria ",
            "cpf": "123.444.789-12",
            "email": "maria@clara.biz",
            "telefone": "(11)91234-5678",
            "cidade": "Sao Paulo"
        },
        {
            "id": 4,
            "nome": "Ana Julia ",
            "cpf": "123.555.789-12",
            "email": "ana@julia.biz",
            "telefone": "(11)91234-9999",
            "cidade": "Sao Paulo"
        },
        {
            "id": 5,
            "nome": "Joana Dark",
            "cpf": "123.777.789-12",
            "email": "joana@dark.biz",
            "telefone": "(31)91234-5678",
            "cidade": "Belo Horizonte"
        },
        {
            "id": 6,
            "nome": "Fernanda Mata",
            "cpf": "123.888.789-12",
            "email": "fernanda@mata.biz",
            "telefone": "(21)91234-5678",
            "cidade": "Rio de Janeiro"
        },
        {
            "id": 7,
            "nome": "Pietra Jones",
            "cpf": "123.000.789-12",
            "email": "pietra@jones.biz",
            "telefone": "(21)91234-999",
            "cidade": "Rio de Janeiro"
        },
        {
            "id": 8,
            "nome": "Lucia Colts",
            "cpf": "123.456.789-99",
            "email": "lucia@colts.biz",
            "telefone": "(31)99087-5678",
            "cidade": "Belo Horizonte"
        },
        {
            "id": 9,
            "nome": "Pamela Jinx",
            "cpf": "780.987.456-12",
            "email": "pamela@jinx.biz",
            "telefone": "(11)91234-8790",
            "cidade": "Sao Paulo"
        },
        {
            "id": 10,
            "nome": "Daisy Santos",
            "cpf": "123.880.921-61",
            "email": "daisy@santos.biz",
            "telefone": "(21)91234-5678",
            "cidade": "Rio de Janeiro"
        }
    ]
}

// Caso os dados já estejam no Local Storage, caso contrário, carrega os dados iniciais
var db = JSON.parse(localStorage.getItem('db_Usuarios'));
if (!db) {
    db = db_Usuarios_inicial
};

// Exibe mensagem em um elemento de ID msg
function displayMessage(msg) {
    $('#msg').html('<div class="alert alert-warning">' + msg + '</div>');
}

function insertUsuarios(Usuarios) {
    // Calcula novo Id a partir do último código existente no array (PODE GERAR ERRO SE A BASE ESTIVER VAZIA)
    let novoId = 1;
    if (db.data.length != 0) 
      novoId = db.data[db.data.length - 1].id + 1;
    let novoUsuarios = {
        "id": novoId,
        "nome": Usuarios.nome,
        "cpf" : Usuarios.cpf,
        "email" : Usuarios.email,
        "telefone": Usuarios.telefone,
        "cidade": Usuarios.cidade
    };

    // Insere o novo objeto no array
    db.data.push(novoUsuarios);
    displayMessage("Usuário inserido com sucesso");

    // Atualiza os dados no Local Storage
    localStorage.setItem('db_Usuarios', JSON.stringify(db));
}

function updateUsuarios(id, Usuarios) {
    // Localiza o indice do objeto a ser alterado no array a partir do seu ID
    let index = db.data.map(obj => obj.id).indexOf(id);

    // Altera os dados do objeto no array
    db.data[index].nome = Usuarios.nome,
    db.data[index].telefone = Usuarios.telefone,
    db.data[index].email = Usuarios.email,
    db.data[index].cpf = Usuarios.cpf, 
    db.data[index].cidade = Usuarios.cidade

    displayMessage("Usuarios alterado com sucesso");

    // Atualiza os dados no Local Storage
    localStorage.setItem('db_Usuarios', JSON.stringify(db));
}

function deleteUsuarios(id) {    
    // Filtra o array removendo o elemento com o id passado
    db.data = db.data.filter(function (element) { return element.id != id });

    displayMessage("Usuarios removido com sucesso");

    // Atualiza os dados no Local Storage
    localStorage.setItem('db_Usuarios', JSON.stringify(db));
}