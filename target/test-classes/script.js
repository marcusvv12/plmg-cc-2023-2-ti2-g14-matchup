// DOM
const swiper = document.querySelector('#swiper');
const like = document.querySelector('#like');
const dislike = document.querySelector('#dislike');

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
      like.style.animationPlayState = 'running';
      like.classList.toggle('trigger');
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

// Selecione os ícones
const gameControllerIcon = document.getElementById("game-controller-icon");
const chatboxIcon = document.getElementById("chatbox-icon");
const personIcon = document.getElementById("person-icon");

// Adicione os eventos de clique aos ícones
gameControllerIcon.addEventListener("click", function() {
  // Redirecione para index.html
  window.location.href = "index.html";
});

chatboxIcon.addEventListener("click", function() {
  // Redirecione para chat.html
  window.location.href = "chat.html";
});

personIcon.addEventListener("click", function() {
  // Redirecione para perfil.html
  window.location.href = "perfil.html";
});

