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

for city in eilat london; do
  sudo docker run $TAG -c $city
  check_result $city
done


exit 0
