async function asyncCriarMusica(dadosMusica, proxsucesso, proxerro) {
    const URL = `/api/musicas`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosMusica),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(() => proxsucesso())
        .catch(proxerro);
}

async function asyncLerMusicas(proxsucesso, proxerro) {
    const URL = `/api/musicas`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerMusicaById(id, proxsucesso, proxerro) {
    const URL = `/api/musicas/${id}`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarMusica(dadosMusica, proxsucesso, proxerro) {
    const URL = `/api/musicas/${dadosMusica.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosMusica),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(() => proxsucesso())
        .catch(proxerro);
}

async function asyncApagarMusica(id, proxsucesso, proxerro) {
    const URL = `/api/musicas/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(() => proxsucesso())
        .catch(proxerro);
}
