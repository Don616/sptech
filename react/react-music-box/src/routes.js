import React from "react";
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Musicas from "./pages/Musicas";
import Index from "./pages";
import Adicionar from "./pages/Adicionar";
import Erro404 from "./pages/Erro404";

export default function Rotas(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/home" element={<Index />}/>
                <Route path="/musicas" element={<Musicas/>}/>
                <Route path="/adicionar" element={<Adicionar/>}/>
                <Route path="/*" element={<Erro404/>}/>
            </Routes>
        </BrowserRouter>
    )
}