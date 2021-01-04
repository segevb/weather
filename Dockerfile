FROM python:3
USER root
RUN mkdir /weather
EXPOSE 5000
RUN chmod -R 755 /weather
COPY * /weather/
RUN pip3 install -r /weather/requirements.txt
RUN pip3 install requests
WORKDIR "/weather"
ENV FLASK_APP=weather.py
ENTRYPOINT ["/usr/local/bin/flask", "run", "--host=0.0.0.0"]
