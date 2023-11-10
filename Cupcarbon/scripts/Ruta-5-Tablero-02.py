#informa el estado de la luz ambiental y si la 
#luminaria encendio o no

import time
import random
topic = "ruta-5/"


def enviar():
    carga_payload = topic +"tablero_02: "+"Luz ambiental: "+str(ldr_value)+";"+ "Estado: "+ evento + ";"+"Funcionamiento: " + funcionamiento
    node.publish(topic,carga_payload)

while node.loop():
    ldr_value = random.randint(0, 1023)
    estado_luminaria = random.randint(0, 1)
    if ldr_value > 500 and estado_luminaria == 0:
        evento = "Apagada"
        funcionamiento = "Normal"
        enviar()
    if ldr_value > 500 and estado_luminaria == 1:
        evento = "Encendida"
    	funcionamiento = "FALLO"
        enviar()
    if ldr_value < 500 and estado_luminaria == 0:
        evento = "Apagada"
        funcionamiento = "FALLO"
        enviar()
    if ldr_value < 500 and estado_luminaria == 1:
        evento = "Encendida"
    	funcionamiento = "Normal"
        enviar()
    time.sleep(10)