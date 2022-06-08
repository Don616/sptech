function pesquisar() {
    var pesquisa = (ipt_pesquisa.value).toLowerCase()
    if (pesquisa.startsWith ('j') || pesquisa.startsWith ('jd') || pesquisa.startsWith ('jd.')) {
        // aparecendo os jds
        jd1.style.display = 'block'
        jd2.style.display = 'block'
        jd3.style.display = 'block'
        jd4.style.display = 'block'
        jd5.style.display = 'block'
        
        // sumindo os metros
        metro1.style.display = 'none'
        metro2.style.display = 'none'
        metro3.style.display = 'none'
        metro4.style.display = 'none'
        metro5.style.display = 'none'

        // sumindo os demais
        ale2.style.display = 'none'
        ale3.style.display = 'none'
        ale4.style.display = 'none'
    }

    else if (pesquisa.startsWith ('m') || pesquisa.startsWith ('me') || pesquisa.startsWith ('met') || pesquisa.startsWith ('metr') || pesquisa.startsWith ('metro')) {
        // sumindo os jds
        jd1.style.display = 'none'
        jd2.style.display = 'none'
        jd3.style.display = 'none'
        jd4.style.display = 'none'
        jd5.style.display = 'none'
        
        // aparecendo os metros
        metro1.style.display = 'block'
        metro2.style.display = 'block'
        metro3.style.display = 'block'
        metro4.style.display = 'block'
        metro5.style.display = 'block'

        // sumindo os demais
        ale2.style.display = 'none'
        ale3.style.display = 'none'
        ale4.style.display = 'none'
    }

    else {
        // aparecendo todos
        jd1.style.display = 'block'
        jd2.style.display = 'block'
        jd3.style.display = 'block'
        jd4.style.display = 'block'
        jd5.style.display = 'block'
        
        metro1.style.display = 'block'
        metro2.style.display = 'block'
        metro3.style.display = 'block'
        metro4.style.display = 'block'
        metro5.style.display = 'block'

        ale2.style.display = 'block'
        ale3.style.display = 'block'
        ale4.style.display = 'block'
    }
}