# Diff Details

Date : 2023-06-11 23:26:46

Directory d:\\java_project\\java-learning-travel-demo\\middleware

Total : 42 files,  754 codes, 416 comments, 142 blanks, all 1312 lines

[Summary](results.md) / [Details](details.md) / [Diff Summary](diff.md) / Diff Details

## Files
| filename | language | code | comment | blank | total |
| :--- | :--- | ---: | ---: | ---: | ---: |
| [java-web/.mvn/wrapper/maven-wrapper.properties](/java-web/.mvn/wrapper/maven-wrapper.properties) | Java Properties | -2 | -16 | -1 | -19 |
| [java-web/mvnw.cmd](/java-web/mvnw.cmd) | Batch | -102 | -51 | -36 | -189 |
| [java-web/pom.xml](/java-web/pom.xml) | XML | -38 | 0 | -4 | -42 |
| [java-web/src/main/java/com/wendy/JavaWebApplication.java](/java-web/src/main/java/com/wendy/JavaWebApplication.java) | Java | -9 | 0 | -5 | -14 |
| [java-web/src/main/java/com/wendy/config/FilterConfig.java](/java-web/src/main/java/com/wendy/config/FilterConfig.java) | Java | -10 | -13 | -5 | -28 |
| [java-web/src/main/java/com/wendy/cookie/CookieSessionTest.java](/java-web/src/main/java/com/wendy/cookie/CookieSessionTest.java) | Java | -50 | -6 | -7 | -63 |
| [java-web/src/main/java/com/wendy/filter/FilterTest.java](/java-web/src/main/java/com/wendy/filter/FilterTest.java) | Java | -26 | -9 | -7 | -42 |
| [java-web/src/main/java/com/wendy/listener/ListenerTest.java](/java-web/src/main/java/com/wendy/listener/ListenerTest.java) | Java | -3 | -6 | -2 | -11 |
| [java-web/src/main/resources/application.properties](/java-web/src/main/resources/application.properties) | Java Properties | 0 | 0 | -2 | -2 |
| [java-web/src/test/java/com/wendy/javaweb/JavaWebApplicationTests.java](/java-web/src/test/java/com/wendy/javaweb/JavaWebApplicationTests.java) | Java | -9 | 0 | -5 | -14 |
| [middleware/.mvn/wrapper/maven-wrapper.properties](/middleware/.mvn/wrapper/maven-wrapper.properties) | Java Properties | 2 | 16 | 1 | 19 |
| [middleware/mvnw.cmd](/middleware/mvnw.cmd) | Batch | 102 | 51 | 36 | 189 |
| [middleware/pom.xml](/middleware/pom.xml) | XML | 120 | 25 | 19 | 164 |
| [middleware/src/main/java/com/wendy/MiddlewareApplication.java](/middleware/src/main/java/com/wendy/MiddlewareApplication.java) | Java | 9 | 0 | 5 | 14 |
| [middleware/src/main/java/com/wendy/elasticsearch/config/ElasticsearchClientConfig.java](/middleware/src/main/java/com/wendy/elasticsearch/config/ElasticsearchClientConfig.java) | Java | 16 | 12 | 3 | 31 |
| [middleware/src/main/java/com/wendy/elasticsearch/controller/ContentController.java](/middleware/src/main/java/com/wendy/elasticsearch/controller/ContentController.java) | Java | 25 | 6 | 6 | 37 |
| [middleware/src/main/java/com/wendy/elasticsearch/dao/CrawlerDao.java](/middleware/src/main/java/com/wendy/elasticsearch/dao/CrawlerDao.java) | Java | 31 | 13 | 6 | 50 |
| [middleware/src/main/java/com/wendy/elasticsearch/entity/Content.java](/middleware/src/main/java/com/wendy/elasticsearch/entity/Content.java) | Java | 8 | 6 | 5 | 19 |
| [middleware/src/main/java/com/wendy/elasticsearch/entity/User.java](/middleware/src/main/java/com/wendy/elasticsearch/entity/User.java) | Java | 11 | 6 | 4 | 21 |
| [middleware/src/main/java/com/wendy/elasticsearch/service/ContentService.java](/middleware/src/main/java/com/wendy/elasticsearch/service/ContentService.java) | Java | 61 | 16 | 7 | 84 |
| [middleware/src/main/java/com/wendy/elasticsearch/utils/ESUtils.java](/middleware/src/main/java/com/wendy/elasticsearch/utils/ESUtils.java) | Java | 7 | 6 | 4 | 17 |
| [middleware/src/main/java/com/wendy/elasticsearch/utils/JSONUtils.java](/middleware/src/main/java/com/wendy/elasticsearch/utils/JSONUtils.java) | Java | 9 | 6 | 4 | 19 |
| [middleware/src/main/java/com/wendy/rabbitmq/acknowledgement/Worker03.java](/middleware/src/main/java/com/wendy/rabbitmq/acknowledgement/Worker03.java) | Java | 25 | 12 | 4 | 41 |
| [middleware/src/main/java/com/wendy/rabbitmq/acknowledgement/Worker04.java](/middleware/src/main/java/com/wendy/rabbitmq/acknowledgement/Worker04.java) | Java | 25 | 12 | 4 | 41 |
| [middleware/src/main/java/com/wendy/rabbitmq/deadqueue/Consumer01.java](/middleware/src/main/java/com/wendy/rabbitmq/deadqueue/Consumer01.java) | Java | 33 | 13 | 9 | 55 |
| [middleware/src/main/java/com/wendy/rabbitmq/deadqueue/Consumer02.java](/middleware/src/main/java/com/wendy/rabbitmq/deadqueue/Consumer02.java) | Java | 23 | 6 | 5 | 34 |
| [middleware/src/main/java/com/wendy/rabbitmq/deadqueue/Producer.java](/middleware/src/main/java/com/wendy/rabbitmq/deadqueue/Producer.java) | Java | 21 | 8 | 3 | 32 |
| [middleware/src/main/java/com/wendy/rabbitmq/publishConfirm/PublishConfirm.java](/middleware/src/main/java/com/wendy/rabbitmq/publishConfirm/PublishConfirm.java) | Java | 89 | 39 | 8 | 136 |
| [middleware/src/main/java/com/wendy/rabbitmq/simple/Consumer.java](/middleware/src/main/java/com/wendy/rabbitmq/simple/Consumer.java) | Java | 22 | 15 | 7 | 44 |
| [middleware/src/main/java/com/wendy/rabbitmq/simple/Producer.java](/middleware/src/main/java/com/wendy/rabbitmq/simple/Producer.java) | Java | 20 | 24 | 6 | 50 |
| [middleware/src/main/java/com/wendy/rabbitmq/spring/config/RabbitmqConfig.java](/middleware/src/main/java/com/wendy/rabbitmq/spring/config/RabbitmqConfig.java) | Java | 35 | 12 | 8 | 55 |
| [middleware/src/main/java/com/wendy/rabbitmq/spring/consumer/RabbitmqHandler.java](/middleware/src/main/java/com/wendy/rabbitmq/spring/consumer/RabbitmqHandler.java) | Java | 17 | 8 | 4 | 29 |
| [middleware/src/main/java/com/wendy/rabbitmq/spring/controller/ProduceController.java](/middleware/src/main/java/com/wendy/rabbitmq/spring/controller/ProduceController.java) | Java | 20 | 12 | 7 | 39 |
| [middleware/src/main/java/com/wendy/rabbitmq/workqueue/Producer.java](/middleware/src/main/java/com/wendy/rabbitmq/workqueue/Producer.java) | Java | 17 | 7 | 4 | 28 |
| [middleware/src/main/java/com/wendy/rabbitmq/workqueue/RabbitMqUtils.java](/middleware/src/main/java/com/wendy/rabbitmq/workqueue/RabbitMqUtils.java) | Java | 14 | 9 | 3 | 26 |
| [middleware/src/main/java/com/wendy/rabbitmq/workqueue/Worker01.java](/middleware/src/main/java/com/wendy/rabbitmq/workqueue/Worker01.java) | Java | 21 | 6 | 8 | 35 |
| [middleware/src/main/java/com/wendy/redis/jedis/JedisDemo.java](/middleware/src/main/java/com/wendy/redis/jedis/JedisDemo.java) | Java | 23 | 6 | 5 | 34 |
| [middleware/src/main/java/com/wendy/redis/jedis/RedisConfig.java](/middleware/src/main/java/com/wendy/redis/jedis/RedisConfig.java) | Java | 18 | 78 | 3 | 99 |
| [middleware/src/main/resources/application.yml](/middleware/src/main/resources/application.yml) | YAML | 13 | 5 | 2 | 20 |
| [middleware/src/test/java/com/wendy/elasticsearch/CrawlerTest.java](/middleware/src/test/java/com/wendy/elasticsearch/CrawlerTest.java) | Java | 17 | 6 | 5 | 28 |
| [middleware/src/test/java/com/wendy/elasticsearch/ESApplicationoTest.java](/middleware/src/test/java/com/wendy/elasticsearch/ESApplicationoTest.java) | Java | 140 | 76 | 16 | 232 |
| [middleware/src/test/java/com/wendy/middleware/MiddlewareApplicationTests.java](/middleware/src/test/java/com/wendy/middleware/MiddlewareApplicationTests.java) | Java | 9 | 0 | 5 | 14 |

[Summary](results.md) / [Details](details.md) / [Diff Summary](diff.md) / Diff Details