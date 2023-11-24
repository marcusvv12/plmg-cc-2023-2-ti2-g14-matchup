// DOM
const swiper = document.querySelector('#swiper');
const like = document.querySelector('#like');
const dislike = document.querySelector('#dislike');
const heartIcon = document.getElementById("like"); // Alterado para o ícone de coração

// constants
const urls = [
  'img/bjorn.png',
  'img/Annie.png',
  'img/XXsasukeXX.png',
  'img/Robertin.png',
  'img/Lucas.png',
];

// variables
let cardCount = 0;

// functions
function appendNewCard() {
  const card = new Card({
    imageUrl: urls[cardCount % 5],
    onDismiss: appendNewCard,
    onLike: () => {
      heartIcon.style.animationPlayState = 'running'; // Alterado para heartIcon
      heartIcon.classList.toggle('trigger');
    },
    onDislike: () => {
      dislike.style.animationPlayState = 'running';
      dislike.classList.toggle('trigger');
    }
  });
  swiper.append(card.element);
  cardCount++;

  const cards = swiper.querySelectorAll('.card:not(.dismissing)');
  cards.forEach((card, index) => {
    card.style.setProperty('--i', index);
  });
}

// first 5 cards
for (let i = 0; i < 5; i++) {
  appendNewCard();
}


// Event listeners
heartIcon.addEventListener("click", function() {
  // Implement the logic to go to the next card (like action)
  const cards = swiper.querySelectorAll('.card:not(.dismissing)');
  if (cards.length > 0) {
    cards[0].remove();
    appendNewCard();

    // Adiciona a classe 'opaque' para definir a opacidade como 100%
    heartIcon.classList.add('opaque');
    
    // Remove a classe 'opaque' após 1 segundo
    setTimeout(() => {
      heartIcon.classList.remove('opaque');
    }, 400);
    
    // Remove a classe 'trigger' após a animação
    setTimeout(() => {
      heartIcon.classList.remove('trigger');
    }, 400); // Ajuste o tempo conforme necessário
  }
});

dislike.addEventListener("click", function() {
  // Implement the logic to go to the next card (dislike action)
  const cards = swiper.querySelectorAll('.card:not(.dismissing)');
  if (cards.length > 0) {
    cards[0].remove();
    appendNewCard();

    // Adiciona a classe 'opaque' para definir a opacidade como 100%
    dislike.classList.add('opaque');
    
    // Remove a classe 'opaque' após 1 segundo
    setTimeout(() => {
      dislike.classList.remove('opaque');
    }, 400);
    
    // Remove a classe 'trigger' após a animação
    setTimeout(() => {
      dislike.classList.remove('trigger');
    }, 400); // Ajuste o tempo conforme necessário
  }
});

// ...