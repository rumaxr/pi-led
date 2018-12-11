FROM arm32v7/openjdk:jre-slim

RUN apt-get update && apt-get install -y \
    git-core \
    build-essential \
    gcc \
    python \
    python-dev \
    python-pip \
    python-virtualenv \
    sudo \
    --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

RUN git clone git://git.drogon.net/wiringPi
RUN cd wiringPi && ./build

ADD pi-led-assembly-0.1.jar /opt

ENV MAIN_CLASS com.maxr.BlinkInARowLoopApp

WORKDIR /opt
CMD java -cp pi-led-assembly-0.1.jar ${MAIN_CLASS}
