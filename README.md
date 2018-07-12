# kafka-examples

# To create new kafka container - Docker for mac, linux and windows 10
- docker run --rm -it -p 2181:2181 -p 3030:3030 -p 8081:8081 -p 8082:8082 -p 8083:8083 -p 9092:9092 -e ADV_HOST=127.0.0.1 landoop/fast-data-dev

# Docker Toolbox
- docker run --rm -it -p 2181:2181 -p 3030:3030 -p 8081:8081 -p 8082:8082 -p 8083:8083 -p 9092:9092 -e ADV_HOST=192.168.99.100 landoop/fast-data-dev

# To start a kafka container that is already created and stopped
- docker start -i <container id/name>

# To stop a kafka container that is already created and running
- docker stop -i <container id/name>

# To login into docker container for Kafka command line tools.
- docker run --rm -it --net=host landoop/fast-data-dev bash			

# Connecting/login into kafka docker container
- docker exec -it <container id/ name> sh or /bin/bash

# Kafka-Topic creation command
- kafka-topics --zookeeper 127.0.0.1:2181 --create --topic vasanth_topic --partitions 3 --replication-factor 1

# To list all topics
- kafka-topics --zookeeper 127.0.0.1:2181 --list

# To delete a topic
- kafka-topics --zookeeper 127.0.0.1:2181 --delete --topic vasanth_topic

# To describe a topic
- kafka-topics --zookeeper 127.0.0.1:2181 --describe --topic vasanth_topic

# To Consume a topic from beginning
- kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --from-beginning --topic vasanth_topic

# To Consume a topic from beginning and from specific partition
- kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --from-beginning --topic vasanth_topic --partition 0
- kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --from-beginning --topic vasanth_topic --partition 1
- kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --from-beginning --topic vasanth_topic --partition 2

# To Consume a topic from tail
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic vasanth_topic

# To Consume a topic from beginning and specified consumer group id(incase of group id, it commits the offsets) and if we run again it reads data from where it commits offsets.
- kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --from-beginning --topic vasanth_topic --consumer-property group.id=mygroup1 --from-beginning

# To produce data into an existing topic
- kafka-console-producer --broker-list 127.0.0.1:9092 --topic vasanth_topic

# To produce data into a topic that doesn't exist
- kafka-console-producer --broker-list 127.0.0.1:9092 --topic new_topic

# To configure a topic for clean up policy
-  kafka-topics --create --topic test_cleanup --zookeeper 127.0.0.1:2181 --config cleanup.policy=compact --partitions 3 --replication-factor 1

# To alter a topic's configuration
- kafka-topics --alter --topic test_cleanup --zookeeper 127.0.0.1:2181 --config cleanup.policy=delete  (this is deprecated)
- kafka-configs --add-config cleanup.policy=compact --alter --entity-type topics --entity-name test_cleanup --zookeeper 127.0.0.1:2181

