/*Este script permite activar un formulario de una manera sencilla*/

"use strict";
const formulario = document.querySelector("#formulario");
const nombre = document.querySelector("#nombre");
const botonEnviar = document.querySelector("#botonEnviar");
const ayudaNombre = document.querySelector("#ayudaNombre");
const resultado = document.querySelector("#resultado");

function actualizarEstadoDelBoton() {
const hayNombre = nombre.value.trim() !== "";
botonEnviar.disabled = !hayNombre;
ayudaNombre.textContent = hayNombre
    ? "El nombre es válido y ya puedes enviar el formulario."
    : "El botón se habilitará cuando escribas un nombre.";
}

nombre.addEventListener("input", actualizarEstadoDelBoton);

formulario.addEventListener("submit", (evento) => {
    evento.preventDefault();
    resultado.textContent = `Envío preparado para ${nombre.value.trim()}.`;
});

actualizarEstadoDelBoton();