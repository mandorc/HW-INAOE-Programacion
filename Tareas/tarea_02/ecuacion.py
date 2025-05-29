import math

print("Resolvedor de ecuaciones cuadráticas")
print("Para la ecuación ax² + bx + c = 0")
print("Ingrese 'q' en cualquier momento para salir")

while True:
    try:
        # Pedir coeficiente a
        entrada = input("\nIngrese el coeficiente a ('q' para salir): ")
        if entrada.lower() == 'q':
            break
        a = float(entrada)
        
        if a == 0:
            print("Error: 'a' no puede ser cero en una ecuación cuadrática")
            continue

        # Pedir coeficiente b
        entrada = input("Ingrese el coeficiente b (o 'q' para salir): ")
        if entrada.lower() == 'q':
            break
        b = float(entrada)

        # Pedir coeficiente c
        entrada = input("Ingrese el coeficiente c (o 'q' para salir): ")
        if entrada.lower() == 'q':
            break
        c = float(entrada)

        # Calcular el discriminante
        discriminante = b**2 - 4*a*c

        # Caso 1: Dos raíces reales distintas
        if discriminante > 0:
            raiz_discriminante = math.sqrt(discriminante)
            x1 = (-b + raiz_discriminante) / (2*a)
            x2 = (-b - raiz_discriminante) / (2*a)
            print("\nResultados:")
            print(f"Tiene dos raíces reales distintas:")
            print(f"x1 = {x1:.4f}")
            print(f"x2 = {x2:.4f}")

        # Caso 2: Una raíz real (doble)
        elif discriminante == 0:
            x = -b / (2*a)
            print("\nResultados:")
            print(f"Tiene una raíz real doble:")
            print(f"x = {x:.4f}")

        # Caso 3: Raíces complejas
        else:
            parte_real = -b / (2*a)
            parte_imaginaria = math.sqrt(-discriminante) / (2*a)
            print("\nResultados:")
            print(f"Tiene dos raíces complejas conjugadas:")
            print(f"x1 = {parte_real:.4f} + {parte_imaginaria:.4f}i")
            print(f"x2 = {parte_real:.4f} - {parte_imaginaria:.4f}i")

    except ValueError:
        print("Error: Debe ingresar valores numéricos válidos o 'q' para salir")
    except:
        print("Ocurrió un error inesperado")

print("\nEl programa ha finalizado.")