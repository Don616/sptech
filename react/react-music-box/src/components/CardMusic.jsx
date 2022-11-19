import ImagemEdit from "../assets/imagens/edit-icon.png";
import ImagemDelete from "../assets/imagens/delete-icon.png";
import ImgCapaDefault from "../assets/imagens/capa.png";
import { useState } from "react";
import api from "../api";

export default function CardMusic(props) {
  const imagem = {
    backgroundImage: `url(${props.imagem ? props.imagem : ImgCapaDefault})`,
  };

  const [editando, setEditando] = useState(false);

  const [titulo, setTitulo] = useState(props.titulo);
  const [artista, setArtista] = useState(props.artista);
  const [genero, setGenero] = useState(props.genero);
  const [ano, setAno] = useState(props.ano);

  function atualizar(){
    setEditando(false)
    const musicaAtual = {
        titulo,
        artista,
        genero,
        ano
    }
    api.put(`/${props.id}`,musicaAtual)
        
  }

  function deletar(){
    api.delete(`/${props.id}`)
    window.location.reload()
  }

  return (
    <>
      <div style={imagem} className="card-music">
        <div className="icons">
          <img
            onClick={() => setEditando(true)}
            src={editando ? "" : ImagemEdit}
            alt=""
          />
          <img onClick={deletar} src={ImagemDelete} alt="" />
        </div>
        <div className="info-music">
          <p>
            <strong className="card-title">música: </strong>
            <input
              disabled={!editando}
              className={
                editando ? "input-music-enable" : "input-music-disable"
              }
              type="text"
              defaultValue={props.titulo}
              onInput={(event)=> setTitulo(event.target.value)}
            />
          </p>
          <p>
            <strong className="card-title">artista: </strong>
            <input
              disabled={!editando}
              className={
                editando ? "input-music-enable" : "input-music-disable"
              }
              type="text"
              defaultValue={props.artista}
              onInput={(event)=> setArtista(event.target.value)}
            />
          </p>
          <p>
            <strong className="card-title">gênero: </strong>
            <input
              disabled={!editando}
              className={
                editando ? "input-music-enable" : "input-music-disable"
              }
              type="text"
              defaultValue={props.genero}
              onInput={(event)=> setGenero(event.target.value)}
            />
          </p>
          <p>
            <strong className="card-title">ano: </strong>
            <input
              disabled={!editando}
              className={
                editando ? "input-music-enable" : "input-music-disable"
              }
              type="text"
              defaultValue={props.ano}
              onInput={(event)=> setAno(event.target.value)}
            />
          </p>
          <button
            onClick={() =>{
                atualizar()
            }}
            className={editando ? "btn-salvar-enable" : "btn-salvar-disabled"}
          >
            Salvar
          </button>
        </div>
      </div>
    </>
  );
}
