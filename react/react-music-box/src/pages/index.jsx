import React from "react";
import imgOndasRosas from '../assets/imagens/sound-waves-pink.png'
import NavBar from "../components/NavBar";
import { useNavigate, Link } from "react-router-dom";

export default function Index() {

  const navegar = useNavigate();

  return (
    <>
    <NavBar/>
      <div className="container index">
        <div className="index-content">
          <div className="box-text-index">
            <div className="info-index">
              <p className="display">A música certa para a sua vida</p>
              <p className="subtitle">
                Organize suas músicas preferidas por categorias e aproveite cada
                batida!
              </p>
            </div>
            <div className="img-index"></div>
              <button className="btn" onClick={()=>navegar("/musicas")}>Começar</button>
          </div>
          <img src={imgOndasRosas} alt="" className="index-img" />
        </div>
      </div>
    </>
  );
}
