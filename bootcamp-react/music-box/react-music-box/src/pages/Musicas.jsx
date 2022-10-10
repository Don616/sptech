import React from "react";
import api from "../api";

export default function Musicas(props){

    const [getMusicas,setMusicas] = React.useState([]);

    function listar(){
        api.get()
        .then((response)=>{
            console.table(response.data)
            setMusicas(response.data)
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    return(
        <>
        <button onClick={listar}>Listar Musicas</button>
        {getMusicas.map((musica)=>(
            <div key={musica.id}>
                {musica.titulo}
            </div>
        ))}
        </>
    )
}