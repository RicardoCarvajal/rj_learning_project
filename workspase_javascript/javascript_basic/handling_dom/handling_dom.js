const h1 = document.querySelector('h1');
const p = document.querySelector('p');
const input = document.getElementById('in_1');


console.log(input);
console.log(h1);
console.log({h1,p});

//Coloca nuevo HTML
h1.innerHTML = 'Manipulando <br> DOM de H1';

//Coloca nuevo texto
h1.innerText = 'Manipulando <br> DOM de H1';

input.value = 'Manipulando DOM en input'