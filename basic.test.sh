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

containerName=$(echo $TAG | cut -d'-' -f2)

sudo docker run -d -p 5000:5000 --name $containerName $TAG

# Test if received right output

for city in eilat london; do
  sudo  curl -s -X POST --header "Content-Type: application/json" --data '{"city":"'$city'"}' http://localhost:5000 | grep $city
  check_result $city
done


exit 0
