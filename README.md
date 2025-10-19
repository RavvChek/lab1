# Information Security Lab #1, ITMO SE (Spring Boot/Java)

---

# Методы API

## 1. POST /auth/login -- Аутентификация пользователя

Описание:
Метод принимает логин и пароль пользователя. В случае успешной аутентификации возвращает JWT-токен.

Request:

POST /auth/login

```
{
  "username": "user",
  "password": "password"
}
```

Response (JSON):

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5...",
  "isAdminRole": "false"
}

Ошибки:

* 403 Forbidden -- если логин/пароль неверны.

---

## 2. GET /api/data -- Получение списка локаций

Описание:
Возвращает список сущностей Location. Доступ только для аутентифицированных пользователей (с валидным JWT).

Request:

GET /api/data/list
Authorization: Bearer <JWT>

Response (JSON):

[
  {
    "id": 0,
    "x": 0,
    "y": 0,
    "z": 0,
    "name": "sample_name",
    "description": "sample_desctiption"
  }
]

Ошибки:

* 403 Forbidden -- если отсутствует или невалиден JWT.

---

## 3. POST /api/data -- Добавление новой локации

Описание:
Добавляет новую сущность Location в список. Доступ только для аутентифицированных пользователей.

Request:

POST /api/data
Authorization: Bearer <JWT>

{
  "id": 0,
  "x": 0,
  "y": 0,
  "z": 0,
  "name": "string",
  "description": "string"
}

Response:

OK

Ошибки:

* 400 Bad Request -- если данные невалидны.
* 403 Forbidden -- если отсутствует или невалиден JWT.

# Меры защиты

API использует JWT-токены для защиты эндпоинтов.

* Пользователь проходит аутентификацию через POST /auth/login.
* В ответ получает accessToken (JWT).
* Для доступа к защищённым эндпоинтам необходимо передавать токен в заголовке:

Authorization: Bearer <JWT>

## Противодействие SQL Injection (SQLi)

* Используется Spring Data JDBC, который применяет параметризованные запросы → данные подставляются безопасно, без конкатенации SQL-строк.
* Таким образом, классические SQLi невозможны.

## Противодействие XSS

* REST API возвращает только JSON и не исполняет JavaScript.
* Устанавливаются заголовки HTTP X-XSS-Protection: 1; mode=block и Content-Security-Policy: script-src 'self'

## Реализация аутентификации

* Используется JWT-токен, который подписывается секретным ключом.
* Токен проверяется middleware (Spring Security OncePerRequestFilter).
* Без токена доступ к защищённым эндпоинтам запрещён.

# Скриншот отчета OWASP
![dependency-check-report.png](dependency-check-report.png)
# Результат SpotBugs
<FindBugsSummary 
    num_packages='8' total_classes='23' total_size='430' 
    clock_seconds='3.27' referenced_classes='194'
    vm_version='21.0.8+9-LTS' total_bugs='0'
    java_version='21.0.8' gc_seconds='0.04'
    alloc_mbytes='512.00' cpu_seconds='10.67'
    peak_mbytes='234.59' timestamp='Mon, 13 Oct 2025 22:12:10 +0000'>
