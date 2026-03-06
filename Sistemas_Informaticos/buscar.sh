#!/bin/bash
# Script para buscar un archivo en el sistema
# Uso: ./buscar.sh nombre_del_archivo

# 1) Validación: deben venir exactamente 2 parámetros
if [ "$#" -ne 2 ]; then
  echo "Error: número de parámetros incorrecto."
  echo "Uso: ./buscar.sh <directorio> <nombre_archivo>"
  exit 1
fi

# 2) Asignación a variables (con comillas para soportar espacios)
DIRECTORIO_BUSQUEDA="$1"
NOMBRE_ARCHIVO="$2"

# 3) Búsqueda con find (el * permite buscar por “parte del nombre”)
echo "Buscando en: $DIRECTORIO_BUSQUEDA"
echo "Patrón: *$NOMBRE_ARCHIVO*"
find "$DIRECTORIO_BUSQUEDA" -name "*$NOMBRE_ARCHIVO*"
echo "Búsqueda finalizada."