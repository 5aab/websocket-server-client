D:

rmdir /S /Q D:\tmp

set BASE_KAFKA_PATH=D:\softwares\kafka\kafka_2.13-2.8.1

cd %BASE_KAFKA_PATH%\bin\windows

@REM path=C:\Windows\System32


set ZOOKEEPER_PROPS=%BASE_KAFKA_PATH%\config\zookeeper.properties
set NODE0_PROPS=%BASE_KAFKA_PATH%\config\server-0.properties
set NODE1_PROPS=%BASE_KAFKA_PATH%\config\server-1.properties
set NODE2_PROPS=%BASE_KAFKA_PATH%\config\server-2.properties
set NODE3_PROPS=%BASE_KAFKA_PATH%\config\server-3.properties

start "Zookeeper" zookeeper-server-start %ZOOKEEPER_PROPS% 

timeout /t 30

start "kafka-node0" kafka-server-start %NODE0_PROPS%

timeout /t 20

start "kafka-node1" kafka-server-start %NODE1_PROPS%

timeout /t 20

start "kafka-node2" kafka-server-start %NODE2_PROPS%

timeout /t 20

start "kafka-node3" kafka-server-start %NODE3_PROPS%

timeout /t 10000