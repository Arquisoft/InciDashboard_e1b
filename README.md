# InciDashboard_e1b
[![Build Status](https://travis-ci.org/Arquisoft/InciDashboard_e1b.svg?branch=master)](https://travis-ci.org/Arquisoft/InciDashboard_e1b)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/6308efdd6cbf43fcb00b4f1f8b3e83f3)](https://app.codacy.com/app/mariodod/InciDashboard_e1b/dashboard)
[![codecov](https://codecov.io/gh/Arquisoft/InciDashboard_e1b/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciDashboard_e1b)

InciDashboard e1b


# Authors(2017-2018)
- Mario Del Olmo Diaz (UO251090)
- Daniel Fuego San Francisco (UO251185)
- Sergio Fernández Fernández (UO251408)
- Pablo Baragaño Coto (UO251759)
- Sergio Rodríguez Artime (UO248043)

# Instalación y ejecución de Apache Kafka:
Vamos a la página web de apache kafka, en el enlace a la descarga escogemos el primer mirror. Una vez descargado descomprimimos el archivo una vez y dentro de este aparecerá otro archivo que volvemos a descomprimir.
Abrimos la ventana de comandos:
- Nos desplazamos hasta la carpeta donde se encuentra kafka_2.11-1.0.1
- Ejecutamos bin\windows\zookeeper-server-start.bat config\zookeeper.properties
- Ejecutamos bin\windows\kafka-server-start.bat config\server.properties

Si da error borramos la carpeta c temp kafka logs

# Ejecución:	

- Descargamos la base de datos hsql para ser utilizada de forma local por la aplicación:
https://unioviedo-my.sharepoint.com/personal/uo251185_uniovi_es/Documents/Forms/All.aspx?slrid=d988579e-b0a2-5000-312a-2971a7ce39b5&RootFolder=%2Fpersonal%2Fuo251185_uniovi_es%2FDocuments%2FASW&FolderCTID=0x01200077E19CF79DD8C34CB7A7D8B5C7A34602
(Descargar y descomprimir el fichero hsqldb-2.4.0.zip)

- Lanzamos la base de datos hsqldb que acabamos de descargar

- Abrimos una linea de comandos dentro de la carpeta del proyecto y escribimos mvn spring-boot:run
