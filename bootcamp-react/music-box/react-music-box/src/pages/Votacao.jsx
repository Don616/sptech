import React from 'react';
import Candidato from '../components/Candidato';

export default function Votacao(props) {
    return (
        <>
            <h1>VOTE NA SUA BATATOSA FAVORITA: </h1>

            <Candidato nome="Batata Frita" /> <br /> 
            <Candidato nome="Batata com Cebola" /> <br />
            <Candidato nome="Batata Assada" /> <br /> 
            <Candidato nome="Batata Rústica" /> <br />
            <Candidato nome="Batata Palha" /> <br />

        </>
    )
}