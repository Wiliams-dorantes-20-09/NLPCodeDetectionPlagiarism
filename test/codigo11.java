public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Hola, Mundo!");
    }
}
```

2. Suma de dos números:
```java
public class Suma {
    public static void main(String[] args) {
        int numero1 = 5;
        int numero2 = 7;
        int suma = numero1 + numero2;
        System.out.println("La suma es: " + suma);
    }
}
```

3. Factorial de un número:
```java
public class Factorial {
    public static void main(String[] args) {
        int numero = 5;
        int factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
}
```

4. Bucle while:
```java
public class BucleWhile {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }
}
```

5. Bucle for-each:
```java
public class BucleForEach {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
```

6. Uso de if-else:
```java
public class IfElse {
    public static void main(String[] args) {
        int numero = 10;
        if (numero > 5) {
            System.out.println("El número es mayor que 5");
        } else {
            System.out.println("El número es menor o igual a 5");
        }
    }
}
```

7. Clase y objeto:
```java
public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 30);
        persona1.saludar();
    }
}
```

8. Uso de ArrayList:
```java
import java.util.ArrayList;

public class ArrayListEjemplo {
    public static void main(String[] args) {
        ArrayList<String> listaNombres = new ArrayList<>();
        listaNombres.add("Ana");
        listaNombres.add("Carlos");
        listaNombres.add("Elena");

        for (String nombre : listaNombres) {
            System.out.println(nombre);
        }
    }
}
```

9. Clase abstracta e interfaz:
```java
abstract class Animal {
    abstract void hacerSonido();
}

interface Nadador {
    void nadar();
}

class Perro extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("El perro hace woof");
    }
}

class Pato extends Animal implements Nadador {
    @Override
    void hacerSonido() {
        System.out.println("El pato hace cuac");
    }

    @Override
    public void nadar() {
        System.out.println("El pato nada en el agua");
    }
}

public class ClaseAbstractaEInterfaz {
    public static void main(String[] args) {
        Animal perro = new Perro();
        perro.hacerSonido();

        Animal pato = new Pato();
        pato.hacerSonido();
        ((Pato) pato).nadar();
    }
}
```

10. Uso de try-catch:
```java
public class Excepciones {
    public static void main(String[] args) {
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero");
        }
    }
}
```

11. Herencia:
```java
class Vehiculo {
    void arrancar() {
        System.out.println("El vehículo arranca");
    }
}

class Coche extends Vehiculo {
    void frenar() {
        System.out.println("El coche frena");
    }
}

public class Herencia {
    public static void main(String[] args) {
        Coche miCoche = new Coche();
        miCoche.arrancar();
        miCoche.frenar();
    }
}
```

12. Uso de Enum:
```java
enum DiaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
}

public class EnumEjemplo {
    public static void main(String[] args) {
        DiaSemana dia = DiaSemana.MIERCOLES;
        System.out.println("Hoy es " + dia);
    }
}
```

13. Uso de StringBuilder:
```java
public class StringBuilderEjemplo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hola");
        sb.append(" ");
        sb.append("Mundo");
        String mensaje = sb.toString();
        System.out.println(mensaje);
    }
}
```

14. Manejo de archivos:
```java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManejoArchivos {
    public static void main(String[] args) {
        try {
            File archivo = new File("archivo.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("Hola, Mundo!");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }
    }
}
```

15. Uso de HashMap:
```java
import java.util.HashMap;

public class HashMapEjemplo {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Uno", 1);
        mapa.put("Dos", 2);
        mapa.put("Tres", 3);

        System.out.println("El valor asociado a 'Dos' es: " + mapa.get("Dos"));
    }
}
```

16. Uso de recursión:
```java
public class Recursion {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int resultado = factorial(5);
        System.out.println("El factorial de 5 es: " + resultado);
    }
}
```

17. Uso de interfaces funcionales:
```java
@FunctionalInterface
interface OperacionMatematica {
    int operar(int a, int b);
}

public class InterfacesFuncionales {
    public static void main(String[] args) {
        OperacionMatematica suma = (a, b) -> a

 + b;
        System.out.println("La suma de 3 y 5 es: " + suma.operar(3, 5));
    }
}
```

18. Uso de expresiones regulares:
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {
    public static void main(String[] args) {
        String texto = "El número de teléfono es 123-456-7890";
        String patron = "\\d{3}-\\d{3}-\\d{4}";

        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        if (matcher.find()) {
            System.out.println("Número de teléfono encontrado: " + matcher.group());
        } else {
            System.out.println("Número de teléfono no encontrado");
        }
    }
}
```

19. Uso de Threads:
```java
public class Hilos {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hilo 1: " + i);
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hilo 2: " + i);
            }
        });

        hilo1.start();
        hilo2.start();
    }
}
```

20. Uso de JUnit (pruebas unitarias):
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebasJUnit {
    @Test
    void testSuma() {
        int resultado = 2 + 2;
        assertEquals(4, resultado);
    }
}
```

Estos son solo algunos ejemplos de código Java. Java es un lenguaje versátil con muchas aplicaciones diferentes, por lo que hay muchas más posibilidades y proyectos que puedes explorar. ¡Espero que estos ejemplos te sean útiles!