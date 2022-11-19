import React, { useState } from "react";
import LogoVerde from "../assets/imagens/logo-verde.png";
import Avatar from "../assets/imagens/avatar.png";
import Circulo from "../assets/imagens/half-circles-pink-blue.png";
import { useNavigate } from "react-router-dom";
import api from "../api";

export default function Adicionar(props) {
  const navegar = useNavigate();
  const [musica, setMusica] = useState([]);
  const [artista, setArtista] = useState(props.artista);
  const [genero, setGenero] = useState(props.genero);
  const [ano, setAno] = useState(props.ano);

  function post() {

    

    const musicaAtual = {
      musica,
      artista,
      genero,
      ano,
    };
    api
      .post(`/`, musicaAtual)
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
    navegar("/musicas");
  }

  return (
    <div className="container">
      <div className="add-music">
        <div className="formulario">
          <h1>Adicionar</h1>

          <br />

          <div className="formObj">
            <label>
              Música: <br />
              <input
                type="text"
                onInput={(event) => setMusica(event.target.value)}
              />
            </label>
            <br />
            <label>
              Artista: <br />
              <input
                type="text"
                onInput={(event) => setArtista(event.target.value)}
              />
            </label>
            <br />
            <label>
              Genêro: <br />
              <input
                type="text"
                onInput={(event) => setGenero(event.target.value)}
              />
            </label>
            <br />
            <label>
              Ano de Lançamento: <br />
              <input
                type="text"
                onInput={(event) => setAno(event.target.value)}
              />
            </label>
            <br />
            <label>
              {" "}
              Imagem (url): <br />
              <input type="text" />
            </label>
            <br />
            <button
              className="btn"
              onClick={() => {
                post();
              }}
            >
              Enviar
            </button>
          </div>
        </div>

        <div className="img-lateral">
          <img src={Circulo} alt="" />
        </div>
      </div>
    </div>
  );
}
