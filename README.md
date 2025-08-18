# Проект по автоматизации тестирования сайта [kinorium.com](https://ru.kinorium.com)

![Kinorium Banner](assets/img/kinorium.png)

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>
* <a href="#jenkins">Сборка в Jenkins</a>
* <a href="#console">Запуск из терминала</a>
* <a href="#allure">Allure отчет</a>
* <a href="#telegram">Уведомление в Telegram </a>
* <a href="#video">Видео примера запуска тестов в Selenoid</a>
____

<a id="tools"></a>
## **Технологии и инструменты**

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="assets/img/logo/Intelij_IDEA.svg"></a> 
<a href="https://www.java.com/ru/"><img width="6%" title="Java" src="assets/img/logo/Java.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="assets/img/logo/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="assets/img/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework"><img width="6%" title="Allure Report" src="assets/img/logo/Allure.svg"></a>
<a href="https://qameta.io/"><img width="6%" title="Allure TestOps" src="assets/img/logo/Allure2.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="assets/img/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="assets/img/logo/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="assets/img/logo/Github.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="assets/img/logo/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="assets/img/logo/Telegram.svg"></a>
</p>


- Язык программирования:
    - [Java](https://www.java.com/)
- Фреймворки для тестирования:
    - [Selenide](https://selenide.org/)
    - [JUnit 5](https://junit.org/)
- Сборка и управление зависимостями: [Gradle](https://gradle.org/)
- Запуск браузеров в [Selenoid](https://aerokube.com/selenoid/) при прогоне тестов
- CI/CD: [Jenkins](https://www.jenkins.io/) (реализована джоба для удаленного запуска тестов с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота)

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

____
<a id="jenkins"></a>
## <img width="4%" style="vertical-align:middle" title="Jenkins" src="assets/img/logo/Jenkins.svg"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/036-ConstantinBesson-unit14)

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code> и нажать кнопку <code>Собрать</code>.

<img title="Jenkins Build" src="assets/img/screenshots/jenkins.png">

____
<a id="console"></a>
## Запуск из терминала

```
./gradle clean test
```
При выполнении команды, тесты запустятся удаленно в [Selenoid](https://aerokube.com/selenoid/).

<code>clean</code> — удаляет каталог `build/` в проекте (все скомпилированные классы, отчёты, кэш тестов, временные файлы);

<code>test</code> — запускает задачу тестирования Gradle, которая:

- компилирует тесты и основной код;
- запускает тесты (JUnit, TestNG и т.д.);
- формирует отчёты (например, `build/reports/tests/test/index.html`).

***Удаленный запуск через Jenkins***

```
clean test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DremoteUrl=${REMOTE_URL}
```
***Параметры сборки в Jenkins***

- `browser` - браузер, в котором выполнятся тесты
- `browserVersion` - версия браузера
- `browserSize` - размер окна браузера, в котором будут выполняться тесты
- `remoteUrl` - полный адрес удаленного сервера, на котором будут запускаться тесты
- `remoteDomain` - адрес удаленного сервера, на котором будут запускаться тесты, для прикрепления видео к отчету
- 
____
<a id="allure"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="assets/img/logo/Allure.svg"> Пример [Allure-отчета](https://jenkins.autotests.cloud/job/036-ConstantinBesson-unit14/5/allure)

<img title="Allure Overview" src="assets/img/screenshots/allure_report.png">

В отчете Allure представлены результаты тестирования с общей статистикой.
____
<a id="telegram"></a>
## <img width="4%" style="vertical-align:middle" title="Telegram" src="assets/img/logo/Telegram.svg"> Уведомления в Telegram

После завершения сборки бот, созданный в Telegram, автоматически обрабатывает и отправляет сообщение с результатом.

<img width="70%" title="Telegram Notifications" src="assets/img/screenshots/tg_bot.png">

____
<a id="video"></a>
## <img width="4%" style="vertical-align:middle" src="assets/img/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.

<img title="Selenoid Video" src="assets/video/video.gif">