FROM python:3.12

RUN apt-get update && apt-get -y install curl gnupg unixodbc unixodbc-dev

RUN curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add -
RUN curl https://packages.microsoft.com/config/debian/10/prod.list > /etc/apt/sources.list.d/mssql-release.list
RUN apt-get update && ACCEPT_EULA=Y apt-get install -y msodbcsql17

WORKDIR /usr/src/app

COPY requirements.txt /usr/src/app/

RUN pip install --no-cache-dir -r requirements.txt

COPY . /usr/src/app

EXPOSE 8000

RUN chmod +x /usr/src/app/app.sh

ENTRYPOINT ["/usr/src/app/app.sh"]

CMD []