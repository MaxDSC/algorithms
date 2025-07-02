### Данный проект предназначен для проверки и самостоятельного изучения кода, представленного в книге "Алгоритмы на Java" авторов Роберта Седжвика и Кевина Уэйна.

## Создание проекта
Java версия: `openjdk version "21.0.7" 2025-04-15`.\
Maven версия: `Apache Maven 3.8.7`.
1. Создал пустой проект
```
mvn archetype:generate -DgroupId=com.maxdsc -DartifactId=algorithms -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
- Добавил maven.compiler для новых версий java:
```
<properties>
    <maven.compiler.release>11</maven.compiler.release>
</properties>
```
- Добавил плагин `maven-compiler-plugin` в build:
```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
        </plugin>
    </plugins>
</build>
```

- Добавил плагин `maven-assembly-plugin` для сборки JAR вместе с зависимостями:
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-assembly-plugin</artifactId>
    <version>3.7.1</version>
    <configuration>
        <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
        <archive>
            <manifest>
                <mainClass>com.maxdsc.BinarySearch</mainClass>
            </manifest>
        </archive>
    </configuration>
    <executions>
        <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
                <goal>single</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

- Добавил плагин spotless для форматирования кода по стилю Google командами `mvn spotless:check` и `mvn spotless:apply`:
```
<plugin>
    <groupId>com.diffplug.spotless</groupId>
    <artifactId>spotless-maven-plugin</artifactId>
    <version>2.44.4</version>
    <configuration>
        <java>
            <googleJavaFormat>
                <version>1.27.0</version>
                <style>GOOGLE</style>
                <reflowLongStrings>true</reflowLongStrings>
                <formatJavadoc>true</formatJavadoc>
            </googleJavaFormat>
        </java>
    </configuration>
</plugin>
```

2. Подключил библиотеку согласно [инструкции](https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html)

Авторы создали собственную библиотеку, которая используется на протяжении всей книги, ее название ["algs4"](https://github.com/kevin-wayne/algs4). Также у книги есть [сайт](http://algs4.cs.princeton.edu/code/), на котором можно посмотреть весь код книги, взять файлы для тестов.
Для подключения библиотеки необходимо скачать проект с GitHub, импортировать его как maven-проект, создать jar-архив от этого проекта командой `mvn package`, этот архив будет подключаться к проектам.

- Проект авторов в pom.xml имеет следующие характеристики, необходимые для подключения зависимости:
```
<groupId>edu.princeton.cs</groupId>
<artifactId>algs4</artifactId>
<version>1.0.0.0</version>
```

- Создал локальный репозиторий maven
```
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=<path-to-file>
```
- Добавил зависимость в pom.xml:
```
<dependencies>
    <dependency>
        <groupId>edu.princeton.cs</groupId>
            <artifactId>algs4</artifactId>
            <version>1.0.0.0</version>
    </dependency>
</dependencies>
```

## Запуск проекта

- В книге часто упоминается запуск программы через перенаправление ввода, например, `java BinarySearch tinyW.txt < tinyT.txt`, где из файла `tinyW.txt` берется массив данных, а из файла `tinyT.txt` в программу поступают вводимые данные.

- Для запуска подобных команд в IDE Eclipse можно воспользоваться Run Configuration, указав в Arguments путь до файла `tinyW.txt`, а в Common->InputFiles путь до `tinyT.txt`.

- Для запуска программы с консоли необходимо указывать -classpath до target/classes папки с проектом библиотеки авторов, указать  target/classes собственного проекта и главный класс.
```
java -cp <Путь до библиотеки>/target/classes:target/classes com.<>.<Главный класс>  tinyW.txt < tinyT.txt
```

- Для запуска JAR файла, в котором нет манифеста с указанием главного класса и включения зависимостей:
```
java -cp <Путь до библиотеки>/target/classes:target/<JAR-файл> com.<>.<Главный класс>  tinyW.txt < tinyT.txt
```

- Если применялась команда `mvn package` с плагином `maven-assembly-plugin`, то команда для запуска будет такая:\ 
`java -jar target/<name>-jar-with-dependencies.jar tinyW.txt < tinyT.txt`, при этом нужно обратить внимание на MainClass при настройке плагина.

- Запустить упражнение можно с помощью Makefile. Для этого есть несколько команд: 
    - `make ex c= e= a=` - компилирует и сразу запускает, где `c`-номер главый (например, глава 1.1 - это `c=1_1`), `e` - номер упражнения в главе (например, упражнение 1.1.24 - это `e=24`), `a` - аргумент команды (если несколько аргументов, то писать в двойных ковычках, если аргументов нет, то `a` можно не писать).
    - `make run c= e= a=` - только запускает программу, если есть скомпилированные файлы.
