import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.stem import PorterStemmer
import pandas as pd
import argparse

def calcular_similitud_codigo(codigo1, codigo2):
    # Preprocesamiento de los códigos fuente
    codigo1 = preprocesar_codigo(codigo1)
    codigo2 = preprocesar_codigo(codigo2)
    
    # Tokenización de los códigos fuente en palabras
    palabras1 = word_tokenize(codigo1)
    palabras2 = word_tokenize(codigo2)
    
    # Eliminación de palabras irrelevantes (stop words)
    stop_words = set(stopwords.words('english'))  # Puedes ajustar el idioma según tus necesidades
    palabras1 = [palabra for palabra in palabras1 if palabra.casefold() not in stop_words]
    palabras2 = [palabra for palabra in palabras2 if palabra.casefold() not in stop_words]
    
    # Stemming de las palabras
    stemmer = PorterStemmer()
    palabras1 = [stemmer.stem(palabra) for palabra in palabras1]
    palabras2 = [stemmer.stem(palabra) for palabra in palabras2]
    
    # Cálculo de la similitud entre los códigos fuente
    similitud = nltk.jaccard_distance(set(palabras1), set(palabras2))
    
    return similitud

def preprocesar_codigo(codigo):
    # Aquí puedes agregar cualquier preprocesamiento adicional según tus necesidades
    codigo = codigo.replace('\n', ' ')  # Reemplazar saltos de línea por espacios en blanco
    
    return codigo

def leer_archivo_csv(ruta_csv):
    # Leer el archivo CSV con los códigos fuente
    df = pd.read_csv(ruta_csv)
    
    # Obtener una lista de los códigos fuente
    codigos = df['codigo'].tolist()
    
    return codigos

def main():
    # Configurar el argumento de línea de comandos para la ruta del archivo CSV
    parser = argparse.ArgumentParser()
    parser.add_argument('ruta_csv', type=str, help='Ruta del archivo CSV con los códigos fuente')
    args = parser.parse_args()
    
    # Leer los códigos fuente del archivo CSV
    codigos = leer_archivo_csv(args.ruta_csv)
    
    # Calcular la similitud de los pares de códigos fuente
    resultados = []
    for i in range(len(codigos)):
        for j in range(i+1, len(codigos)):
            codigo1 = codigos[i]
            codigo2 = codigos[j]
            similitud = calcular_similitud_codigo(codigo1, codigo2)
            resultados.append((i, j, similitud))
    
    # Mostrar los resultados
    for resultado in resultados:
        codigo1_index, codigo2_index, similitud = resultado
        print(f"Código {codigo1_index} vs Código {codigo2_index}: {similitud}")

if __name__ == '__main__':
    main()
