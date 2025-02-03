import matplotlib.pyplot as plt

# Definir las clases y sus relaciones
classes = {
    'Documento': {
        'attributes': ['- documentoId: int', '- nombre: String', '- archivo: String', '- fecha: Date'],
        'methods': ['+ getDocumentoId()', '+ setDocumentoId()', '+ getNombre()', '+ setNombre()', '+ getArchivo()', '+ setArchivo()', '+ getFecha()', '+ setFecha()']
    },
    'FragmentoDeCodigo': {
        'attributes': ['- fragmentoId: int', '- codigoFuente: String', '- documento: Documento', '- usuario: Usuario'],
        'methods': ['+ getFragmentoId()', '+ setFragmentoId()', '+ getCodigoFuente()', '+ setCodigoFuente()', '+ getDocumento()', '+ setDocumento()', '+ getUsuario()', '+ setUsuario()']
    },
    'Usuario': {
        'attributes': ['- usuarioId: int', '- nombre: String', '- apellido: String', '- edad: int'],
        'methods': ['+ getUsuarioId()', '+ setUsuarioId()', '+ getNombre()', '+ setNombre()', '+ getApellido()', '+ setApellido()', '+ getEdad()', '+ setEdad()']
    }
}

# Configurar el estilo de las cajas
class_box_style = dict(boxstyle='round,pad=0.4', facecolor='white', edgecolor='black')
attribute_box_style = dict(boxstyle='square,pad=0.3', facecolor='#ffffcc', edgecolor='black')
method_box_style = dict(boxstyle='square,pad=0.3', facecolor='#c2f0c2', edgecolor='black')

# Crear la figura y los ejes
fig, ax = plt.subplots()

# Configurar el tamaño del gráfico
fig.set_size_inches(10, 6)

# Configurar los límites del gráfico
ax.set_xlim(-0.5, 2.5)
ax.set_ylim(-0.5, 2.5)

# Configurar el tamaño de las flechas
arrow_args = dict(arrowstyle='->', color='black')

# Dibujar las clases y sus relaciones
for i, (class_name, class_data) in enumerate(classes.items()):
    # Dibujar la caja de la clase
    ax.text(i, 2, class_name, ha='center', va='center', bbox=class_box_style)
    
    # Dibujar los atributos de la clase
    attribute_text = '\n'.join(class_data['attributes'])
    ax.text(i, 1.5, attribute_text, ha='center', va='center', bbox=attribute_box_style)
    
    # Dibujar los métodos de la clase
    method_text = '\n'.join(class_data['methods'])
    ax.text(i, 0.5, method_text, ha='center', va='center', bbox=method_box_style)
    
    # Dibujar las relaciones
    if i < len(classes) - 1:
        ax.annotate('', xy=(i, 1.8), xytext=(i + 1, 1.8), arrowprops=arrow_args)
        ax.annotate('1', xy=(i + 0.5, 1.85), ha='center', va='center')

# Ocultar los ejes
ax.axis('off')

# Mostrar el gráfico
plt.show()
