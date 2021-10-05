var nota;
var media = 0;
var cliques = 0;
var media_geral = 0;

function avaliarAtendente(){

    nota = (Math.random() * 5).toFixed(1);
    
    
    if(nota >= 0 && nota <= 0.5){
        span_texto.innerHTML = `Sua nota é ${nota}`;
        emoji.src = "https://i.pinimg.com/originals/a1/91/4b/a1914bffe44bc754903c03b82fc203f5.png";
        mediaGeral()
    } else if(nota > 0.5 && nota <= 1.5){
        span_texto.innerHTML = `Sua nota é ${nota}`;
        emoji.src = "https://images.emojiterra.com/google/android-11/512px/1f622.png";
        mediaGeral()
    } else if(nota > 1.5 && nota <= 3.5){
        span_texto.innerHTML = `Sua nota é ${nota}`;
        emoji.src = "https://cdn.pixabay.com/photo/2020/12/19/02/50/emoji-5843433_960_720.png";
        mediaGeral()
    } else if(nota > 3.5 && nota <= 4.5){
        span_texto.innerHTML = `Sua nota é ${nota}`;
        emoji.src = "https://cdn.pixabay.com/photo/2017/03/05/21/55/emoticon-2120024_640.png";
        mediaGeral()
    } else {
        span_texto.innerHTML = `Sua nota é ${nota}`;
        emoji.src = "https://st2.depositphotos.com/5945712/10990/i/600/depositphotos_109907872-stock-photo-emoticons-emoji-smile-icons-isolated.jpg";
        mediaGeral()
    }



}

function mediaGeral(){

    media += Number(nota);
    cliques++;
    media_geral = media / cliques

    span_media.innerHTML = `Sua média é ${media_geral.toFixed(1)}`

    if(media_geral >= 0 && media_geral <= 0.5){
        
        emoji2.src = "https://i.pinimg.com/originals/a1/91/4b/a1914bffe44bc754903c03b82fc203f5.png";
        
    } else if(media_geral > 0.5 && media_geral <= 1.5){
        
        emoji2.src = "https://images.emojiterra.com/google/android-11/512px/1f622.png";
        
    } else if(media_geral > 1.5 && media_geral <= 3.5){
        
        emoji2.src = "https://cdn.pixabay.com/photo/2020/12/19/02/50/emoji-5843433_960_720.png";
        
    } else if(media_geral > 3.5 && media_geral <= 4.5){
        
        emoji2.src = "https://cdn.pixabay.com/photo/2017/03/05/21/55/emoticon-2120024_640.png";
        
    } else {
        
        emoji2.src = "https://st2.depositphotos.com/5945712/10990/i/600/depositphotos_109907872-stock-photo-emoticons-emoji-smile-icons-isolated.jpg";
        
    }
}