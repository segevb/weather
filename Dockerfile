FROM python:3
USER root
RUN mkdir /intservice
RUN chmod -R 755 /intservice
COPY *.py /intservice/
COPY configurations.json /intservice/
CMD ["/bin/sh"]