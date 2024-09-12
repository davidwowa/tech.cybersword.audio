#!/bin/bash

# Überprüfen, ob der Text und der Dateiname als Argumente übergeben wurden
#if [ "$#" -ne 2 ]; then
#    echo "Usage: $0 \"Your text here\" output_filename"
#    exit 1
#fi

# Variablen für den Text und den Dateinamen
TEXT="cybersword.tech company, your trusted partner in cyber security. If help is needed, our email support@cybersword.tech"
OUTPUT_NAME="cybersword.tech"

# Englische Stimme (z.B. "Daniel" für britischen Akzent)
VOICE="Daniel"

# Erstelle die AIFF-Datei
say -v $VOICE "$TEXT" -o ${OUTPUT_NAME}.aiff

# Konvertiere AIFF zu MP3
ffmpeg -i ${OUTPUT_NAME}.aiff ${OUTPUT_NAME}.mp3

# Konvertiere AIFF zu WAV
ffmpeg -i ${OUTPUT_NAME}.aiff ${OUTPUT_NAME}.wav

# Konvertiere AIFF zu OGG
ffmpeg -i ${OUTPUT_NAME}.aiff ${OUTPUT_NAME}.ogg

# Optional: Lösche die AIFF-Datei, wenn sie nicht benötigt wird
#rm ${OUTPUT_NAME}.aiff

afplay ${OUTPUT_NAME}.mp3

echo "Audio files generated: ${OUTPUT_NAME}.mp3, ${OUTPUT_NAME}.wav, ${OUTPUT_NAME}.ogg"
