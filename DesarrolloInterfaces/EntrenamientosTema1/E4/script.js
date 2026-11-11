/*Este script permite la pulsación de un botón y muestra un contador*/

"use strict";
const botonMensaje = document.querySelector("#botonMensaje");
const contador = document.querySelector("#contador");
let numeroPulsaciones = 0;

function cambiarTexto() {
    numeroPulsaciones += 1;
    botonMensaje.textContent = numeroPulsaciones % 2 === 1
        ? "Has hecho clic"
        : "Haz clic de nuevo";
    contador.textContent = `Pulsaciones: ${numeroPulsaciones}`;
}

botonMensaje.addEventListener("click", cambiarTexto);