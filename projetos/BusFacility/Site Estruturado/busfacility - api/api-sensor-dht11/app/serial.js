const sensors = require('./sensors');
const SerialPort = require('serialport');
const Readline = SerialPort.parsers.Readline;

class ArduinoDataRead {

    constructor(){
        this.listDataEntrou = [];
		this.listDataSaiu = [];
    }

    get ListEntrou() {
        return this.listDataEntrou;
    }
    get ListSaiu() {
        return this.listDataSaiu;
    }
	
    fake_data(){
        setInterval(() => {
            let data_float = sensors.tcrt5000({minHum:1, max:20});

            if (this.listDataSaiu.length === 59) {
                let sum = this.listDataSaiu.reduce((a, b) =>  a + b, 0);
                while(this.listDataSaiu.length > 0) {
                    this.listDataSaiu.pop();
                }
            }
             
            console.log('Entrou: ', parseFloat(data_float[0].toFixed(0)), 'Saiu:', parseFloat(data_float[1].toFixed(0)));
            this.listDataSaiu.push(data_float[1]);
            this.listDataEntrou.push(data_float[0]);

        }, 2000);
    }

    SetConnection() {
        SerialPort.list().then(listSerialDevices => {
            let listArduinoSerial = listSerialDevices.filter(serialDevice => {
                return serialDevice.vendorId == 2341 && serialDevice.productId == 43;
            });

            if (listArduinoSerial.length != 1) {
                this.fake_data();
                throw new Error("Arduino not found - Generating data")
            } else {
                console.log("Arduino found in the com %s", listArduinoSerial[0].comName);
                return listArduinoSerial[0].comName;
            }
        }).then(arduinoCom => {
            
            let arduino = new SerialPort(arduinoCom, {baudRate: 9600});
            
            const parser = new Readline();
            arduino.pipe(parser);
            
            parser.on('data', (data) => {
				let value = data.toString().split(';');
				// let temperature = parseFloat(value[1].replace('\r', ''));
				let humidity = parseFloat(value[0].replace('\r', ''));

                this.listDataEntrou.push(humidity);
                // this.__listDataTemp.push(temperature)

                // "Temp: ",temperature,
                
                if (humidity == 1) {
                    console.log(" Entrada: ", Number(Math.random() * 15 + 1).toFixed(0));
                } else {
                    console.log(" Saida: ",  (Math.random() * 5 - 10).toFixed(0));
                }
            });
            
        }).catch(error => console.log(error));
    }
}

const serial = new ArduinoDataRead();
serial.SetConnection();

// List: serial.List,
module.exports.ArduinoData = { ListEntrou: serial.ListEntrou,
                               ListSaiu: serial.ListSaiu} 