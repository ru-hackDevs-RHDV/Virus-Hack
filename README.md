# Система удаленного мониторинга Smart GrowBoxes
---

## Main part's of project
* Мобильное приложение - VirusHackApplication
* Web(front part) - VirusHack
* Server - growboxProject
* ML - in server side
* ESP - main.ino

### Мобильное приложение как и web - позволяет увидеть состояние теплицы, расходы электричества и воды, а также даёт возможность клиенту изменить режим ухаживания за растениями.

# ESP controller code anatation
```
timer.run();
  
  if (WiFi.status()== WL_CONNECTED) {
        //var's
   HTTPClient temp; 
   HTTPClient humid;
 
   temp.begin("server_url/temperature");
   temp.addHeader("Content-Type", "text/plain");
   int httpCode = temp.POST(temperature); //get req on server side
   String payload = temp.getString();
   Serial.println(httpCode);
   Serial.println(payload);  
   temp.end();

   humid.begin("server_url/humidity"); //post res on server side
   humid.addHeader("Content-Type", "text/plain");
   int httpCode = humid.POST(humidity);
   String payload = humid.getString();
   Serial.println(httpCode);
   Serial.println(payload);  
   humid.end();
```

# Server Side
GrowBox

```sh
$ virtualenv env
$ source env/bin/activate
$ cd GreenDoubt
$ pip3 install -r requirements.txt
$ cd growboxProject
```
### В файле GreenDoubt/growboxProject/growboxProject/settings.py  в строке 63 заменить путь на свой полный путь к файлу GreenDoubt/my.cnf
```
$ python3.7 manage.py runserver
```

### 127.0.0.1/main - GET - возвращает render html с наполнением
        content = {
            'name' - имя пользователя,
            'grow_box_id' - лист с номерами всех его теплиц,
        }
### 127.0.0.1/main/set_grow_box - GET(пока что) - принимает в себя номер новой теплицы + номера всех её частей
                                grow_box_id
                                light_ident
                                DHT22_ident
                                WaterShare_ident
                                CO2_ident
                                humidity_of_earth_ident
                                temperature_ident
### 127.0.0.1/main/get_all - GET - принимает номер теплицы о которой необходимы данные
### - возвращает json из json-ов вида:

                 {
                    "light": "{
                        \"ident\": 1,
                        \"status\": \"OFF\"
                        }",
                    "DHT22": "{
                        \"ident\": 2,
                        \"humidity\": 1001.0
                        }",
                    "WaterShare": "{
                        \"ident\": 3,
                        \"status\":
                        \"OFF\"}",
                    "CO2": "{
                        \"ident\": 12,
                        \"cou2_proc\": 0.0
                        }",
                    "humidity_of_earth": "{
                        \"ident\": 5,
                        \"humidity\": 0.0
                        }",
                    "temperature": "{
                        \"ident\": 6,
                        \"_temperature\": 0.0
                        }"
                 }

### 127.0.0.1/main/pomp_action - действие помпы
            ON - включить
            OFF- выключить
### 127.0.0.1/main/light_action -  действие лампы
            ON - включить
            OFF- выключить
### Вход и т.д. стандартный для джанги через 127.0.0.1/auth
    path('login/', views.LoginView.as_view(), name='login'),
    path('logout/', views.LogoutView.as_view(), name='logout'),
    path('password-reset/', views.PasswordResetView.as_view(), name='password_reset'),
    path('password-reset/done/', views.PasswordResetDoneView.as_view(), name='password_reset_done'),
    path('reset/<uidb64>/<token>/', views.PasswordResetConfirmView.as_view(), name='password_reset_confirm'),
    path('reset/done/', views.PasswordResetCompleteView.as_view(), name='password_reset_complete'),
    path('password-change/', views.PasswordChangeView.as_view(), name='password_change'),
    path('password-change/done/', views.PasswordChangeDoneView.as_view(), name='password_change_done'),
######    пример - 127.0.0.1/auth/login
гугл в помощь и вперед
### 127.0.0.1/auth/signup - регистрация - содержит поля
    'username'
    'password1'
    'password2'
