import RPi.GPIO as GPIO
import time

class MySonar:

    def __init__(self):
        GPIO.setmode(GPIO.BCM)
        GPIO.setwarnings(False)
        self.TRIG = 17
        self.ECHO = 27

        GPIO.setup(self.TRIG,GPIO.OUT)
        GPIO.setup(self.ECHO,GPIO.IN)

        GPIO.output(self.TRIG, False)   #TRIG parte LOW
        #print ('Waiting a few seconds for the sensor to settle')
        time.sleep(2)

    def getDistance(self):
        GPIO.output(self.TRIG, True)    #invia impulsoTRIG
        time.sleep(0.00001)
        GPIO.output(self.TRIG, False)

        #attendi che ECHO parta e memorizza tempo
        while GPIO.input(self.ECHO)==0:
           pulse_start = time.time()

        # register the last timestamp at which the receiver detects the signal.
        while GPIO.input(self.ECHO)==1:
           pulse_end = time.time()

        pulse_duration = pulse_end - pulse_start
        distance = pulse_duration * 17165   #distance = vt/2
        distance = round(distance, 1)
        #print ('Distance:',distance,'cm')

        return distance