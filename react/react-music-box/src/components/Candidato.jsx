import React from "react";

export default function Candidato (props) { // função que representa o componente <Candidato />, que será exportado ao final
    
    const [votos, setVotos] = React.useState(0);

    function votar() {
        setVotos(votos + 1); // alterando estado "votos"
    }

    return (
        <>
            <h1>{props.nome}</h1>
            <h2>Votos: {votos}</h2>
            <button onClick={votar}>Votar</button>

        </>
    );
}
