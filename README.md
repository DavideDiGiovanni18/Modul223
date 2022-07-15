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
| `name`      | `FlughafenInputDto` | Insert Name of Flughafen as JSON|


#### Delete Flughafen

```http
  DELETE /api/v3/flughafen/ID  
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `void` | Put the ID number of a flughafen in the URL |


### LandRestController

#### Get Länderliste

```http
  GET /api/v2/laender
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `List<LandDto>` | returns JSON of Länderlist|

#### Get Land

```http
  GET /api/v2/laender/ID
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `LandDto` | returns JSON of a Land |


#### Get Flughafen from one Land

```http
  GEt /api/v2/laender/ID/flughafen  
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `void` | Put the ID number of a Land in the URL |


### UserRestController (Admin)

#### Get Userlist

```http
  GET /api/v1/admin
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `List<UserDto>` | returns a list of Users|

#### Post a User 

```http
  POST /api/v1/admin/ID
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `UserDto` | Put a ID of a User in the URL|


#### Delete a User

```http
  DELETE  /api/v1/admin/ID
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `void` | Put the ID number of a User in the URL|


### UserWebController (Admin)

#### Get Userlist

```http
  GET /userlist  
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `none`      | `String` | Shows the Userlist in the browser |

#### Get Adminseite

```http
  GET /admin
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `String` | Only an Admin can access the Pages & Subpages|

#### Get Passagierseite

```http
  GET /passagier
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `none`      | `String` | Only an Passagier can access the Pages & Subpages |


#### Check loggedin

```http
  GET /logedin
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `none`      | `String` | Passager and Admin can access the Pages & Subpages |









