/*Este script permite validar un formulario de manera sencilla y mostrar mensajes de error si el nombre está vacío*/

"use strict";

const formulario = document.querySelector("#formulario");
const nombre = document.querySelector("#nombre");
const errorNombre = document.querySelector("#errorNombre");
const resultado = document.querySelector("#resultado");

function validarNombre() {
const estaVacio = nombre.value.trim() === "";
errorNombre.hidden = !estaVacio;
nombre.setAttribute("aria-invalid", String(estaVacio));
return !estaVacio;
}

formulario.addEventListener("submit", (evento) => {
evento.preventDefault();
resultado.textContent = "";

    if (!validarNombre()) {
    nombre.focus();
    return;
    }

    resultado.textContent = `Formulario preparado para ${nombre.value.trim()}.`;
});

nombre.addEventListener("input", () => {
    
    if (!errorNombre.hidden) {
    validarNombre();
    }
});