#!/bin/bash
javac tiempos.java
java tiempos 1 > tiemposSyncro.txt
java tiempos 2 > tiemposLock.txt
java tiempos 3 > tiemposSem.txt
