import os
import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.stem import WordNetLemmatizer
import tkinter as tk
from tkinter import filedialog, messagebox
import difflib
from matplotlib import pyplot as plt
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
from py_stringmatching import Jaccard
from pygments import lex
from pygments.lexers.jvm import JavaLexer
from pygments.token import Token
from sklearn.cluster import KMeans
from sklearn.decomposition import LatentDirichletAllocation
import datetime

nltk.download('punkt')
nltk.download('stopwords')
nltk.download('wordnet')


class CodigoSimilaridadApp(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Detección de Similitud de Códigos Fuente")
        self.directorio_entrenamiento = ""
        self.archivos_entrenamiento = []
        self.archivos_analisis = []
        self.create_widgets()

    def create_widgets(self):
        # Etiqueta de instrucciones
        instrucciones_label = tk.Label(self, text="Seleccione una carpeta de archivos de comparacion:")
        instrucciones_label.pack(pady=10)

        # Botón para seleccionar carpeta de entrenamiento
        carpeta_entrenamiento_button = tk.Button(self, text="Seleccionar Carpeta", command=self.seleccionar_carpeta_entrenamiento)
        carpeta_entrenamiento_button.pack(pady=5)

        # Botón para seleccionar archivos de análisis
        archivos_analisis_button = tk.Button(self, text="Seleccionar Archivos de Análisis", command=self.seleccionar_archivos_analisis)
        archivos_analisis_button.pack(pady=5)

        # Botón para iniciar el análisis
        analisis_button = tk.Button(self, text="Iniciar Análisis", command=self.iniciar_analisis)
        analisis_button.pack(pady=10)

    def seleccionar_carpeta_entrenamiento(self):
        self.directorio_entrenamiento = filedialog.askdirectory()
        self.archivos_entrenamiento = self.obtener_archivos_java(self.directorio_entrenamiento)

        messagebox.showinfo("Carpeta seleccionada", f"Se ha seleccionado la carpeta: {self.directorio_entrenamiento}")

    def seleccionar_archivos_analisis(self):
        archivos_analisis = filedialog.askopenfilenames(filetypes=[("Archivos Java", "*.java")], title="Seleccionar archivos de análisis", multiple=True)
        self.archivos_analisis = list(archivos_analisis)

        messagebox.showinfo("Archivos de análisis seleccionados", f"Se han seleccionado {len(self.archivos_analisis)} archivos de análisis.")

    def obtener_archivos_java(self, directorio):
        archivos = []
        for root, dirs, files in os.walk(directorio):
            for file in files:
                if file.endswith(".java"):
                    archivos.append(os.path.join(root, file))
        return archivos

    def preprocesar_codigo(self, codigo):
        # Tokenización
        tokens = word_tokenize(codigo)

        # Eliminación de palabras vacías (stopwords)
        stop_words = set(stopwords.words('english'))
        tokens = [word for word in tokens if word.casefold() not in stop_words]

        # Lematización
        lemmatizer = WordNetLemmatizer()
        tokens = [lemmatizer.lemmatize(word) for word in tokens]

        # Reconstrucción del código preprocesado
        codigo_preprocesado = ' '.join(tokens)

        return codigo_preprocesado

    def calcular_similitud_diff(self, codigo1, codigo2):
        # Cálculo de la similitud utilizando difflib
        similitud = difflib.SequenceMatcher(None, codigo1, codigo2).ratio()
        return similitud

    def tokenizar_codigo(self, codigo):
        lexer = JavaLexer()
        tokens = lex(codigo, lexer)
        tokens = [token for token in tokens if token[0] not in Token.Comment]
        tokens = [token[1] for token in tokens]
        return tokens

    def calcular_similitud_jaccard(self, codigo1, codigo2):
        # Tokenización y preprocesamiento
        tokens1 = self.tokenizar_codigo(codigo1)
        tokens2 = self.tokenizar_codigo(codigo2)

        # Calcular la similitud de Jaccard
        jaccard = Jaccard()
        similitud = jaccard.get_sim_score(tokens1, tokens2)
        return similitud

    def calcular_similitud_cosine(self, codigo1, codigo2):
        # Preprocesamiento de los códigos fuente
        codigo1_preprocesado = self.preprocesar_codigo(codigo1)
        codigo2_preprocesado = self.preprocesar_codigo(codigo2)

        # Cálculo de la similitud del coseno
        vectorizer = TfidfVectorizer()
        vector = vectorizer.fit_transform([codigo1_preprocesado, codigo2_preprocesado])
        similitud = cosine_similarity(vector[0], vector[1])[0][0]
        return similitud

    def detectar_similitud(self, codigo1, codigo2):
        similitud_diff = self.calcular_similitud_diff(codigo1, codigo2)
        similitud_jaccard = self.calcular_similitud_jaccard(codigo1, codigo2)
        similitud_cosine = self.calcular_similitud_cosine(codigo1, codigo2)
        return similitud_diff, similitud_jaccard, similitud_cosine

    def calcular_porcentaje_similitud(self, similitud):
        return round(similitud * 100, 2)

    def clustering(self, archivos):
        # Vectorización TF-IDF
        vectorizer = TfidfVectorizer()
        matriz_tfidf = vectorizer.fit_transform(archivos)

        # Reducción de dimensionalidad con LDA
        lda = LatentDirichletAllocation(n_components=2)
        matriz_lda = lda.fit_transform(matriz_tfidf)

        # Clustering con K-Means
        kmeans = KMeans(n_clusters=2, random_state=42)
        kmeans.fit(matriz_lda)

        # Asignar clusters a los archivos
        clusters = kmeans.labels_
        return clusters

    def mostrar_similitudes_diff_grafico(self, resultados_similitud):
        x = range(len(resultados_similitud))
        y = [resultado[2] for resultado in resultados_similitud]  # Similitud Diff
        plt.bar(x, y)
        plt.xticks(x, [f"{i+1}" for i in x])
        plt.xlabel("Pares de archivos")
        plt.ylabel("Similitud Diff")
        plt.title("Similitud Diff entre pares de archivos")
        plt.show()

    def mostrar_similitudes_jaccard_grafico(self, resultados_similitud):
        x = range(len(resultados_similitud))
        y = [resultado[3] for resultado in resultados_similitud]  # Similitud Jaccard
        plt.bar(x, y)
        plt.xticks(x, [f"{i+1}" for i in x])
        plt.xlabel("Pares de archivos")
        plt.ylabel("Similitud Jaccard")
        plt.title("Similitud Jaccard entre pares de archivos")
        plt.show()

    def mostrar_similitudes_cosine_grafico(self, resultados_similitud):
        x = range(len(resultados_similitud))
        y = [resultado[4] for resultado in resultados_similitud]  # Similitud Cosine
        plt.bar(x, y)
        plt.xticks(x, [f"{i+1}" for i in x])
        plt.xlabel("Pares de archivos")
        plt.ylabel("Similitud Cosine")
        plt.title("Similitud Cosine entre pares de archivos")
        plt.show()

    def generar_reporte(self, resultados_similitud, clusters):
        now = datetime.datetime.now()
        fecha_hora = now.strftime("%Y-%m-%d_%H-%M-%S")
        nombre_archivo = f"reporte_similitud_{fecha_hora}.txt"
        
        with open(nombre_archivo, 'w') as archivo_reporte:
            for resultado in resultados_similitud:
                archivo_analisis = resultado[0]
                archivo_entrenamiento = resultado[1]
                similitud_diff = resultado[2]
                similitud_jaccard = resultado[3]
                similitud_cosine = resultado[4]
                cluster_analisis = clusters[self.archivos_analisis.index(archivo_analisis)]
                cluster_entrenamiento = clusters[self.archivos_entrenamiento.index(archivo_entrenamiento)]
                porcentaje_similitud_diff = self.calcular_porcentaje_similitud(similitud_diff)
                porcentaje_similitud_jaccard = self.calcular_porcentaje_similitud(similitud_jaccard)
                porcentaje_similitud_cosine = self.calcular_porcentaje_similitud(similitud_cosine)

                archivo_reporte.write(f"Archivo de análisis: {archivo_analisis}\n")
                archivo_reporte.write(f"Archivo de otro usuario: {archivo_entrenamiento}\n")
                archivo_reporte.write(f"Similitud de código (Diff): {similitud_diff}\n")
                archivo_reporte.write(f"Similitud de código (Jaccard): {similitud_jaccard}\n")
                archivo_reporte.write(f"Similitud de código (Cosine): {similitud_cosine}\n")
                archivo_reporte.write(f"Porcentaje de similitud (Diff): {porcentaje_similitud_diff}%\n")
                archivo_reporte.write(f"Porcentaje de similitud (Jaccard): {porcentaje_similitud_jaccard}%\n")
                archivo_reporte.write(f"Porcentaje de similitud (Cosine): {porcentaje_similitud_cosine}%\n")
                archivo_reporte.write(f"Cluster de análisis: {cluster_analisis}\n")
                archivo_reporte.write(f"Cluster de otro usuario: {cluster_entrenamiento}\n")
                archivo_reporte.write("---\n")

        messagebox.showinfo("Reporte generado", f"Se ha generado el archivo de reporte: {nombre_archivo}")

    def mostrar_similitud_grafica(self, codigo1, codigo2):
        fig, (ax1, ax2) = plt.subplots(2, 1, figsize=(8, 6))
        fig.suptitle('Similitud de Código Fuente')

        ax1.set_title('Código de Análisis')
        ax1.text(0.1, 0.5, codigo1, fontsize=10, verticalalignment='center', color='blue')
        ax1.axis('off')

        ax2.set_title('Código de otro usuario')
        ax2.text(0.1, 0.5, codigo2, fontsize=10, verticalalignment='center', color='red')
        ax2.axis('off')

        plt.show()


    def mostrar_siguiente_similitud(self):
        if self.resultados_similitud:
            resultado = self.resultados_similitud.pop(0)
            archivo_analisis = resultado[0]
            archivo_entrenamiento = resultado[1]
            similitud_diff = resultado[2]
            similitud_jaccard = resultado[3]
            similitud_cosine = resultado[4]
            codigo_analisis = resultado[5]
            codigo_entrenamiento = resultado[6]
            porcentaje_similitud_diff = self.calcular_porcentaje_similitud(similitud_diff)
            porcentaje_similitud_jaccard = self.calcular_porcentaje_similitud(similitud_jaccard)
            porcentaje_similitud_cosine = self.calcular_porcentaje_similitud(similitud_cosine)

            messagebox.showinfo("Similitud de código", f"Archivo de análisis: {archivo_analisis}\n\n"
                                                      f"Archivo de otro usuario: {archivo_entrenamiento}\n\n"
                                                      f"Porcentaje de similitud (Diff): {porcentaje_similitud_diff}%\n\n"
                                                      f"Porcentaje de similitud (Jaccard): {porcentaje_similitud_jaccard}%\n\n"
                                                      f"Porcentaje de similitud (Cosine): {porcentaje_similitud_cosine}%")
            self.mostrar_similitud_grafica(codigo_analisis, codigo_entrenamiento)
            self.actualizar_estado_analisis()
        else:
            self.generar_reporte(self.resultados_similitud_original, self.clusters)

    def actualizar_estado_analisis(self):
        if self.resultados_similitud:
            estado_analisis_label.config(text=f"Resultados de Similitud: {len(self.resultados_similitud)}")
        else:
            estado_analisis_label.config(text="Análisis completado")

    def iniciar_analisis(self):
        if not self.directorio_entrenamiento:
            messagebox.showwarning("Error", "Por favor, seleccione una carpeta de archivos de entrenamiento.")
            return

        if not self.archivos_analisis:
            messagebox.showwarning("Error", "Por favor, seleccione al menos un archivo de análisis.")
            return

        self.resultados_similitud_original = []
        for archivo_analisis in self.archivos_analisis:
            with open(archivo_analisis, 'r') as archivo_analisis_file:
                codigo_analisis = archivo_analisis_file.read()

                for archivo_entrenamiento in self.archivos_entrenamiento:
                    with open(archivo_entrenamiento, 'r') as archivo_entrenamiento_file:
                        codigo_entrenamiento = archivo_entrenamiento_file.read()
                        similitud_diff, similitud_jaccard, similitud_cosine = self.detectar_similitud(codigo_analisis, codigo_entrenamiento)
                        self.resultados_similitud_original.append((archivo_analisis, archivo_entrenamiento, similitud_diff, similitud_jaccard, similitud_cosine, codigo_analisis, codigo_entrenamiento))

        self.resultados_similitud = self.resultados_similitud_original.copy()
        self.clusters = self.clustering(self.archivos_analisis + self.archivos_entrenamiento)
        self.actualizar_estado_analisis()
        self.mostrar_siguiente_similitud()


app = CodigoSimilaridadApp()
estado_analisis_label = tk.Label(app, text="Resultados de Similitud: 0")
estado_analisis_label.pack(pady=10)
mostrar_siguiente_button = tk.Button(app, text="Mostrar siguiente", command=app.mostrar_siguiente_similitud)
mostrar_siguiente_button.pack(pady=5)
app.mainloop()


