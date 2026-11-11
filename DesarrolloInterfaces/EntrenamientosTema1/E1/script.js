/*Este script permite resaltar un botón cuando el ratón está sobre él y mostrar un mensaje de estado correspondiente*/

"use strict";

const boton = document.querySelector('#botonInteractivo');
const estado = document.querySelector('#estado');

function activarResaltado() {

    boton.classList.add('resaltado');
    estado.textContent = 'El ratón está sobre el botón';
}

function desactivarResaltado() {

    boton.classList.remove('resaltado');
    estado.textContent = 'El ratón ha dejado el botón';
}

boton.addEventListener("mouseenter", activarResaltado);
boton.addEventListener("mouseleave", desactivarResaltado);
