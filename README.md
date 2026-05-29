# TaskFlow - Aplikacja do Zarządzania Zadaniami

REST API napisane w Spring Boot, służące do zarządzania projektami i przypisanymi do nich zadaniami. Aplikacja wykorzystuje architekturę trójwarstwową, zabezpieczenia oparte na tokenach JWT oraz relacyjną bazę danych PostgreSQL uruchamianą w środowisku Docker.

##  Wykorzystane Technologie

* **Java 17**
* **Spring Boot 3.x** (Web, Data JPA, Security, Validation)
* **PostgreSQL** (Baza danych)
* **Docker & Docker Compose** (Konteneryzacja bazy danych)
* **JSON Web Token (JWT)** (Autentykacja i autoryzacja)
* **Lombok** (Generowanie kodu)
* **Maven** (Zarządzanie zależnościami)

##  Architektura i Założenia

* **Architektura trójwarstwowa:** Controller -> Service -> Repository.
* **Wzorzec DTO:** Rozdzielenie logiki biznesowej od warstwy prezentacji. Encje JPA nigdy nie opuszczają warstwy serwisu.
* **Globalna obsługa wyjątków:** Wykorzystanie `@RestControllerAdvice` do unifikacji i czytelności zwracanych błędów HTTP.
* **Security:** Zabezpieczenie ścieżek `/api/projects/**` oraz `/api/tasks/**`. Brak stanów sesji (Stateless).

##  Uruchomienie Projektu Lokalnie

Postępuj zgodnie z poniższymi instrukcjami, aby uruchomić aplikację na swoim komputerze.

### Wymagania wstępne

1. Zainstalowana **Java 17** (lub nowsza).
2. Zainstalowany **Docker** oraz **Docker Compose**.


Projekt wykorzystuje konteneryzację do obsługi bazy danych PostgreSQL. Aby uruchomić bazę, otwórz terminal w głównym folderze projektu (tam, gdzie znajduje się plik `docker-compose.yml`) i wpisz:

```bash
docker-compose up -d
```
Kompilacja i Uruchomienie Aplikacji:
```bash
./mvnw spring-boot:run
```

Zatrzymywanie środowiska.

Aby wyłączyć aplikację, wciśnij Ctrl + C w terminalu z uruchomionym Springiem. Aby zatrzymać i usunąć kontener z bazą danych, wpisz:
```bash
docker-compose down
```