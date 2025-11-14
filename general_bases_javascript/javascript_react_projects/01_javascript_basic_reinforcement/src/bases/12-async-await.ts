import type { GiphyRandomResponse } from "./data/giphy.respònse";

const API_KEY = 'RToCjRD3PZOJ16YopKFUfYPSpSx68B7J'

const request = fetch(`https://api.giphy.com/v1/gifs/random?api_key=${API_KEY}`)


const createImageInsideDOM = (url: string) => {
    const imgElement = document.createElement('img');
    imgElement.src = url
    document.body.append(imgElement)
}

const getRandomImageGifUrl = async (): Promise<string> => {
    const response = await fetch(`https://api.giphy.com/v1/gifs/random?api_key=${API_KEY}`)
    const { data }: GiphyRandomResponse = await response.json()
    return data.images.original.url
}

getRandomImageGifUrl().then(createImageInsideDOM)