#!/bin/bash
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





# for sentiment in positive negative neutral; do
# sudo docker run intservice -w $sentiment | grep $sentiment
# check_result $sentiment
# done

# exit 0

if curl -s --head  --request GET https://community-open-weather-map.p.rapidapi.com/?rapidapi-key=fc03dcea31msh89ee8e25d5442c6p1f4633jsn5934736d9bb5 | grep "200 OK" > /dev/null; then
   echo "Server is UP"
else
   echo "Server is down"
fi

exit 0
