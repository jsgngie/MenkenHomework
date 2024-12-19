___________________________________

*Käivitamiseks läheb vaja Java 22-te*

user> java -jar trials.jar
____________________________________

Rakendus on saadaval port 8080-l,

http://localhost:8080/
____________________________________

Endpoindid:

http://localhost:8080/api/documents/all

tagastab kõik dokumendid, mis on leitavad andmebaasis järjestatud kasvavalt weight-i järgi.

http://localhost:8080/api/documents/add

võtab vastu json formaadis dokumendid, lisab need andmebaasi.

e.g {'Curriculum Vitae': 0.03.....}
_____________________________________

Muu:

Andmebaasi näeb lihtsalt:

http://localhost:8080/h2-console/

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:db
User Name: sa
Password: -

