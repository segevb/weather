from flask import Flask
from flask import request
import json
import send

app = Flask(__name__)

def load_config():
    with open('./configurations.json') as json_file:
        configs = json.load(json_file)
        key = configs['configurations']['key']
        host = configs['configurations']['host']
        return key, host

@app.route('/', methods=['POST'])


def main():
    data = request.get_json() or {}
    city = data['city']
    key = load_config()[0]
    host = load_config()[1]
    response = send.send(host, key, city)

    # this can be used to custom construct json response
    # data = {}
    # data['key'] = 'value'
    # json_data = json.dumps(data)

    temp_result = response["main"]["temp"]
    string_temp_result = str(temp_result)
    city_temp_print = ("The temperature in " + city + " is: " + string_temp_result + " C")

    print(city_temp_print)

    return city_temp_print
