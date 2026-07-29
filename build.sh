#!/bin/bash
# Compila o projeto inteiro.
set -e
javac -encoding UTF-8 -d out $(find src -name "*.java")
echo "Build concluído. Use ./run-programacao.sh, ./run-geral.sh ou ./run-multiplayer.sh"
