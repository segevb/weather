import requests  # import to requests http library


def send(key, host, city):
    url = "https://community-open-weather-map.p.rapidapi.com/weather"  # open weather url endpoint

    while city != "q":
        querystring = {"q": city, "units": "metric"}  # my query
        headers = {
            'x-rapidapi-host': key,
            'x-rapidapi-key': host
        }
        response = requests.request("GET", url, headers=headers, params=querystring)
        if response.status_code != 200:
            print("city not found")
            exit()

    response = response.json()
    print(response["main"]["temp"])
    results.city = input("Enter city: (Press q to quit) ")
