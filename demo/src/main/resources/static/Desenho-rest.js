// Função para criar um novo desenho
async function asyncCriarDesenho(dadosDesenho, proxsucesso, proxerro) {
    const URL = '/api/desenhos';
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosDesenho),
        headers: { 'Content-Type': 'application/json' }
    };
    
    try {
        const resposta = await fetch(URL, postRequest);
        if (!resposta.ok) throw new Error(resposta.status);
        await resposta.json();
        proxsucesso();
    } catch (erro) {
        proxerro(erro);
    }
}

// Função para ler todos os desenhos
async function asyncLerDesenhos(proxsucesso, proxerro) {
    const URL = '/api/desenhos';
    
    try {
        const resposta = await fetch(URL);
        if (!resposta.ok) throw new Error(resposta.status);
        const jsonresponse = await resposta.json();
        proxsucesso(jsonresponse);
    } catch (erro) {
        proxerro(erro);
    }
}

// Função para ler um desenho específico por ID
async function asyncLerDesenhoById(id, proxsucesso, proxerro) {
    const URL = `/api/desenhos/${id}`;
    
    try {
        const resposta = await fetch(URL);
        if (!resposta.ok) throw new Error(resposta.status);
        const jsonresponse = await resposta.json();
        proxsucesso(jsonresponse);
    } catch (erro) {
        proxerro(erro);
    }
}

// Função para alterar um desenho existente
async function asyncAlterarDesenho(dadosDesenho, proxsucesso, proxerro) {
    const URL = `/api/desenhos/${dadosDesenho.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosDesenho),
        headers: { 'Content-Type': 'application/json' }
    };
    
    try {
        const resposta = await fetch(URL, putRequest);
        if (!resposta.ok) throw new Error(resposta.status);
        await resposta.json();
        proxsucesso();
    } catch (erro) {
        proxerro(erro);
    }
}

// Função para apagar um desenho por ID
async function asyncApagarDesenho(id, proxsucesso, proxerro) {
    const URL = `/api/desenhos/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    
    try {
        const resposta = await fetch(URL, deleteRequest);
        if (!resposta.ok) throw new Error(resposta.status);
        proxsucesso();
    } catch (erro) {
        proxerro(erro);
    }
}
