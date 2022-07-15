# Modul223
<h4>Beschreibung: </h4>
Die Mutli-User Applikation ermöglicht es verschiedene User, wie Passagiere und Admins, Daten von Flughäfen einzulesen und zu verwalten.

<h4>Ausführen des Programms:</h4>
Das Programm wurde mit dem Framework Spring Boot in Java umgesetzt und benötigt demensprechend eine Installation in deiner IDE. Bei der <code>pom.xml</code> datei sollte man Doppelcklicken und unter maven die Datei updaten, sodass die Dependencies (Libaries von Spring) geladen werden. In deiner beliebigen IDE, wo Java und Spring Boot installiert sind, kann man nach dem ausführen von Run (Auswählen: As Spring DevoTools Client) das Projekt compilieren lassen. Die index.html Seite sollte dann unter <code>localhost:8080</code> im Browser aufrufbar sein. 

## API Reference

### FlughafenRestController

#### Get Flughafenlist

```http
  GET /api/v3/flughafen
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `List<FlughafenDto>` | returns JSON of Flughafenlist|

#### Add new Flughafen

```http
  POST /api/v3/flughafen
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `FlughafenInputDto` | Name of Flughafen |


#### Delete Flughafen

```http
  DELETE /api/v3/flughafen/ID  
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `void` | Put the ID number in the URL |
