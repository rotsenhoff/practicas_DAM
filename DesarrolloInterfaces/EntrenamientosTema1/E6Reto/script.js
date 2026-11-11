"use strict";

const formulario = document.querySelector("#formularioRegistro");
const nombre = document.querySelector("#nombre");
const correoº = document.querySelector("#correo");
const clave = document.querySelector("#clave");
const confirmacion = document.querySelector("#confirmacion");
const condiciones = document.querySelector("#condiciones");
const botonCrear = document.querySelector("#botonCrear");
const alternarClave = document.querySelector("#alternarClave");
const fortaleza = document.querySelector("#fortaleza");
const resultado = document.querySelector("#resultado");

const campos = [nombre, correo, clave, confirmacion];

function mostrarError(campo, mensaje) {
  const error = document.querySelector(`#error-${campo.id[0].toUpperCase()}${campo.id.slice(1)}`);
  campo.setAttribute("aria-invalid", "true");
  error.textContent = mensaje;
  error.hidden = false;
}

function ocultarError(campo) {
  const error = document.querySelector(`#error-${campo.id[0].toUpperCase()}${campo.id.slice(1)}`);
  campo.setAttribute("aria-invalid", "false");
  error.textContent = "";
  error.hidden = true;
}

function validarNombre() {
  const valor = nombre.value.trim();
    if (valor.length < 3) {
    mostrarError(nombre, "El nombre debe tener al menos 3 caracteres.");
    return false;
  }
    ocultarError(nombre);
    return true;
}

function validarCorreo() {
  const patronCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!patronCorreo.test(correo.value.trim())) {
    mostrarError(correo, "Escribe un correo con un formato válido.");
    return false;
  }
    ocultarError(correo);
    return true;
}

function calcularFortaleza(clave) {
    const valor = clave.value;
    let puntos = 0;
    if (valor.length >= 8) puntos += 1;
    if (/[A-ZÁÉÍÓÚÑ]/.test(valor)) puntos += 1;
    if (/[0-9]/.test(valor)) puntos += 1;
    if (/[^A-Za-zÁÉÍÓÚÑáéíóúñ0-9]/.test(valor)) puntos += 1;
    fortaleza.value = puntos;
    return puntos;
}

function validarClave() {
    const valor = clave.value;
    calcularFortaleza();
    if (valor.length < 8 || !/[A-ZÁÉÍÓÚÑ]/.test(valor) || !/[0-9]/.test(valor)) {
        mostrarError(clave, "Usa 8 caracteres como mínimo, incluyendo mayúsculas y números.");
        return false;
    }
    ocultarError(clave);
    return true;
}

function validarConfirmacion() {
    if (confirmacion.value === "" || confirmacion.value !== clave.value) {
        mostrarError(confirmacion, "Las contraseñas no coinciden.");
        return false;
    }
    ocultarError(confirmacion);
    return true;
}

function validarCondiciones() {
    const error = document.querySelector("#error-Condiciones");
    error.textContent = condiciones.checked ? "" : "Debes aceptar las condiciones.";
    error.hidden = condiciones.checked;
    return condiciones.checked;
}



