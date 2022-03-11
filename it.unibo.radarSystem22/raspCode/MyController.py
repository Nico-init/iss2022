from MyLed import MyLed 
from MySonar import MySonar
import time
import json
import socket


led = MyLed()
sonar = MySonar()

config = json.load(open('config.json'))
DILIMT = config['DILIMT']
IP = config['ip']
PORT = config['port']

#i will reuse the same port for all send
sock = socket.socket(socket.AF_INET, # Internet
                         socket.SOCK_DGRAM) # UDP

while True:
    cm = sonar.getDistance()
    print ( cm, flush=True )
    
    MESSAGE = bytes(str(cm), 'UTF-8')
    sock.sendto(MESSAGE, (IP, PORT))

    if cm < DILIMT:
        led.turOn()
    else:
        led.turnOff()

    time.sleep(0.3)