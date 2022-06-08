
# MANUAL DE INSTALAÇÃO E USO
## ARDUINO UNO E SENSOR TCRT5000

![IMG-LOGO-ARDUINO](./logo.png)

---

1. Com um Arduino Uno, conecte um fio no pino de 5v e outro em uma fileira da protoboard:

![IMG](./proto1.png)

2. Conecte da mesma maneira o fio ground, preferencialmente do lado oposto:


![IMG](./proto2.png)

3. Coloque o sensor na protoboard, aqui representado por dois leds, um azul e outro branco:


![IMG](./proto3.png)

4. Adicione dois resistores juntos ao na direção de uma das "pernas" do sensor:


![IMG](./proto4.png)

5. Conecte fios de energia nas duas "pernas" dos resistores que estão mais afastadas do sensor:


![IMG](./proto5.png)

6. Conecte dois fios pretos ground nas laterais dos sensores:


![IMG](./proto6.png)

7. Conecte o fio do sensor na porta 7 e no socket entre o sensor preto (no caso branco) e o resistor:


![IMG](./proto7.png)

---

## Segue demais imagens de fotos para melhor comprensão:

![IMG](./foto1.jpeg)

![IMG](./foto2.jpeg)

![IMG](./foto3.jpeg)

---

## Código e execução:

![IMG](./codigo4.jpeg)

Em seguida execute o código a seguir dentro da IDE do arduíno.

~~~c++
int pinoSensor = 7;

void setup() {

pinMode(pinoSensor, INPUT);
Serial.begin(9600);
}

void loop() {
if(digitalRead(pinoSensor) == LOW){
Serial.println("Objeto: Detectado");
}
else {
Serial.println("Objeto: Ausente");
}
delay(3000);
}
~~~

