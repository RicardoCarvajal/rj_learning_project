import type { GiphyRandomResponse } from "./data/giphy.respònse";

const API_KEY = 'RToCjRD3PZOJ16YopKFUfYPSpSx68B7J'

const request = fetch(`https://api.giphy.com/v1/gifs/random?api_key=${API_KEY}`)


const createImageInsideDOM = (url: string) => {
    const imgElement = document.createElement('img');
    imgElement.src = url
    document.body.append(imgElement)
}

request
    .then((response) => response.json())
    .then(({ data }: GiphyRandomResponse) => {//aplicando destructuracion de objetos
        const imgUrl = data.images.original.url
        createImageInsideDOM(imgUrl)
    })
    .catch((err) => {
        console.error(err)
    })