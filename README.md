# Java Organiser project
В данном проекте реализован консольный огранайзер, в который можно добавлять пользователей и объединять их в команды, ставить задачи как определенный пользователям системы, так и всем участникам команды.
Задачи могут состоять из дерева различных подзадач с различными дедлайнами и описаниями.

## Установка и запуск

 ```
 gradle build | gradle run -q
 ```
 
 ## Интерфейс и инструкция использования органайзера
 
 При запуске программы, ползователя встечает строка, ждущая ввода команды:
 ```
 Enter command (\h for help):
 ```
 При вводе \h, выводится список команд:
 ```
  \au - add user
 \at - add team
 \atask - add task
 \addtask2team - add task
 \addtask2user - add task
 \addsubtask - add subtask
 \adduser2team - add user to team
 \showusers  - show user list
 \showteams  - show team list
 \showtasks  - show task list
 \sts  - show team schedule
 \sus  - show user schedule
 \h  - show this message
 \q  - close
 ```
 
 ### Команды
 - \au - добавляет нового пользователя по его имени
 - \at - добавляет новую команду по названию команды 
 - \adduser2team - добавляем пользователя в команду, используя имя пользователя и имя команды 
 - \atask - добавляет новое задание в пул, можно заполнить название задание, его описание и срок выполнения 
 - \addsubtask - добавляет подзадачу
 - \addtask2team и \addtask2user - добавляют задачи команде и юзеру соответственно
 - \showusers, \showteams и \showtasks - показывают список уже существующих пользователей, команд и заданий
 - \sts и \sus - показывает расписания команды и пользователя
 
 C помощью \q можно выйти из программы
 
