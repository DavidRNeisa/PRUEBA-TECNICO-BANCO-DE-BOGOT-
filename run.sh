#!/bin/bash

echo "========================================="
echo "  SISTEMA DE PRACTICANTES - INICIO"
echo "========================================="
echo ""

# Verificar PostgreSQL
if ! systemctl is-active --quiet postgresql; then
    echo "[1/3] Iniciando PostgreSQL..."
    sudo systemctl start postgresql
else
    echo "[1/3] PostgreSQL ya está corriendo"
fi

# Crear BD si no existe
echo "[2/3] Verificando base de datos..."
sudo -u postgres psql -tc "SELECT 1 FROM pg_database WHERE datname = 'practicantes_db'" | grep -q 1 || \
    sudo -u postgres psql -c "CREATE DATABASE practicantes_db OWNER davidrneisa"

# Iniciar aplicación
echo "[3/3] Iniciando aplicación..."
echo ""
echo "  Accede en: http://localhost:8080"
echo "  Usuario: analista"
echo "  Clave:   analista123"
echo ""
echo "  Ctrl+C para detener"
echo "========================================="
mvn spring-boot:run
