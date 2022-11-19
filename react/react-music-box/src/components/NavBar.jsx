
import ImagemLogo from '../assets/imagens/logo-verde.png';
import Avatar from '../assets/imagens/avatar.png';

export default function NavBar() {
    return (
        <>
            <nav>
                <div className="container">
                    <img src={ImagemLogo} alt="Logo" className="logo" />
                    <img src={Avatar} alt="Avatar" className="avatar" />
                </div>
            </nav>
        </>
    )
}