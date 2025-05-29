# Calculadora de descuentos para empleados en cafetería
print("###########################################")
print("### Sistema de gestion de caferia INAOE ###")
print("###########################################")

while True:
    # Validamos que e
    try:
        # Solicitamos el monto de consumo
        # El programa se sigue ejecutando mientras no se ingrese 'X'
        
        entrada_consumo = input("Ingrese el monto total de consumo ('X' para salir): $")
        if entrada_consumo.upper() == 'X':
            print("\nCerrando el programa...")
            print("El programa finalizo")
            break
        
        consumo_total = float(entrada_consumo)
        
        # Solicitar departamento del cliente
        departamento = input("Ingrese el departamento (A, B, C) o 'X' para salir: ").upper()
        if departamento == 'X':
            print("\nCerrando el programa...")
            print("El programa finalizo")
            break
        
        # Validar departamento
        if departamento not in ['A', 'B', 'C']:
            print("\nError: Departamento no válido. Favor de volver a intentarlo.\n")
            continue 
        
        # Calcular descuento
        descuento = 0.0
        
        if departamento == 'A':
            descuento = 0.25 
        elif departamento == 'B':
            descuento = 0.20
        elif departamento == 'C' and consumo_total > 150:
            descuento = 0.12  # 12% solo si > $150
        
        # Calculamos el total aplicando el descuento
        monto_descontado = consumo_total * descuento
        total_a_pagar = consumo_total - monto_descontado
        
        # Mostrar recibo
        print("\n----- RECIBO -----\n")
        print(f"Consumo total: ${consumo_total:.2f}")
        print(f"Departamento: {departamento}")
        print(f"Descuento aplicado: {descuento*100:.0f}%")
        print(f"Monto descontado: ${monto_descontado:.2f}")
        print(f"Total a pagar: ${total_a_pagar:.2f}\n")
        print("-------------------\n")
        
    except ValueError:
        print("\nError: No se ingreso un valor valido\n")