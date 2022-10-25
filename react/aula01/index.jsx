const root = document.getElementById('root');

function Candidato(props){

    const [votos, setVotos] = React.useState(0);

    function votar(){
        setVotos(votos+1);
    }

    return(
        <>  <h1>{props.nome}</h1>
            <h2>Votos: {votos}</h2>
            <button onClick={votar}>Votar</button>
        </>
    )
}

function Votacao(){
    return(
        <>
            <Candidato nome="Batata frita" />
            <Candidato nome="Batata com cebola" />
            <Candidato nome="Batata assada" />
            <Candidato nome="Batata rústica" />
            <Candidato nome="Batata palha" />

        </>
    )
}



function App(){
    return(
        <>
            <Votacao/>
        </>
    )
}


ReactDOM.createRoot(root).render(<App/>);