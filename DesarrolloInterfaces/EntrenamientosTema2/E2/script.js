"use strict";

const formulario = document.querySelector("#formulario");
const resultado = document.querySelector("#resultado");

formulario.addEventListener("submit", function (evento) {
    evento.preventDefault();
   resultado.textContent = "Los datos son válidos y están listos para enviarse."; 
});