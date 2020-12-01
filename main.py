import json
import send
import argparse


def load_config():
    with open('/intservice/configurations.json') as json_file:
        configs = json.load(json_file)
        key = configs['configurations']['key']
        host = configs['configurations']['host']
        return key, host


def main():  # Main function
    parser = argparse.ArgumentParser()
    parser.add_argument('-c', '--city', action='store', dest='city', help='Weather temperature for city', required=True)
    args = parser.parse_args()  # contain all arguments
    city = args.city  # save city from all arguments

    key = load_config()[1]  # calls the func in order to use it
    host = load_config()[0]

    response = send.send(key, host, city)
    print(response)

main()
