
const root = window.document.getElementById("root");

function Titulo(props){
    return(
        <>
        <h1>{props.texto}</h1>
        </>
        
    );
}

function Titulos(){
    return(
        <>
            <Titulo texto="Este é o 1 titulo"/>
            <Titulo texto="Este é o 2 titulo"/>
            <Titulo texto="Este é o 3 titulo"/>
            <Titulo texto="Este é o 4 titulo"/>
            <Titulo texto="Este é o 5 titulo"/>
        </>
    )
}

ReactDOM.createRoot(root).render(<Titulos/>)