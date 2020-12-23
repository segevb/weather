FROM python:3
USER root
RUN mkdir /intservice
RUN chmod -R 755 /intservice
RUN pip install requests
COPY *.py /intservice/
COPY configurations.json /intservice/
WORKDIR "/intservice"
ENTRYPOINT ["/usr/local/bin/python3", "/intservice/main.py"]

