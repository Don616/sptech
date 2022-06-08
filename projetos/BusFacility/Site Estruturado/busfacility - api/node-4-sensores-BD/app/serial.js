const sensors = require('./sensors');
const SerialPort = require('serialport');
const Readline = SerialPort.parsers.Readline;


class ArduinoDataRead {

    constructor(){
        this.listData = [];
		this.__listDataTemp = [];
        this.listDataSwitch = [];
        this.listDataLux = [];
    }

    get List() {
        return this.listData;
    }
    get ListTemp() {
        return this.__listDataTemp;
    }
    get ListSwitch() {
        return this.listDataSwitch;
    }
    get ListLux() {
        return this.listDataLux;
    }
	
    /**
     * Neste bloco realizamos a geração de dados aleatórios. Repare que chamamos a função dht11
     * Esta função criamos lá no arquivo sensors.js.
     * Os parâmetros utilizados de umidade e temperatura são descritos entre () => 
     * sensors.dht11({minHum,maxHum,minTemp,maxTemp})
     */
    fake_data(){
        setInterval(() => {
            let data_float = sensors.dht11({minHum:50, maxHum:100, minTemp:0, maxTemp:15});
            let data_int = sensors.pessoas();
            let data_lux = sensors.ldr();

            if (this.__listDataTemp.length === 59) {
                let sum = this.__listDataTemp.reduce((a, b) =>  a + b, 0);
                while(this.__listDataTemp.length > 0) {
                    this.__listDataTemp.pop();
                }
            }
            console.log('temp: ', parseFloat(data_float[1].toFixed(2)), 'hum: ', data_float[0],'chave: ',data_int,'lux: ',parseFloat(data_lux.toFixed(2)));
            this.__listDataTemp.push(data_float[1]);
            this.listData.push(data_float[0]);
            this.listDataSwitch.push(data_int);
            this.listDataLux.push(data_lux);

        }, 2000);
    }
    /**
     * Neste bloco testamos a conexão. Caso exista um arduino ele busca as informações do arduino
     * Caso não ele chama a função fake_data() para gerar os dados simulados.
     * A partir da linha 69 o código busca um dado do arduino e separa ele na divisão do ;
     */
    SetConnection() {
        SerialPort.list().then(listSerialDevices => {

            let listArduinoSerial = listSerialDevices.filter(serialDevice => {
                return serialDevice.vendorId == 2341 && serialDevice.productId == 43;
            });

            if (listArduinoSerial.length != 1) {
                this.fake_data();
                throw new Error("Arduino not found - Generating data")
            }else{
                console.log("Arduino found in the com %s", listArduinoSerial[0].comName);
                return listArduinoSerial[0].comName;
            }
        }).then(arduinoCom => {
            
            let arduino = new SerialPort(arduinoCom, {baudRate: 9600});
            
            const parser = new Readline();
            arduino.pipe(parser);
            
            /**
             * Para esse bloco de informação que vem do arduino funcionar a estrutura do dado que chega deve ser
             * 
             * umidade;temperatura;chave;lux 
             * 
             * Para que a api do NODE consiga receber os valores e separá-los por ';'
             * 
             * No código do arduino (C++) ficaria da seguinte forma o trecho final do código
             * 
             * ...
             * Serial.print(umidade);
             * Serial.print(";");
             * Serial.print(temperatura);
             * Serial.print(";");
             * Serial.print(chave);
             * Serial.print(";");
             * Serial.prinln(lux);
             * ...
             * 
             * Para utilizar apenas um sensor que traga 1 medida pode-se adaptar o código do node-lm35 para
             * se conectar ao banco e aí então enviar os dados;
             */

            parser.on('data', (data) => {
				let value = data.toString().split(';');
				//console.log(value);
                
                        
				let humidity = parseFloat(value[0].replace('\r',''));
                let temperature = parseFloat(value[1].replace('\r',''));
                let chave = parseFloat(value[2].replace('\r',''));
                let luz = parseFloat(value[3].replace('\r',''));

                this.listData.push(humidity);
                this.__listDataTemp.push(temperature);
                this.ListSwitch.push(chave);
                this.ListLux.push(luz)

                console.log("Temp: ",temperature," Umidade: ",humidity, 'Chave: ',chave,'Lux: ',luz);
            
            });
            
        }).catch(error => console.log(error));
    }
}

const serial = new ArduinoDataRead();
serial.SetConnection();

module.exports.ArduinoData = {List: serial.List, 
                              ListTemp: serial.ListTemp,
                              ListSwitch: serial.ListSwitch,
                              ListLux: serial.ListLux} 