import axios from "axios";


const api = axios.create({
    baseURL: "https://6334c586ea0de5318a08bf63.mockapi.io/musicas"
})

export default api;