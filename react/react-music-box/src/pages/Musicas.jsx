import { useEffect, useState } from "react";

import api from "../api"; // importando a instância do Axios de "api.js"
import NavBar from "../components/NavBar";
import CardMusic from "../components/CardMusic";
import { useNavigate } from "react-router-dom";


function Musicas() {

    const navegar = useNavigate();
    
    const [musicas, setMusicas] = useState([]); // criando estado de vetor para uma lista de músicas  
    
    useEffect(()=>{
        listar()
    },[])


    function listar() {
        console.log("Requisição está sendo feita: ");

        api.get()                               // invocando o método "get" do axios utilizando a URL base instanciada em "api.js"
            .then(function (respostaObtida) {       // método get responde uma Promise que será resolvida, e quando obtiver uma resposta, cairá no "then" recebendo a resposta como parâmetro
                console.log(respostaObtida.data);   // exibindo o atributo "data", que possui o vetor de dados do objeto de resposta que foi recebido
                setMusicas(respostaObtida.data);    // utilizando o setter para alterar o valor do estado (useState) de "musicas"        
            })
            .catch((errorOcorrido) => {             // caso a requisição falhe, o "catch" pegará o erro, recebendo como parâmetro de uma função
                console.log(errorOcorrido)          // exibindo o erro que ocorreu na requisição
            });
    }


    return (
        <>
            <body>

                <NavBar/>

                <div className="container">
                    <div className="filter">
                        <button onClick={()=>{navegar("/adicionar")}} className="btn">Adicionar</button>
                    </div>
                </div>

                <div className="container">
                    <div className="music-boxes">

                        <CardMusic 
                            titulo="Caballo Homosexual de Las Montañas" 
                            artista="Karil" 
                            genero="Desconhecido" 
                            ano="2001"
                            imagem={CardMusic.imagem}
                        />
                        {
                            musicas.map((musica, index)=>{
                                return(
                                    <CardMusic
                                        key={index}
                                        id={musica.id}
                                        titulo={musica.titulo}
                                        artista={musica.artista}
                                        genero={musica.genero}
                                        ano={musica.ano}
                                        imagem={musica.imagem}
                                    />
                                )
                            })

                            
                        }

                       

                    </div>
                </div>
            </body>
        </>
    );
}

export default Musicas;