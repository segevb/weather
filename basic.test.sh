#!/bin/bash
TAG=$1
check_result () {
  RESULT=$?
  MESSAGE=$1
  if [ $RESULT == 0 ]; then
    echo [SUCCESS] $MESSAGE
  else
    echo [FAIL] $MESSAGE
    exit 1
  fi
}

# Test if received right output
list=["eilat" "london" "rehovot"]
for city in "${list[@]}"; do
  sudo docker run weather:$TAG -c city
  check_result city
done


# Test if site is UP/DOWN
if curl -s --head  --request GET https://community-open-weather-map.p.rapidapi.com/?rapidapi-key=fc03dcea31msh89ee8e25d5442c6p1f4633jsn5934736d9bb5 | grep "200 OK" > /dev/null; then
   echo "Server is UP"
else
   echo "Server is down"
fi

exit 0
