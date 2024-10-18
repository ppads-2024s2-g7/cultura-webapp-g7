const URL_BASE = 'http://localhost:8080/desenhos';

function asyncLerDesenhos(callbackSucesso, callbackErro) {
    fetch(URL_BASE)
        .then(response => response.json())
        .then(callbackSucesso)
        .catch(callbackErro);
}

function asyncLerDesenhoById(id, callbackSucesso, callbackErro) {
    fetch(URL_BASE + '/' + id)
        .then(response => response.json())
        .then(callbackSucesso)
        .catch(callbackErro);
}

function asyncCriarDesenho(dados, callbackSucesso, callbackErro) {
    fetch(URL_BASE, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dados)
    })
    .then(response => response.json())
    .then(callbackSucesso)
    .catch(callbackErro);
}

function asyncAlterarDesenho(dados, callbackSucesso, callbackErro) {
    fetch(URL_BASE + '/' + dados.id, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dados)
    })
    .then(response => response.json())
    .then(callbackSucesso)
    .catch(callbackErro);
}

function asyncApagarDesenho(id, callbackSucesso, callbackErro) {
    fetch(URL_BASE + '/' + id, {
        method: 'DELETE'
    })
    .then(callbackSucesso)
    .catch(callbackErro);
}
