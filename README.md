<p align="center">
      <a href="https://pikabu.ru/">
        <img title="Pikabu" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/pikabu/Pikabu_Logo.png" />
    </a>
</p>

<h1>В проекте реализованы тесты для сайта Pikabu</h1>
Проект создан в рамках обучения в школе QA.GURU и представляет из себя часть выпускной работы.
  
## Оглавление
+ [Стек проекта](#projectStack)
+ [Архитектура проекта](#projectArchitecture)
+ [Запуск тестов](#runningTests)
    + [Запуск тестов локально](#runningTestsLocal)
    + [Запуск тестов в Jenkins](#runningTestsJenkins)
+ [Результаты](#results)
  + [Allure отчет о прохождении тестов](#resultsAllure)
  + [Результаты тестирования в TMS](#resultInTms)
  + [Результаты в Jira](#resultsInJira)
  + [Сценарии тестирования в TMS](#testCaseInTms)
  + [Уведомления](#resultNotification)
  + [Видео прохождения тестов](#resultVideo)

    
<h2><a name='projectStack'>:cookie:Стек проекта:</a></h2>
<p align="center">
    <a href="#"><img title="Java" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/java.svg" width="30px"/></a>
    <a href="#"><img title="Gradle" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Gradle.svg" width="50px"/></a>
    <a href="#"><img title="JUnit5" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/JUnit5.svg" width="50px"/></a>
    <a href="#"><img title="Selenide" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Selenide.svg" width="50px"/></a>
    <a href="#"><img title="Allure_Report" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Allure_Report.svg" width="50px"/></a>
    <a href="#"><img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Jenkins.svg" width="50px"/></a>
    <a href="#"><img title="Selenoid" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Selenoid.svg" width="50px"/></a>
    <a href="#"><img title="Allure Test Ops" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/AllureTestOps.svg" width="50px"/></a>
</p>

<ul>
	<li>Java - используется как основной язык для написания тестов</li>
	<li>Gradle - используется для сборки проекта</li>
	<li>Junit5 - тестовый фремворк</li>
	<li>Selenide - библиотека для работы с UI элементами страницы</li>
	<li>Allure - для формирования отчетов</li>
	<li>Jenkins - используется для запуска тестов</li>
	<li>Selenoid - используется для создания контейнеров для прохождения тестов</li>
	<li>AllureTestOps - система управления тестовыми сценариями</li>
</ul>



<h2>:cookie:<a name='projectArchitecture'>Архитектура проекта</a></h2>
Архитектура проекта состоит из 5 основных модулей
<ol>
    <li>
        <b>OwnerConfig</b> - конфигурационные файлы проекта, в которых может содержаться информация о среде выполнения теста и данные необходимые для работы теста.
        Данные для конфига берутся из .properties файла в ресурсах проекта, а так же из параметров запущенного теста.
    </li>
    <li>
        <b>BaseTest</b> - базовый класс с конфигурацией от которого наследуются все классы с тестами. Содержит методы BeforeEach и AfterEach.
    </li>
    <li>
        <b>Test</b> - класс описывающий логику работы теста основываясь на бизнесс требованиях.
    </li>
    <li>
        <b>PageObjects</b> - класс для описания страницы приложения. Поля класса объявляются как приватные константы и описывают селекторы для необходимых элементов.
        Взаимодействие с классом происходит за счет публичных методов класса, использующих ранее описанные селекторы.
    </li>
    <li>
        <b>PageElements</b> - класс для описания логики работы с часто используемыми элементами страницы. (ComboBox, Calendar...)
    </li>
</ol>

```mermaid
flowchart LR
    classDef class1 fill:#ffe0a1
    classDef class2 fill:#f3f76a
    classDef class3 fill:#feffd4
    
	A[Test]:::class1 -.Использует.-o B[PageObject]:::class2
	B -.Использует.-o C[PageElements]:::class3
	A -.Берет данные из.-x D[OwnerConfig]
	A --Наследуется от--> E[BaseTest]:::class1
	E -.Берет данные из.-x D
```

<h2>:cookie:<a name='runningTests'>Запуск тестов</a></h2>

<h3>:cookie:<a name='runningTestsLocal'>Запуск тестов локально</a></h3>

Для запуска тестов локально используется команда : <b>gradle clean parallelRegress</b>

<p><b>-DforkCount</b> - количество потоков для запуска теста</p>
<p><b>-Dbrowser</b> - браузер для запуска теста</p>

Для работы тестов подразумевающих авторизацию в системе нужно дополнительно указать параметры:
<p><b>-Dlogin</b> - логин для Pikabu</p>
<p><b>-Dpassword</b> - пароль для Pikabu</p>
<p>P.S. Либо прописать их в конфигурационном файле <b>resources/config/userConfig.properties</b></p>

Так же необходимо указать токен бота и чат в который должны приходить уведомление в телеграмм. Для этого нужно
отредактировать файл: <b>notifications/telegram.json</b>


<h3>:cookie:<a name='runningTestsJenkins'>Запуск тестов в Jenkins</a></h3>
В качестве CI для тестов используется Jenkins, запуск тестов осуществляется в контейнерах Selenoid.

Для запуска тестов нужно создать параметризированную джобу. 
<p>1. В качестве параметров были выбраны</p>
<p><b>-DforkCount</b> - количество потоков для запуска теста</p>
<p><b>-Dbrowser</b> - браузер для запуска теста</p>

<p>2. По результатам прохождения тестов формируются Allure отчет, а так же происходит интеграция результатов в TMS AllureTestOps</p>

<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/1.PNG.png" />
</p>

<h2>:cookie:<a name='results'>Результаты</a></h2>
<h3>:cookie:<a name='resultsAllure'>Allure отчет о прохождении тестов</a></h3>
На освнове результатов тестов формируется красивый Allure отчет. По которому можно посмотреть как прошли тесты и быстро определить
где была ошибка в случае ее обнаружения.

<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/2.PNG" />
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/4.PNG" />
</p>

<h3>:cookie:<a name='resultsInTms'>Результаты в TSM</a></h3>
После прохождения тестов, результаты автоматически имопртируются в TMS, где их может посмотреть любой участник команды.
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/5.PNG" />
</p>

<h3>:cookie:<a name='resultsInJira'>Результаты в Jira</a></h3>
Результаты из TMS имопртируются в задачу Jira
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/8.png" />
</p>

<h3>:cookie:<a name='testCaseInTms'>Сценарии тестирования в TMS</a></h3>
На освное написанных тестов, в системе управления тестовыми сценариями автоматически были созданы тест кейсы для пройденных тестов.
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/6.PNG" />
</p>


<h3>:cookie:<a name='resultNotification'>Уведомления</a></h3>
Чтобы узнавать о результатах прохождения тестов, не обязательно постоянно следить за тестпланом в TMS или джобой в Jenkins.
В проекте настроены уведомления в телеграм, при помощи библиотеки <b>https://github.com/qa-guru/allure-notifications</b>

<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/7.PNG" />
</p>

<h3>:cookie:<a name='resultVideo'>Видео прохождения тестов</a></h3>
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/pikabu.gif" />
</p>
