import React from "react";
import LogoVerde from '../assets/imagens/logo-verde.png'
import Avatar from '../assets/imagens/avatar.png'
import TargetRed from '../assets/imagens/target-red.png'
import { useNavigate } from "react-router-dom";

export default function Erro404() {

  const navegar = useNavigate();

  return (
    <>
      <body id="index-body">
        <nav>
          <div className="container">
            <img src={LogoVerde} alt="Logo" className="logo" />
            <img src={Avatar} alt="Avatar" className="avatar" />
          </div>
        </nav>
        <div className="container">
          <div className="add-music">
            <div className="formulario">
              <h1>404</h1>

              <p className="subtitle">se perdeu? nada para ver por aqui...</p>
              <button className="btn" onClick={()=>{navegar("/home")}}>voltar</button>
            </div>

            <div className="img-lateral">
              <img src={TargetRed} alt="" />
            </div>
          </div>
        </div>
      </body>
    </>
  );
}
