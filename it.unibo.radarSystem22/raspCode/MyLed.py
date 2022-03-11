import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setup(25,GPIO.OUT)

class MyLed:
    def turOn(self):
        GPIO.output(25,GPIO.HIGH)
    
    def turnOff(self):
        GPIO.output(25,GPIO.LOW)